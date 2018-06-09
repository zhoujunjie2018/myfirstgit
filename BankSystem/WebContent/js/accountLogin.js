var loginAndRegDialog;
var loginInputForm;
var regDialog;
var regInputForm;
$(function(){
	//登陆对话框
	loginAndRegDialog=$('#loginAndRegDialog').dialog({
		closable:false,
		modal:true,
		buttons:[
		        {text:'注册',
		        	handler:function(){
		        		
		        		regDialog.dialog('open');
		        		 
		        	 }},
		        {text:'登陆',
			        handler:function(){
			        	loginInputForm.submit();
			        	/*$.ajax({
			        		url:'accountLogin',
//data:{id:$('#id').val(),
//password:$('#password').val()},
			        		data:$('#loginInputForm').serialize(),
			        		cache:false,
			        		dataType:'json',
			        		success:function(r){  
			        			//console.info(r.msg);
			        			if(r && r.success){
			        				loginAndRegDialog.dialog('close');
			        				$.messager.show({
			        					title:'提示',
			        					msg:r.msg
			        				});
			        			}else{
			        				$.messager.alert('提示',r.msg);
			        			}
			        			
			        		}
			        		
			        	}) */
			        	
			        	
			        	
			        	
			        	
			        	 }}
		         ]
		
	});
	//注册对话框
	regDialog = $('#regDialog').dialog({
		closable:false,
		modal:true,
		closed:true,
		buttons:[
		        {text:'注册',
		        	handler:function(){
		        		regInputForm.submit();
		        		
		        		 
		        	 }},
		        {text:'重置',
			        handler:function(){
			        	
			        	 }}
		         ]
		
	});
	
	//注册表单
	regInputForm=$('#regInputForm').form({
		
		url:'addAccount',
		success:function(r){
			r=$.parseJSON(r);
			if(r && r.success){
				regDialog.dialog('close');
				
				$.messager.show({
					title:'提示',
					msg:r.msg
				});
				
				
				
			}else{
				$.messager.alert('提示',r.msg);
			}
		},
		
	});
	
	
	

	//登陆表单
	loginInputForm=$('#loginInputForm').form({
		url:'accountLogin',
		success:function(r){
			r=$.parseJSON(r);
			if(r && r.success){
				
				$.messager.show({
					title:'提示',
					msg:r.msg
				});
				window.location.href='accountIndex';
			}else{
				$.messager.alert('提示',r.msg);
			}
		},
	});
	
	//回车键提交功能
	loginInputForm.find('input').on('keyup',function(event){
		if(event.keyCode=='13'){
			loginInputForm.submit();
		}
	});
	
	$.extend($.fn.validatebox.defaults.rules,{
		eqPassword:{
			validator:function(value,param){
			return value==$(param[0]).val();},
			message:'密码不一致！'
		
		}
	
	});
	
	
	
	/*重复密码验证一致性
	 * <td><input id="repassword" name="repassword" type="password" class="easyui-validatebox" required="true"  validType="eqPassword['#password']" /></td>
		$.extend($.fn.validatebox.defaults.rules,{
			eqPassword:{
				validator:function(value,param){
				return value==$(param[0]).val();},
				message:'密码不一致！'
			
			}
		
		})
	 *    
	 *    
	 *    */
	
	
});
