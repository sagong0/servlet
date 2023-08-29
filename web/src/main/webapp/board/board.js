/* list.html script */
function go_write(){
	alert("asfsd");
}


/* write.html 작성  */
function b_write(){
	if(f.mtitle.value==""){
		alert("제목을 입력해주세요.");
	}
	else if(f.mwriter.value==""){
		alert("작성자를 입력해주세요.");
	}
	else if(f.mpw.value==""){
		alert("비밀번호를 입력해주세요.");
	}
	else if(f.mcontent.value==""){
		alert("내용을 입력해주세요.")
	}
	else{
		f.submit();
	}
}