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
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>   
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>   
    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>   
    <div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>   
    <div data-options="region:'center',title:'center title'" style="overflow:hidden;">
    	<div id="searchid"  class="easyui-layout" fit="true" border="false">
    		<div  region="north" border="false" collapsed=true title="用户查询" style="height:110px;overflow:hidden;">
    			<form id="searchForm">
    				<table>
    					<tr>
    						<th>用户名</th>
    						<td><input id="ownerName_search" name="ownerName" /></td>
    					</tr>
    					
    					<tr>
    						<th>开始时间</th>
    						<td><input id="startAccessTime" name="startAccessTime"  class="easyui-datebox" editable="true" style="width:155px;"/>
    						</td>
    					</tr>
    					
    					<tr>
    						<th>结束时间</th>
    						<td><input id="endAccessTime" name="endAccessTime"  class="easyui-datebox" editable="true" style="width:155px;"/>
    						</td>
    						<td>
    							<a href="javascript:void(0)" class="easyui-linkbutton" onclick="accountIndex.search()">查询</a>
    							<a href="javascript:void(0)" class="easyui-linkbutton" onclick="accountIndex.cleanSearch()">清除条件</a>
    						</td>
    					</tr>
    					
    				
    				</table>
    			
    			
    			</form>
    		</div>
			<div region="center"  border="false">
				<table id="datagrid"></table>
			</div>
			
			<div id="addDialog" class="easyui-dialog" title="新增用户界面" model=true draggable=false closed=true style="width:300px;">
				<form id="addForm">
					<table>
						<tr>
							<td>用户账号：</td>
							<td><input id="id" name="id"  type="text" class="easyui-validatebox" required=true validType="midLength[2,10]"></td>
						</tr>
						
						<tr>
							<td>用户姓名：</td>
							<td><input id="ownerName" name="ownerName" type="text" class="easyui-validatebox" required=true validType="midLength[2,10]"></td>
						</tr>
						
						<tr>
							<td>用户密码：</td>
							<td><input id="password" name="password" type="password" class="easyui-validatebox" required=true validType="midLength[2,10]"></td>
						</tr>
						<tr>
							<td>性别：</td>
							<td><input id="sex" name="sex" type="text" class="easyui-validatebox" required=true "></td>
						</tr>
						<tr>
							<td>余额：</td>
							<td><input id="balance" name="balance" type="text" class="easyui-numberbox" precision="2" required=true "></td>
						</tr>
						<tr>
							<td>开始时间：</td>
							<td><input id="startAccessTime" name="startAccessTime" type="text" class="easyui-datebox" required=true"></td>
						</tr>
						
						<tr>
							<td>结束时间：</td>
							<td><input id="endAccessTime" name="endAccessTime" type="text" class="easyui-datebox" required=true "></td>
						</tr>
						<tr align="center">
							<td colspan="2">
								<a id="btn1" class="easyui-linkbutton">确定</a>
								<a id="btn2" class="easyui-linkbutton">关闭</a>
							</td>
						</tr>
						
					
					</table>
				
				</form>
			
			
			</div>
		</div>
		
    
    </div> 
    
    
    
</body> 
</html>




















