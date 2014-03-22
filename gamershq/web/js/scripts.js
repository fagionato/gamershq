String.prototype.replaceAll = function(search, replace) {
	// if replace is null, return original string otherwise it will
	// replace search string with 'undefined'.
	if (!replace)
		return this;

	return this.replace(new RegExp('[' + search + ']', 'g'), replace);
};

// usado para atualizar um input escondido de id 'password-md5' com o md5
// correspondente ao input que o usuario edita com id 'password'
// Anderson 07/2013
function generateMd5(obj) {
	// descobre o nome da form que contem os inputs
	var formId = obj.id.substring(0, obj.id.indexOf(':')) + ':';
	if (document.getElementById(formId + 'password').value != '') {
		document.getElementById(formId + 'password-md5').value = hex_md5(document
				.getElementById(formId + 'password').value);
	} else {
		document.getElementById(formId + 'password-md5').value = '';
	}
}

// sometimes Safari doesn't refresh a component after the primefaces update
// process. This forces safari to refresh.
// works just for container woth border
function forceRefreshForSafari(containerIdentifier) {
	// if($(containerIdentifier).hasClass('default-border-1')){
	// $(containerIdentifier).removeClass('default-border-1');
	// $(containerIdentifier).addClass('default-border');
	// }else{
	// $(containerIdentifier).addClass('default-border-1');
	// }

}

// usado pela grid editavel padrao
// retira /coloca um estilo de fundo vermelho no botao clicado
// chamar assim: onclick="markToDelete(this);"
function markToDelete(obj) {
	if ($(obj).hasClass('btn-mark-to-delete')) {
		$(obj).removeClass('btn-mark-to-delete');
	} else {
		$(obj).addClass('btn-mark-to-delete');
	}

	// procurar pelo primeiro pai td do obj passado e colocar classe
	// row-mark-to-delete
}

function toPanel() {
	location.href = '/painel';
}

// http://www.w3schools.com/js/js_cookies.asp
function getCookie(c_name) {
	var c_value = document.cookie;
	var c_start = c_value.indexOf(" " + c_name + "=");
	if (c_start == -1) {
		c_start = c_value.indexOf(c_name + "=");
	}
	if (c_start == -1) {
		c_value = null;
	} else {
		c_start = c_value.indexOf("=", c_start) + 1;
		var c_end = c_value.indexOf(";", c_start);
		if (c_end == -1) {
			c_end = c_value.length;
		}
		c_value = unescape(c_value.substring(c_start, c_end));
	}
	return c_value;
}

// http://stackoverflow.com/questions/9975810/make-iframe-automatically-adjust-height-according-to-the-contents-without-using
function resizeIframe(obj) {
	{
		obj.style.height = 0;
	}
	;
	{
		obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
	}
}