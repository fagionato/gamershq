function logoutThenRedirect(){
	//$.cookie("urlToRedirect", window.location.pathname.replaceAll("/","-"), { expires: 1, path: '/' });
	
	location.href='/sair?redir=' + window.location.pathname.replaceAll("/","-");
} 