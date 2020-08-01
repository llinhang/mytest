<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
	<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="m_ajax.js"></script>
</head>
<body>
	<div style="float: right;margin: 5px;">

	<a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
	<a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>

	</div>
	<table>
		<thead>
			<tr>
				<td><input type="checkbox" id="firstCb"></td>
				<td>编号</td>
				<td>姓名</td>
				<td>账号</td>
				<td>密码</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody id="tbody">
		</tbody>
	</table>






	<script type="text/javascript">
		//页面加载 默认应该第一页
		$(function() {
			init(1);
		});

		//5//////
		function init(currentPage) {
			$("#tbody").empty();
			var url = "loadUsersListPager";
			var data = {
				currentPage : currentPage
			};
			ajax(url, data, function(result) {
				//list,totalPage,currentPage,pageSize,start,
				var trs="";
				$.each(result.list, function(i, v) {
					//v即为对象，通过属性去访问值
					trs += "<tr>";
					trs += "<td>"+"<input type='checkbox' name='bid'>"+v.birdId+"</td>";
					trs += "<td>"+ v.birdId +"</td>";
					trs += "<td>"+ v.birdName +"</td>";
					trs += "<td>"+ v.birdAccount  +"</td>";
					trs += "<td>"+ v.birdPwd +"</td>";
					trs += "<td><a href='javascript:upd("+ v.birdId +")'>详细信息</a><a href='javascript:del("+ v.birdId +")'>删除</a></td>";
					trs += "</tr>";
				});
				//6/ 做上一页，需要注意判断是否是首页
				trs+="<tr>";
				trs+="<td colspan='5'>";
				if(result.currentPage==1){
					trs+="<a href='#'>«</a>";
				}else{
					//不是第一页
					trs+="<a href='javascript:pre("+(result.currentPage-1)+")'>«</a>";
				}
				
				if(result.currentPage==result.totalPage){
					trs+="<a href='#'>»</a>";
				}else{
					trs+="<a href='javascript:nxt("+(result.currentPage+1)+")'>»</a>";
				}
				trs+="</td></tr>";
				$("#tbody").append(trs);
			});
			
			
			
		}

		window.onload = function(){
			//给删除选中按钮添加单击事件
			document.getElementById("delSelected").onclick = function(){
				if(confirm("您确定要删除选中条目吗？")){
					var flag = false;
					//判断是否有选中条目
					var cbs = document.getElementsByName("bid");
					for (var i = 0; i < cbs.length; i++) {
						if(cbs[i].checked){
							//有一个条目选中了
							flag = true;
							break;
						}
					}
					if(flag){//有条目被选中
						//表单提交
						function del(birdId){

							var url="delete";

							var data={
								birdId:birdId
							};

							ajax(url,data,function(result){
								if(result == 1){
									window.location.href="main.jsp";
								}
							});
						}
					}
				}
			}
			//1.获取第一个cb
			document.getElementById("firstCb").onclick = function(){
				//2.获取下边列表中所有的cb
				var cbs = document.getElementsByName("bid");
				//3.遍历
				for (var i = 0; i < cbs.length; i++) {
					//4.设置这些cbs[i]的checked状态 = firstCb.checked
					cbs[i].checked = this.checked;
				}
			}
		}
		function del(birdId){

			var url="delete";

			var data={
				birdId:birdId
			};

			ajax(url,data,function(result){
				if(result == 1){
					window.location.href="main.jsp";
				}
			});
		}
		
		function pre(i){
			//alert(i);
			init(i);
		}
		
		function nxt(i){
				init(i);
		}
		function cpg(i){
			init(i);
	}
	</script>
</body>
</html>


