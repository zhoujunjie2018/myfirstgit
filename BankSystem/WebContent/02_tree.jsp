<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="js/jeasyui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="js/jeasyui/themes/icon.css" type="text/css"></link>
<link rel="stylesheet" href="js/jeasyui/themes/baseCss.css" type="text/css"></link>
<link rel="stylesheet" href="js/jeasyui/demo/demo.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jeasyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jeasyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/accountIndex.js"></script>
<script type="text/javascript" src="js/zUtils.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<script type="text/javascript">

	$(function(){
	
		$("#tt2").tree({
			url:'tree_data.json',
			checkbox:true
			
			
			
		})
		
		
	})
	
	


</script>
</head>
<body>

	<ul id="tt2" ></ul>
	

</body>
</html>




















