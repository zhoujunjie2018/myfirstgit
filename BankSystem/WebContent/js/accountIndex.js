
$(function(){
	accountIndex.init();
	
	//保存
	$('#btn1').click(function(){
		accountIndex.save();
		
	})
	//关闭
	$('#btn2').click(function(){
		$('#addDialog').dialog('close');
		
	})
	
	 
	
})



var accountIndex = function(){
	var datagrid ={};
	editRow=undefined;
	
	var flag;//判断新增还是修改
	
	

	return{
		//保存
		save : function(){
		
				$.ajax({
					type:'post',
					url:flag,
					data:$('#addForm').serialize(),
					
					success:function(r){
				
						if(r&&r.success){
							$('#addDialog').dialog('close');
							$('#datagrid').datagrid('reload');
							$.messager.show({
								title:'提示',
								msg:r.msg
							})
						}else{
							$.messager.show({
								title:'提示',
								msg:r.msg
							})
						}
						
					}
					
				})
			
			
		
			
		},
		//初始化表格
		init : function(){
			datagrid=$('#datagrid').datagrid({
				idField:'id',
				url:  "getAccounts",
				title:'用户列表',
				iconCls:'icon-save',
				pagination:true,
				pageSize:5,
				pageList:[5,10,15,20],
				fit:true,
				fitColumns:true,
				nowarp:false,
				border:false,
				remoteSort:true,  
				sortName:'balance',  
				sortOrder:'asc',
				
				frozenColumns:[[
				          {
				        	  field:'ck',
				        	  width:50,
				        	  checkbox:true
				          }      
				                
				                ]],
				columns:[[
				          {
				        	  title:'用户账号',
				        	  field:'id',
				        	  width:100
				          },
				          {
				        	  title:'姓名',
				        	  field:'ownerName',
				        	  width:100,
				        	  editor:{
				        		  type:'validatebox',
				        		  options:{
				        			  required:true
				        		  }
				        	  }
				          },
				          {
				        	  title:'密码',
				        	  field:'password',
				        	  width:100
				          },
				          {
				        	  title:'性别',
				        	  field:'sex',
				        	  width:100,
				        	  formatter:function(value,record,index){
				        		  if(value==1){
				        			  return '男';
				        		  }else{
				        			  return '女';
				        		  }
				        	  }
				          },
				          {
				        	  title:'余额',
				        	  field:'balance',
				        	  width:100,
				        	  sortable:true,
				        	  formatter: function (value, row, index) {//小数点后取两位
			                        if (row != null) {
			                            return parseFloat(value).toFixed(2);
			                        }
			                    }
				          },
				          {
				        	  title:'开始时间',
				        	  field:'startAccessTime',
				        	  width:100,
				        	  formatter : function(value){
				        		  return accountIndex.format(value);
			                    }
				  	  
				          } ,
				          {
				        	  title:'结束时间',
				        	  field:'endAccessTime',
				        	  width:100,
				        	  formatter : function(value){
				        		  return accountIndex.format(value);
			                    }
				  	  
				          }
				          ]],
				  
				toolbar:[
				         {
				        	 text:'增加',
				        	 iconCls:'icon-add',
				        	 handler:function(){
				        		 
				        		 flag='saveAccounta';
				        		 $('#addDialog').dialog({
			        				 title:'新增用户'
			        			 });
				        		 $('#addForm').get(0).reset();
				        		// $('#addForm').form('clear');
				        		 $('#addDialog').dialog('open');
				        		
				        		 $('#id').validatebox({editable:true});
				        		 
				        	 } 
				         },'-',
				         {
				        	 text:'删除',
				        	 iconCls:'icon-remove',
				        	 handler:function(){
				        		 var arr=$('#datagrid').datagrid('getSelections');
				        		 if(arr.length<=0){
				        			 $.messager.show({
				        				 title:'提示',
				        				 msg:'至少选中一行进行删除'
				        			 })
				        		 }else{
				        			 var ids="";
				        			 for(var i=0;i<arr.length;i++){
				        				 ids=ids + arr[i].id+",";
				        			 }
				        			 ids=ids.substring(0, ids.length-1);
//				        			 $.ajax({
//				        				 type:'post',
//				        				 url:'deleteAccounts',
//				        				 data:{ids:ids},
//				        				 
//				        				 success:function(result){
//				        					 if(result&&result.success){
//				        						 //刷新表格
//						        				 $('#datagrid').datagrid('reload');
//						        				 $.messager.show({
//						        					 title:'提示',
//						        					 msg:result.msg
//						        				 })
//				        					 }else{
//				        						 $.messager.show({
//						        					 title:'提示',
//						        					 msg:result.msg
//				        						 })
//				        					 }
//				        					
//				        				 }
//				        				 
//				        			 })
//				        			 
				        			 $.post('deleteAccounts',{ids:ids},function(result){
				        				 if(result&&result.success){
			        						 //刷新表格
					        				 $('#datagrid').datagrid('reload');
					        				 //清空idfield
					        				 $('#datagrid').datagrid('unselectAll');
					        				 $.messager.show({
					        					 title:'提示',
					        					 msg:result.msg
					        				 })
			        					 }else{
			        						 $.messager.show({
					        					 title:'提示',
					        					 msg:result.msg
			        						 })
			        					 }
				        			 })
				        		 }
				        		 
				        	 } 
				         },'-',
				         {
				        	 text:'修改',
				        	 iconCls:'icon-edit',
				        	 handler:function(){
				        		 a=2;
				        		 flag='updateAccount';
				        		 var arr=$('#datagrid').datagrid('getSelections');
				        		 if(arr.length!=1){
				        			 $.messager.show({
				        				 title:'提示',
				        				 msg:'只能选择一行进行修改'
				        			 })
				        		 }else{
				        			 $('#addDialog').dialog({
				        				 title:'修改用户'
				        			 });
				        			 $('#addDialog').dialog('open');
				        			 $('#id').validatebox({editable:false});
				        			 
					        		 $('#addForm').get(0).reset();
					        		 $('#addForm').form('load',{
					        			 id:arr[0].id,
					        			 ownerName:arr[0].ownerName,
					        			 password:arr[0].password,
					        			 sex:arr[0].sex,
					        			 balance:arr[0].balance,
					        			 startAccessTime:accountIndex.format(arr[0].startAccessTime),
					        			 endAccessTime:accountIndex.format(arr[0].endAccessTime)
					        			 
					        		 });
					        		 
				        		 }
				        
				        	 } ,
				        	
				        	 
				         },'-',
				         {
				        	 text:'查询',
				        	 iconCls:'icon-search',
				        	 handler:function(){
				        		 $('#searchid').layout('expand','north');
				        	 } 
				         },'-'
				         ]
				
				
			});
			//accountIndex.search();
		},
		

		
		
//		search : function(){
//			var grid = $('#datagrid');  
//			var options = grid.datagrid('getPager').data("pagination").options;  
//			var curr = options.pageNumber; 
//			
//			var account = {};
//			account.ownerName = $('#ownerName_search').val();
//			account.accessTime = $('#accessTime_search').val();
//			account.rows = rows;
//			account.pager = curr;
//			
//			$.ajax({
//				url:  "getAccounts",
//				type : "POST",
//				dataType: 'json',
//				contentType: "application/json",
//				async : false,
//				data: JSON.stringify(account),
//				success: function(result){
//					datagrid.datagrid('loadData',result);
//				}
//			});
//			
//		
//			
//		},
		
		
		
		search: function(){
		
			datagrid.datagrid('load' ,{
				ownerName:$('#ownerName_search').val(),
				startAccessTime:$('#startAccessTime').val(),
				endAccessTime:$('#endAccessTime').val()
			} );
		},
		
		cleanSearch : function(){
			datagrid.datagrid('load',{});
			$('#searchForm').form('clear');
		},
		
		format : function(value){
			var date = new Date(value);
            var y = date.getFullYear();
            var m = date.getMonth() + 1;
            var d = date.getDate();
            return y + '-' +m + '-' + d;
		}
		
	
	}
	
}();

















