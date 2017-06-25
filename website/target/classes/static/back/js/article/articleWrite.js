$(function(){
	
	$(".save").click(function(){
		var title = $("#title").val();
		var keyword = $("#keyword").val();
		var isVisit = $("input[name=optionsRadios]:checked").val();
		var digest = $("#digest").val();
		var content = ue.getContent();
		var article = {
			title:title,
			keyword:keyword,
			visit:isVisit,
			digest:digest,
			content:content
		}
		var mes = postArticle(article);
		if(mes=="sucess"){
			window.location.href="/control/articleManager";
		}else{
			
		}
		
	})
    function postArticle(article) {
       /*$.ajax({
	        type: "POST",
	        url: "/control/uploadArticle",
	        contentType: "application/json",
	        dataType: "json",
	        data: JSON.stringify(article),
        });*/
		$.post('/control/uploadArticle', { article: article},
			function (data) {
				alert(data);
				},
		"text");
	}
	
})