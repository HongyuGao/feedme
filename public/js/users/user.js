/**
 * @author Danyang Li
 */
var emailValidate=false;

/**Information Validation**/
function emptyVal(param){
	var value=jQuery.trim(param.value);
	if(value==""){
		validationInfo(param.name,"It can't be blank");
		return false;
	}
	else{
		validationInfo(param.name,"");
		return true;
	}
}

function emailVal(email){
	var emailStr=jQuery.trim(email.value);
	if(emailStr==""){
		validationInfo(email.name,"Email can't be blank");
		emailValidate=false;
	}
	else{
		reg=/^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/gi;
		if(!reg.test(emailStr)){
			validationInfo(email.name,"Email is invalid");		
			emailValidate=false;
		}
		else{
			var restUrl="users/checkEmail?email="+emailStr;
			restGet(restUrl, "GET", renderEmailCheck,"#eVal")
		}
	}
}	

function pwdVal(cpwd){
	if(cpwd.value!=jQuery("#pwd").val()){
		validationInfo(cpwd.name,"Password doesn't match the confirmation");
		return false;
	}
	else{
		validationInfo(cpwd.name,"");
		return true;
	}	
}

function validationInfo(disDiv,disInfo){
	document.getElementById(disDiv).style.display="block";
	document.getElementById(disDiv).innerHTML=disInfo;	
	//jQuery("#"+disDiv).html(disInfo);		
}

/**POST**/
function signUp() {
	var titleValue=jQuery("#title option:selected").val();
	var bodValue=jQuery("#bod").val();
	var plValue=jQuery("#pl option:selected").val();	
	var fname=document.getElementById("fname");
	var lname=document.getElementById("lname");
	var email=document.getElementById("email");
	var pwd=document.getElementById("pwd");
	var cpwd=document.getElementById("cpwd");
	var tel=document.getElementById("tel");	
	emailVal(email);
	if(emailValidate==true&&emptyVal(fname)&&emptyVal(lname)&&emptyVal(pwd)&&emptyVal(tel)&&pwdVal(cpwd)){
		var hashpwd=md5(pwd);
		var user=new Object();
		user.email=email.value;
		user.firstname=fname.value;
		user.lastname=lname.value;
		user.title=titleValue;
		user.birthday=bodValue;
		user.password=hashpwd;
		user.phoneNumber= tel.value;
		user.preferedLanguage=plValue;
		var postData = JSON.stringify(user);
		restSet("/users/register", "POST", postData, renderSignUp,"#signInfo");
	}
	else{
		var errorInfo="There were problems creating your account";
		validationInfo("signInfo",errorInfo);
	}    
}
/*PUT*/
function updateUser() {
    var userName = jQuery.trim(jQuery("#userName").val());
    var password = jQuery("#password").val();
    var hashPassword = md5(password);
    var userRole = jQuery("#role").val();
    var putData = JSON.stringify({userName: userName, passWord: hashPassword, userRole: userRole});
    restSet(ATUP_USER_URI + USER_PATH, PUT_METHOD, putData, renderUpdate);
}
/*GET*/
function signIn() {
    var userName = jQuery("#userName").val();
    var password = jQuery.trim(jQuery("#password").val());
    var hashPassword = md5(password);
    var url = ATUP_USER_URI + SIGNIN_PATH + "?user=" + userName + "&password=" + hashPassword;
    restGet(url, GET_METHOD, renderSignIn);
}
/*RENDER*/
function renderEmailCheck(data){
	if(data.errorInfo=="N"){
		emailValidate=false;
		validationInfo(email.name,"Email is already token");
	}else if(data.errorInfo=="Y"){
		emailValidate=true;
		validationInfo(email.name,"");
	}else{
		emailValidate=false;
		validationInfo(email.name,"Unkown Error");
	}
	
}

function renderSignUp(data) {
    jQuery("#signInfo").html("id=" + data.userId);
}
function renderUpdate(data) {
    var usersDiv = jQuery("#usersDiv");
    usersDiv.html("<div><span style='width:100px;display:inline-block;'>User ID</span>");
    usersDiv.append("<span style='width:100px;display:inline-block;'>User Name</span>");
    usersDiv.append("<span style='width:100px;display:inline-block;'>User Role</span></div>");
    usersDiv.append("<div><span style='width:100px;display:inline-block;'>");
    usersDiv.append(data.userId);
    usersDiv.append("</span><span style='width:100px;display:inline-block;'>");
    usersDiv.append(data.userName);
    usersDiv.append("</span><span style='width:100px;display:inline-block;'>");
    usersDiv.append(data.userRole);
    usersDiv.append("</span></div>");
}
function renderSignIn(data) {
    if (data.userId != null && data.userName != null && data.userRole != null) {
        storage.setItem("userId", data.userId);
        storage.setItem("userName", data.userName);
        storage.setItem("userRole", data.userRole);
        window.location.href = "index.html";
    } else {
        //TODO
    }
}