$(function() {
	$(".ajax").each(function () {
		$(this).load($(this).attr("ajaxUrl"));
	});
	
	$(".defaultableTextInput").each(function() {
		defaultTextInput($(this));
	});

	$(".defaultableTextInput").blur(function () {
		defaultTextInput($(this));
	});
	
	$(".defaultableTextInput").focus(function() {
		defaultTextInputFocus($(this));
	});
});

function defaultTextInput(context) {
	if (!context.val()) {
		context.val(context.attr("default"));
		context.attr("type", "text");
		context.removeAttr("changed");
		context.css('color', 'grey');
	}
}

function defaultTextInputFocus(context) {
	if (!context.attr("changed")) {
		context.val("");
		
		if (context.attr("default") == "password") {
			context.attr("type", "password");
		}
		
		context.attr("changed", true);
		context.css('color', 'black');
	}
}