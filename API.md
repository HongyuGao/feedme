
# kkkkkkk

kkk

* sdfsdf
*sdfsdf


[TOC]

kkkk
=========
1111
---------
lllllllllllllllllllll


111111
===========
2222222222
---------------
tttttttttttttttt

555555555555
==============
6
-------------
test
[an example][id] 

[id]: http://example.com/  "Optional Title Here"

<ul id="tree" class="ztree"></ul><article class='markdown-body'>
写内容 
kkkkk
</article>
<script type="text/javascript" src="http://i5ting.github.io/git-quick-start/preview/js/jquery-1.10.2.min.js"></script><script type="text/javascript" src="http://i5ting.github.io/git-quick-start/preview/js/jquery.ztree.all-3.5.min.js"></script><script type="text/javascript" src="http://i5ting.github.io/git-quick-start/preview/js/jquery.ztree_toc.js"></script>
<SCRIPT type="text/javascript" > <!-- $(document).ready(function(){ $('#tree').ztree_toc({ is_auto_number:true, documment_selector:'.markdown-body', ztreeStyle: { width:'260px', overflow: 'auto', position: 'fixed', 'z-index': 2147483647, border: '0px none', left: '0px', top: '0px' } }); }); //--> </SCRIPT> 

MarkDown实现
生成目录的方法:

* [1.语法示例](#1) * [1.1图片](#1.1) * [1.2换行](#1.2) * [1.3强调](#1.3)
生成效果:

1.语法示例

1.1图片
1.2换行
1.3强调
在正文中，只要将章节标题的id对应上去即可:

<h2 id="1">1.语法示例</h2> 这是第一段 这是第一段 这是第一段 这是第一段 这是第一段 <h3 id="1.1">1.1图片</h3> 这是第一段第一节 这是第一段第一节 这是第一段第一节 这是第一段第一节 这是第一段第一节 <h3 id="1.2">1.2换行</h3> 这是第一段第二节 这是第一段第二节 这是第一段第二节 这是第一段第二节 这是第一段第二节 <h3 id="1.1">1.3强调</h3> 这是第一段第三节 这是第一段第三节 这是第一段第三节 这是第一段第三节 这是第一段第三节
1.语法示例

这是第一段

这是第一段

这是第一段

这是第一段

这是第一段

1.1图片

这是第一段第一节

这是第一段第一节

这是第一段第一节

这是第一段第一节

这是第一段第一节

1.2换行

这是第一段第二节

这是第一段第二节

这是第一段第二节

这是第一段第二节

这是第一段第二节

1.3强调

这是第一段第三节

这是第一段第三节

这是第一段第三节

这是第一段第三节

这是第一段第三节

点击目录，发现可以页内跳转了。

2. html标签实现

定义一个锚(id)： <span id="jump">跳转到的地方</span>
使用markdown语法： [点击跳转](#jump)
在文章末尾设置一个锚，然后跳转到文章开始的地方。

点击跳转
