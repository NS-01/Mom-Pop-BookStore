/*
 * A function that sets the mutable frame height appropriately
 */
function resizeIframe(obj) {
	obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
}

/*
 * A function that determines the mutable frame content appropriately
 */
var frameName;
function setFrame(name) {
	var address = name + ".jspx";
	document.getElementById(contentFrame).src = address;
}

/*
 * A function that keeps active links highlighted
 */
function highlight(item) {
	$(item).addClass('highlight');
}