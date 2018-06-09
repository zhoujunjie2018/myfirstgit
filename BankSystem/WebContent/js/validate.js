$.extend($.fn.validatebox.defaults.rules, {    
	midLength: {    
        validator: function(value, param){    
            return value.length >= param[0] && value.length<=param[1];    
        },    
        message: '请输入{0}到{1}个字符。。。'   
    }    
}); 


////转换日期格式  
//function changeDateFormat(cellval) {
//    if (cellval != null) {
//        var date = new Date(parseInt(cellval.replace("/Date(", "").replace(")/", ""), 10));
//        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
//        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
//        return date.getFullYear() + "-" + month + "-" + currentDate;
//    }
//}