function anichange (objName) {
		if ( $(objName).css('display') == 'none' ) {
			$(objName).animate({height: 'show'}, 400);
 	} else {
 		$(objName).animate({height: 'hide'}, 200);
 	}
}

function addMessage() {
	if (textbox.value == "") return false;
	var list = document.getElementById('list')
	var firstLi = list.getElementsByTagName('LI')[0]
	var newListElem = document.createElement('LI')
	newListElem.innerHTML = textbox.value
	newListElem.className = "message"
	list.insertBefore(newListElem, firstLi)
}

		function anichanged (objName) {
		if ( $(objName).css('display') == 'none' ) {
			$(objName).animate({height: 'show'}, 400);
 		} 
}

		function unanichanged (objName) {
		if ( $(objName).css('display') != 'none' ) {
			$(objName).animate({height: 'hide'}, 200);
 	} 
}