<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tedu.cn.pojo.Book,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>达内商城收藏夹</title>
<% 
   	// 动态获取项目映射路径，拼接成完成的项目路径
   	String path=request.getContextPath();
  	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  	%>
<!-- 设置当前页面的父路径为项目根路径,供浏览器将相对路径拼接成绝对路径，解决页面中相对路径的404问题 -->
<base href='<%=basePath %>'>
<link href="user/css/header.css" rel="stylesheet" />
<link href="user/css/my.collect.css" rel="stylesheet" />
<link href="user/css/footer.css" rel="stylesheet" />
</head>
<body>
	<!-- 页面顶部-->
	<header id="top">
		<div id="logo" class="lf">
			<img class="animated jello" src="user/img/header/logo.png" alt="logo" />
		</div>
		<div id="top_input" class="lf">
			<input id="input" type="text" placeholder="请输入您要搜索的内容" /> <a
				href="user/page/search.html?title=Java" class="rt"><img
				id="search" src="user/img/header/search.png" alt="搜索" />
			</a>
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
	<!-- nav主导航-->

	<div class="modal" style="display:none">
		<div class="modal_dialog">
			<div class="modal_header">删除提醒</div>
			<div class="modal_information">
				<img src="user/img/model/model_img2.png" alt="" /> <span>确定删除您的这个宝贝吗？</span>

			</div>
			<div class="yes">
				<span>删除</span>
			</div>
			<div class="no">
				<span>不删除</span>
			</div>
		</div>
	</div>
	<div class="modalNo" style="display:none">
		<div class="modal_dialog">
			<div class="modal_header">
				删除提示 <img src="user/img/model/model_img1.png" alt="" class="rt close" />
			</div>
			<div class="modal_information">
				<img src="user/img/model/model_img2.png" alt="" /> <span>请选择商品</span>

			</div>

		</div>
	</div>

	<div class="modalAdd" style="display:none">
		<div class="modal_dialog">
			<div class="modal_header">
				添加提示 <img src="user/img/model/model_img1.png" alt="" class="rt close" />
			</div>
			<div class="modal_information">
				<img src="user/img/model/model_img2.png" alt="" /> <span>请选择商品</span>

			</div>

		</div>
	</div>

	<div class="big">
		<form name="" action="" method="post">
			<section id="section">
				<div id="title">
					<b>收藏商品</b>
				</div>
				<div id="box">

					<div id="content_box">
						<%
			ArrayList<Book> books = (ArrayList<Book>)request.getAttribute("books");
			for (int i = 0; i < books.size() && books != null ; i++ ) {
				Book book = books.get(i);
			%>
						<div class="lf" id="d1">
							<div class="img">
								<a href="${pageContext.request.contextPath}/servlet/DetailServlet?isbn=<%=book.getIsbn()%>"> <img
									src="user/img/goods/<%=book.getIsbn() %>/collect.jpg" alt="" /> </a>
							</div>
							<div class="describe">
								<p><%=book.getTitle() %></p>
								<span class="price"><b>￥</b><span class="priceContent"><%=book.getPrice() %></span>
								</span> <span class="addCart"><a
									href="${pageContext.request.contextPath}/servlet/DetailServlet?isbn=<%=book.getIsbn()%>">查看</a>
								</span>
							</div>
						</div>
						<%}%>
					</div>
				</div>
			</section>

		</form>
		<div class="none" style="display: none">
			<div class="none_content">
				<img src="user/img/model/model_img3.png" alt="" class="lf" />
				<p class="lf">您的收藏夹竟然还是空哒( ⊙ o ⊙ )</p>
				<span class="lf">赶快去收藏商品吧！</span> <a href="#" class="lf">去购物>></a>
			</div>

		</div>
	</div>
	<!-- 品质保障，私人定制等-->
	<div id="foot_box">
		<div class="icon1 lf">
			<img src="user/img/footer/icon1.png" alt="" />

			<h3>品质保障</h3>
		</div>
		<div class="icon2 lf">
			<img src="user/img/footer/icon2.png" alt="" />

			<h3>私人定制</h3>
		</div>
		<div class="icon3 lf">
			<img src="user/img/footer/icon3.png" alt="" />

			<h3>学员特供</h3>
		</div>
		<div class="icon4 lf">
			<img src="user/img/footer/icon4.png" alt="" />

			<h3>专属特权</h3>
		</div>
	</div>
	<!-- 页面底部-->
	<div class="foot_bj">
		<div id="foot">
			<div class="lf">
				<p class="footer1">
					<img src="user/img/footer/tedu.png" alt="" class=" footLogo" />
				</p>
				<p class="footer2">
					<img src="user/img/footer/footerFont.png" alt="" />
				</p>
				<!-- 页面底部-备案号 #footer -->
				<div class="record">2001-2016 版权所有 京ICP证8000853号-56</div>
			</div>
			<div class="foot_left lf">
				<ul>
					<li><a href="#"><h3>买家帮助</h3>
					</a>
					</li>
					<li><a href="#">新手指南</a>
					</li>
					<li><a href="#">服务保障</a>
					</li>
					<li><a href="#">常见问题</a>
					</li>
				</ul>
				<ul>
					<li><a href="#"><h3>商家帮助</h3>
					</a>
					</li>
					<li><a href="#">商家入驻</a>
					</li>
					<li><a href="#">商家后台</a>
					</li>
				</ul>
				<ul>
					<li><a href="#"><h3>关于我们</h3>
					</a>
					</li>
					<li><a href="#">关于达内</a>
					</li>
					<li><a href="#">联系我们</a>
					</li>
					<li><img src="user/img/footer/wechat.png" alt="" /> <img
						src="user/img/footer/sinablog.png" alt="" /></li>
				</ul>
			</div>
			<div class="service">
				<p>达内商城客户端</p>
				<img src="user/img/footer/ios.png" class="lf"> <img
					src="user/img/footer/android.png" alt="" class="lf" />
			</div>
			<div class="download">
				<img src="user/img/footer/erweima.png">
			</div>
		</div>
	</div>

	<script src="user/js/jquery-3.4.1.min.js"></script>
	<script src="user/js/collect.js"></script>
	<script>
    //搜索下拉
    $('.seek').focus(function(){

        if($(this).hasClass('clickhover')){

            $(this).removeClass('clickhover');
            $(this).find('.seek_content').hide();
            $(this).find('img').attr('src','user/img/header/header_normal.png');

        }else{
            $(this).addClass('clickhover');
            $(this).find('.seek_content').show();
            $(this).find('img').attr('src','user/img/header/header_true.png');
        }
    })
    $('.seek_content>div').click(function(){
        $('.seek').removeClass('clickhover');
        var text=$(this).html();
        $('.seek span').html(text);
        $(this).parent().hide();
        $('.seek').find('img').attr('src','user/img/header/header_normal.png');
        $('.seek').blur();

    })

    $('.seek').blur(function(){

        $('.seek').removeClass('clickhover');
        $('.seek_content').hide();

        $('.seek').find('img').attr('src','user/img/header/header_normal.png');
        console.log(1);
    })
    
</script>
</body>
</html>
