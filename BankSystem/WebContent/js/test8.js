$(document).ready(function(){
	$("#bt1").click(function(){
		$("p").hide(1000,function(){
			alert("已经隐藏p!!!")
		});
	});
	
	$("#bt2").click(function(){
		$("p").show(1000,function(){
			alert("已经显示p!!!")
		});
	});
	
})
