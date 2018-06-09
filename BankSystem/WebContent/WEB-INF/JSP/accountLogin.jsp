<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jeasyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jeasyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/accountLogin.js"></script>
<link rel="stylesheet" href="js/jeasyui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="js/jeasyui/themes/icon.css" type="text/css"></link>

</head>
<body>
	<div id="loginAndRegDialog" title="用户登录" style="width:250px;height:200px;">
		<form id="loginInputForm" method="post">
		<table>
			<tr>
				<th>用户账号</th>
				<td><input id="id" name="id" type="text"  class="easyui-validatebox" required="true"/></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input id="password" name="password" type="password" class="easyui-validatebox" required="true"/></td>
			</tr>
		</table>
		</form>
	
	</div>
	<div id="regDialog" title="注册" style="width:250px;height:200px;">
		<form id="regInputForm" method="post">
		<table>
			<tr>
				<th>用户账号</th>
				<td><input id="reg_id" name="id" type="text"  class="easyui-validatebox" required="true"/></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input id="reg_password" name="password" type="password" class="easyui-validatebox" required="true"/></td>
			</tr>
			<tr>
				<th>再次输入密码</th>
				<td><input id="reg_repassword" name="repassword" type="password" class="easyui-validatebox" required="true" validType="eqPassword['#reg_password']"/></td>
			</tr>
		</table>
		</form>
	
	</div>
	
</body>
</html>