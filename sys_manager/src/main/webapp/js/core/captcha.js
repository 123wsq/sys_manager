

function login(form){
	var $form = $(form);
	var url = $form.attr('action');
	url += "";
	var data = $form.serializeArray();
	for(var i= 0; i< data.length; i++){
		console.log(data[i])
		if(data[i].name=='password'){
			data[i].value = hex_md5(data[i].value).toUpperCase();
		}
	}
	data.push({name:"reqType",value:"ajax"});
	$.ajax({
		url: url,
		type:"POST",
		dataType:"json",
		data:data,
		success: function(result){	
			if(result.rspcod == 200){
				window.location=server_base_url + result.redirect;//跳到主页
			}else{
				$(".captcha").setGaptcha();
				$(".login_msg").html(result.rspmsg);
			}
		},
		error:function(XMLHttpRequest, textStatus){
			alert("网络异常代码："+XMLHttpRequest.status+",异常描述："+textStatus);
		}
	});
	
	return false;
}

$(document).ready(function() {
	$(".captcha").on("click",function(){
		$(this).setGaptcha();
	}).setGaptcha();

});