$(function() {
	$(".ajax").each(function () {
		$(this).load($(this).attr("ajaxUrl"));
	});
	
	$(".defaultableTextInput").ready(function () {
		defaultTextInput($(this));
	});

	$(".defaultableTextInput").blur(function () {
		defaultTextInput($(this));
	});
});

function defaultTextInput(context) {
	this.value("dasd");
}