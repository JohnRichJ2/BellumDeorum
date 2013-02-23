$(function() {
	$(".ajax").each(function () {
		$(this).load($(this).attr("ajaxUrl"));
	});
});