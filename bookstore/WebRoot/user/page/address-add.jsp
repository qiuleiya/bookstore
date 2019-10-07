<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="tedu.cn.pojo.User"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <% 
    	//动态的获取项目的映射路径,拼接完成的项目路径
    	String path=request.getContextPath();
    	//http://localhost:8080/store_project/
    	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href='<%=basePath%>'>
    <title>我的订单 - 达内学子书城</title>
    <link href="user/css/my.order.css" rel="stylesheet" />
    <link href="user/css/header.css" rel="stylesheet" />
    <link href="user/css/footer.css" rel="stylesheet" />
    <link href="user/css/set.css" rel="stylesheet" />
</head>
<body>
<div id="header">
    <!-- 头部-->
    <header id="top">
        <div id="logo" class="lf">
            <img class="animated jello" src="user/img/header/logo.png" alt="logo"/>
        </div>
        <div id="top_input" class="lf">
            <input id="input" type="text" placeholder="请输入您要搜索的内容"/>

            <a href="user/page/search.html?title=Java" class="rt"><img id="search" src="user/img/header/search.png" alt="搜索"/></a>
        </div>
        <div class="rt">
        <ul class="lf">
          <li><a href="${pageContext.request.contextPath}/servlet/AllBookServlet">首页</a><b>|</b>
				</li>
				<li><a href="${pageContext.request.contextPath}/servlet/AllCollectServlet">收藏</a><b>|</b>
				</li>
				<li><a href="allOrderServlet">订单</a><b>|</b>
				</li>
				<li><a href="${pageContext.request.contextPath}/servlet/AllCartServlet">购物车</a><b>|</b>
				</li>
				<li><a href="user/page/password-change.jsp">设置</a><b>|</b>
				</li>
				<li><a href="${pageContext.request.contextPath}/servlet/userLogoutServlet">退出</a><b>|</b>
				</li>
				<li><a href="user/page/lookforward.html">帮助</a>
				</li>
        </ul>
    </div>
    </header>
    <!-- 主导航-->

    <!-- 主导航-->
    <nav id="nav1">
        <!-- 我的订单导航栏-->
        <div id="nav_order" class="lf">
            <ul>
                <li></li>
            </ul>
        </div>
    </nav>
</div>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <div id="leftsidebar_box" class="lf">
        <div class="line"></div>
        <dl class="my_order">
            <dt onClick="changeImage()">帐号管理<img src="user/img/myOrder/myOrder1.png"></dt>
            <dd class="first_dd"><a href="user/page/password-change.jsp">修改密码</a></dd>
            <dd><a href="user/page/address-add.jsp">添加地址</a></dd>
        </dl>

    </div>
    <!-- 右边栏-->
    <div class="rightsidebar_box rt" >
        <div class="order_empty">
         <div id="cover" class="rt">
      <form id="fm-add" method="post" name="form1">
            <div class="txt">
                <p>添加地址
                    <span>
                        <a href="user/page/index.jsp">继续购物</a>
                    </span>
                </p>
                <div class="text">
                    <input type="text" placeholder="收件人" name="receiver" id="receiver" required>
                    <span></span>
                </div>
                <div class="text">
                    <input type="text" placeholder="地址" id="address" name="address" required minlength="6" maxlength="25">
                    <span></span>
                </div>
				<div class="text">
                    <input type="text" placeholder="联系电话" id="rphone" name="rphone" required minlength="11" maxlength="11">
                    <span></span>
                </div>
                <input class="button_login" type="button" value="添加" id="bt-add" />
            
            </div>
        </form>
        </div>
        </div>
    </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="user/img/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="user/img/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="user/img/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="user/img/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
             <p class="footer1"><img src="user/img/footer/tedu.png" alt="" class=" footLogo"/></p>
             <p class="footer2"><img src="user/img/footer/footerFont.png"alt=""/></p>
            <!-- 页面底部-备案号 #footer -->
            <div class="record">
                2001-2016 版权所有 京ICP证8000853号-56
            </div>
        </div>
        <div class="foot_left lf" >
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="user/img/footer/wechat.png" alt=""/>
                    <img src="user/img/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>达内商城客户端</p>
            <img src="user/img/footer/ios.png" class="lf">
            <img src="user/img/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="user/img/footer/erweima.png">
        </div>
    </div>
</div>

</body>
<script src="user/js/jquery-3.4.1.min.js"></script>
<script src="user/js/index.js"></script>
<script src="user/js/jquery.page.js"></script>
<script src="user/js/order.js"></script>
<script type="text/javascript">
$('#bt-add').click(function(){
    //读取用户的输入——表单序列化
    var inputData = $('#fm-add').serialize();
	  console.log(">>>"+inputData);
	  
    //异步提交请求
    $.ajax({
    	async: true,
        type: 'POST',
        url: '${pageContext.request.contextPath}/servlet/AddAddressServlet',
        data: inputData,
        success: function(txt, msg, xhr){
        	// alert("*"+txt+"*");
            if(txt=='yes'){
                alert("添加成功！");
                $('#fm-add').get(0).reset();
            }else{ //修改失败
            	alert("添加失败！");
            }
        }
    });
});
 ///$('#bt-add').click(function(){
    //   //; window.location.href =  "userLogin";
     //   $('#fm-add').submit();
    //});
</script>
</html>
