<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<!-- 将通用的jsp的内容写在同一个jsp界面中然后引入 -->
<!-- 静态包含是将目标common.jsp界面的内容拿过里和当前界面的jsp代码一起编译后执行 -->
	<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="m_ajax.js"></script>

<!-- 动态包含是指目标界面会编译成字节码文件后执行的结果放在这个位置 -->
<%-- <jsp:include page=""></jsp:include> --%>
</head>
<body>
	<pre>
<form  method="post">
	username:<input type="text" name="birdName" id="birdName">
	account:<input type="text" name="birdAccount" id="birdAccount">
	password:<input type="password" name="birdPwd" id="birdPwd">
	<input type="button" value="save" onclick="save()">
</form>
</pre>
<script type="text/javascript">
	function save(){
		
		var birdName=$("#birdName").val();
		var birdAccount=$("#birdAccount").val();
		var birdPwd=$("#birdPwd").val();
		
		var url="save";
		var data={
			birdName:birdName,
			birdAccount:birdAccount ,
			birdPwd:birdPwd,
		};
		alert(birdName);
		alert(birdAccount);
		alert(birdPwd);
		ajax(url,data,function(result){
			alert(result);
			if(result!=0){
				window.location.href="index.jsp";
			}else{
				alert("注册失败！");
			}
		});
	}

</script>
</body>
</html>






