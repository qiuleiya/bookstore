<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tedu.cn.pojo.Book,tedu.cn.pojo.User"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>达内商城学子详情页</title>
<% 
   	// 动态获取项目映射路径，拼接成完成的项目路径
   	String path=request.getContextPath();
  	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  	%>
<!-- 设置当前页面的父路径为项目根路径,供浏览器将相对路径拼接成绝对路径，解决页面中相对路径的404问题 -->
<base href='<%=basePath %>'>
<link href="user/css/header.css" rel="stylesheet" />
<link href="user/css/pro.details.css" rel="stylesheet" />
<link href="user/css/animate.css" rel="stylesheet" />
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
	<div>&nbsp;</div>
	<!-- 内容-->
	<% Book book = (Book)request.getAttribute("book");
   User user = (User)request.getSession().getAttribute("user");
%>
	<!--细节导航-->
	<div id="nav_detail">
		<h5><%=book.getTitle() %></h5>
	</div>
	<!--产品预览-->
	<div id="shop_detail">
		<!-- 左侧-->
		<div id="preview" class="lf">
			<div id="mediumDiv">
				<img id="mImg"
					src="user/img/goods/<%=book.getIsbn() %>/detail1big.jpg" />
			</div>
			<div id="icon_all">
				<ul id="icon_list">
					<li class="i1"><img
						src="user/img/goods/<%=book.getIsbn() %>/detail1.jpg" />
					</li>
					<li class="i1"><img
						src="user/img/goods/<%=book.getIsbn() %>/detail2.jpg"
						onerror="this.style.display='none'" style="display: none;"/>
					</li>
					<li class="i1"><img
						src="user/img/goods/<%=book.getIsbn() %>/detail3.jpg"
						onerror="this.style.display='none'" style="display: none;"/>
					</li>
					<li class="i1"><img
						src="user/img/goods/<%=book.getIsbn() %>/detail4.jpg"
						onerror="this.style.display='none'" style="display: none;"/>
					</li>
					<li class="li"><img
						src="user/img/goods/<%=book.getIsbn() %>/detail5.jpg"
						onerror="this.style.display='none'" style="display: none;"/>
					</li>
				</ul>
			</div>
		</div>
		<!-- 右侧-->
		<div class="right_detail lf">
			<!-- 图书名称-->
			<h1><%=book.getTitle() %></h1>
			<!-- 图书作者 -->
			<h3><%=book.getAuthor() %></h3>
			<!-- 价格部分-->
			<div class="price">
				<div id="pro_price">
					<b>价格：</b><span>￥<%=book.getPrice() %></span>
				</div>
				<div class="promise">
					<b>服务承诺：</b> <span>*退货补运费</span> <span>*30天无忧退货</span> <span>*48小时快速退款</span>
					<span>*72小时发货</span>
				</div>
			</div>
			<!-- 参数部分 客服-->
			<p class="parameter">
				<b>客服：</b> <span class="connect">联系客服</span><img class="gif"
					src="user/img/product_detail/kefuf.gif">
			</p>
			<!-- 出版社 -->
			<p class="style" id="choose_color">
				<s class="color">出版社：</s> <span><%=book.getPress() %></span>
			</p>
			<!-- 出版日期 -->
			<p>
				<s>出版日期：</s> <span><%=book.getPublished() %></span>
			</p>
			<!-- 未选择规格，颜色时状态-->
			<div class="message"></div>
			<!-- 数量-->
			<p class="accountChose">
				<s>数量：</s>
				<button class="numberMinus">-</button>
				<input type="text" value="1" class="number" id="buy-num">
				<button class="numberAdd">+</button>
			</p>
			<!-- 购买部分-->
			<div class="shops">
				<a href="#" class="buy lf" id="buy_now">立即购买</a> 
				<a href="javascript:void(0);"
					class="shop lf" id="add_cart"><img
					src="user/img/product_detail/product_detail_img7.png" alt="" />加入购物车</a>
				<a href="javascript:void(0);" class="collection lf" id="collect"><span>收藏</span>
				</a><b><img
					src='user/img/product_detail/product_detail_img6<%=request.getAttribute("isCollect") %>.png'
					alt="" />
				</b>
			</div>
		</div>
	</div>
	<!--为你推荐-->
	<div id="recommended">
		<p>
			为你推荐<span>大家都在看</span>
		</p>
		<div id="demo" style="width:1000px;overflow:hidden;">
			<div id="indemo" style="float: left;width: 200%;">
				<div id="demo1" style="float:left">
					<!-- 第一个宽度显示 -->
					<div class="detail_1 lf">
						<div class="detail_img1">
							<a href="user/page/detail.html?isbn=9787302435167"><img
								src="user/img/recommend/recommend_img1.jpg" border="0">
							</a>
						</div>
						<p>大数据架构师指南</p>
					</div>
					<div class="detail_1 lf">
						<div class="detail_img1">
							<a href="user/page/detail.html?isbn=9787115335500"><img
								src="user/img/recommend/recommend_img2.jpg" border="0">
							</a>
						</div>
						<p>深入浅出Node.js</p>
					</div>
					<div class="detail_1 lf">
						<div class="detail_img1">
							<a href="user/page/detail.html?isbn=9787111213826"><img
								src="user/img/recommend/recommend_img3.jpg" border="0">
							</a>
						</div>
						<p>Java编程思想</p>
					</div>
					<div class="detail_1 lf">
						<div class="detail_img1">
							<a href="user/page/detail.html?isbn=9787111545682"><img
								src="user/img/recommend/recommend_img4.jpg" border="0">
							</a>
						</div>
						<p>Linux运维最佳实践</p>
					</div>
					<!--</div>-->
				</div>
				<div id="demo2" style="float:left"></div>
			</div>
			<!-- 宽度超大 -->
		</div>
		<!-- 外面大框 -->
	</div>
	<!--商品详情-->
	<div id="iteminfo">
		<div id="tab">
			<div class="tab lf">
				<div class="cat">
					<span class="active"><a href="">商品详情</a>
					</span> <span><a href="user/page/lookforward.html">商品评价</a>
					</span>
				</div>
			</div>
			<div class="cart rt">
				<img src="user/img/product_detail/product_detail_img9.png" alt="" />
			</div>
		</div>
		<div class="left lf">
			<div class="all">
				<!--<p><img src="img_x/pin_logo.png" alt=""/></p>-->
				<div id="parm">
					<div id="specification_parameter">
						<p>
							规格参数 <img src="user/img/product_detail/product_detail_icon_1.png"
								alt="" class="ys5" />
						</p>
						<!--<img src="img_x/canshu.png" alt="" class="ys5"/>-->
					</div>
					<ul>
						<li><a href="#">图书编号：<%=book.getIsbn() %></a>
						</li>
						<li><a href="#">图书名称：<%=book.getTitle() %></a></li>
						<li><a href="#">作者：<%=book.getAuthor() %></a></li>
						<li><a href="#">价格：￥<%=book.getPrice() %></a>
						</li>
						<li><a href="#">出版社：<%=book.getPress() %></a>
						</li>
						<li><a href="#">版次：<%=book.getEdition() %></a>
						</li>
						<li><a href="#">出版日期：<%=book.getPages() %></a>
						</li>
						<li><a href="#">页数：<%=book.getPages() %></a>
						</li>
						<li><a href="#">字数：<%=book.getWords() %></a></li>
						<li><a href="#">包装：<%=book.getPackaging() %></a>
						</li>
						<li><a href="#">开本：<%=book.getFormat() %></a>
						</li>
						<li><a href="#">用纸：<%=book.getForm() %></a>
						</li>
					</ul>
				</div>
				<div id="product_introduction">
					<p>
						商品介绍 <img src="user/img/product_detail/product_detail_icon_4.png"
							alt="" class="ys5" />
					</p>
					<img src="user/img/goods/<%=book.getIsbn() %>/intro.jpg" alt="" />
				</div>
				<div id="sale_protection">
					<p>
						售后保障 <img src="user/img/product_detail/product_detail_icon_3.png"
							alt="" class="ys5" />
					</p>

					<div class="sale_content">
						<p class="paper" id="sale_protect">
							<img src="user/img/product_detail/product_detail_img16.png" alt="" />
							正品保障
						</p>

						<p class="content">达内学子商城向您保证所售商品均为正品行货，达内自营商品开具机打发票或电子发票。</p>

						<p class="paper">
							<img src="user/img/product_detail/product_detail_img16.png" alt="" />
							全国联保
						</p>

						<p class="content">
							凭质保证书及达内商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。达内商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！
							注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="right rt">
			<div class="aside_nav">
				<p>
					<i><img src="user/img/product_detail/product_detail_icon_g_1.png"
						alt="" />
					</i><a href="#specification_parameter">规格参数</a>
				</p>
				<p>
					<i><img src="user/img/product_detail/product_detail_icon_t_1.png"
						alt="" />
					</i><a href="#product_introduction">商品介绍</a>
				</p>
				<p>
					<i><img src="user/img/product_detail/product_detail_icon_d_1.png"
						alt="" />
					</i><a href="#sale_protection">售后保障</a>
				</p>
				<p>
					<i><img
						src="user/img/product_detail/product_detail_icon_up_1.png" alt="" />
					</i><a href="#">回到顶部</a>
				</p>
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
	<script src="user/js/index.js"></script>
	<!--图片轮播悬停进入详情页效果-->
	<script>
    var speed = 20;
    var tab = document.getElementById("demo");
    var tab1 = document.getElementById("demo1");
    var tab2 = document.getElementById("demo2");
    tab2.innerHTML = tab1.innerHTML;
    function Marquee() {
        if (tab2.offsetWidth - tab.scrollLeft <= 0)
            tab.scrollLeft -= tab1.offsetWidth
        else {
            tab.scrollLeft++;
        }
    }
    var MyMar = setInterval(Marquee, speed);
    tab.onmouseover = function () {
        clearInterval(MyMar)
    };
    tab.onmouseout = function () {
        MyMar = setInterval(Marquee, speed)
    };

    $(function () {
        var nav = $("#tab"); //得到导航对象
        var aside = $(".aside_nav");//右侧导航
        var win = $(window); //得到窗口对象
        var sc = $(document);//得到document文档对象。
        win.scroll(function () {
            if (sc.scrollTop() >= 1000) {
                nav.addClass("fixed_tab");
                aside.addClass("fixed_aside");
            }
            else {
                nav.removeClass("fixed_tab");
                aside.removeClass("fixed_aside");
            }
        })

        win.scroll(function () {
            if (sc.scrollTop() >= 60 && sc.scrollTop() < 1000){
                $("#top").addClass("fixed_nav");
            }
            else {
                $("#top").removeClass("fixed_nav");
            }
        })
        //介绍区域右侧导航
        $("#iteminfo .right p").click(function () {
            //$(this).addClass("clic").siblings().removeClass("clic");
            $(this).css("background-color", "#0AA1ED").siblings().css("background-color", "#e8e8e8");
            $(this).find("a").css("color", "#fff").parent().siblings().find("a").css("color", "#828282")
        })
        /**选择商品进行添加 悬停效果**/
        $(".avenge").mouseover(function () {
            $(this).css({"border": "1px solid #0AA1ED", "color": "#0AA1ED"});
        }).mouseout(function () {
            $(this).css({"border": "1px solid #666", "color": "#666"})
        })

        /**添加到收藏**/
        $("#collect").click(function (){
           //	console.log("collect");
           	$.ajax({
                type: "post",
                url: '${pageContext.request.contextPath}/servlet/CollectYesOrNoServlet',
                data: "uid=<%=user.getPhone()%> & isbn=<%=book.getIsbn()%>",
               	success: function (data) {
                    if (data == 'yes') {
                    	//alert("操作完成！");
                    	window.location.href = "${pageContext.request.contextPath}/servlet/DetailServlet?isbn=<%=book.getIsbn()%>";
                    } else {
                        alert("操作失败！");
                    }
                },
                error: function (data) {
                    alert("系统异常！");
                }
            });
        });
        /**数量添加**/
        var n = $("#buy-num").val() * 1;
        $(".numberMinus").click(function () {
            if (n >= 1) {
                $("#buy-num").val(n -= 1);
            }
        })
        $(".numberAdd").click(function () {
            $("#buy-num").val(n += 1);
        })

        /**ajax提交**/
        //数量选择
        $(".accountChose").click(function () {
            var buyAccount = $("#buy-num").val();
            console.log(buyAccount);
        })

        /*立即购买*/
        $("#buy_now").click(function (e) {
            var num = $("#buy-num").val();
            // 后台需要的参数
            var url = "user/page/order-confirm.html?product=9787115435101&count="+num;
            window.location.href = url;
        })
    });

    //加入购物车操作
    var buyAccount;
    $("#add_cart").click(function (e) {
        //数量取值
        buyAccount = $("#buy-num").val();
        console.log(buyAccount);
        var params = {
        	count: buyAccount,
        	product: <%=book.getIsbn()%>
        };
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/servlet/AddToCartServlet",
            data: params,
            //dataType:"json", 声明回调函数的值的类型
            success: function (data) {
                if (data == 'yes') {
                    alert("添加购物车成功！");
                    window.location.href ="${pageContext.request.contextPath}/servlet/AllCartServlet";
                } else {
                    alert("添加购物车失败！");
                }
            },
            error: function (data) {
                alert("系统异常！");
            }
        });
      /*   var url = "user/page/cart.html";
        window.location.href = url; */
    });

    // 图片效果
    $("#mImg").hover(function (){
        $(this).addClass("animated pulse");
    }, function (){
        $(this).removeClass("animated pulse");
    });

    $('#icon_list>li').click(function(){
        $(this).children('img').css('border','1px solid #CECFCE');
        var address=$(this).children().attr('src');
        console.log(address);
        var newaddress=address.slice(0,-4);
        var bigaddress=newaddress+'big.jpg';
        $('#mImg').attr('src',bigaddress);
        $(this).siblings().children('img').css('border','');
    })
</script>
</body>
</html>