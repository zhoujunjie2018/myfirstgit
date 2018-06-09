$(document).ready(function(){
	$("button").click(function(){
		$.get("helloworld.txt",function(data,status){
			$("#callback").text("数据是："+data+"\n状态是："+status);
		})
	})
})