alter("start");

var result = '${msg}';																																																							

if(result == 'SUCCESS'){
	alter("처리가 완료 되었습니다.");
}

$(document).ready(function(){
	$('#searchBtn').on(
			"click",function(event){
				self.location = "board/listPage"
				+ '${pageMaker.makeQuery(1)}'
				+ "&searchType="
				+ $("select option:selected").val()
				+ "&keyword=" + $('#keywordInput').val();
			});
	$('#newBtn').on("click",function(evt){
		self.location = "register";
	});
});