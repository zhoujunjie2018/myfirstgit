$(document).ready(function(){
	

	$("#search_btn").click(function(){
		$.post(
		"selectId",
		{id:$("#id").val()},
		function(data,status){
			$("#eid").val(data.id);
		}
		
		
		)
		
	})
	
	
	
	
	
});



