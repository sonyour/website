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
		postArticle(article);
		console.log(JSON.stringify(article));
	})
    function postArticle(article) {
        $.ajax({
            type: "POST",
            url: "/control/uploadArticle",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(article),
        });
    }
})