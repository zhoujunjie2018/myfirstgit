$(document).ready(function(){
	$("button").click(function(){
		$.post("../hello",
		{
			name:"zhangsan",
			city:"shanghai"
		},	function(data,status){
			$("#callback").text("数据："+data+"状态："+status)
		})
	})
})