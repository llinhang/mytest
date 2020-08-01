
//ͨ封装ajax后台提交操作，url是路径，data，数据参数，successfun回调函数
function  ajax(url, data,successfn) {
		//alert(url);
		//alert(data);
		data = (data == null || data == "" || typeof (data) == "undefined") ? {
			"date" : new Date().getTime()
		} : data;
		var result="" ;
		$.ajax({
			type : "post",
			data : data,
			//async:false,
			dataType : "json",
			url : url,
			success : function(d) {
				successfn(d);
			}
		});

	};

