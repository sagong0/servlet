/* list.html script */
function go_write(){
	alert("asfsd");
}


/* write.html 작성  */
function b_write(){
	
	// 모든 에디터는 이렇게 선언 해줘야함
	var t = CKEDITOR.instances.mcontent.getData();
	console.log(t);
	
	if(f.mtitle.value==""){
		alert("제목을 입력해주세요.");
	}
	else if(f.mwriter.value==""){
		alert("작성자를 입력해주세요.");
	}
	else if(f.mpw.value==""){
		alert("비밀번호를 입력해주세요.");
	}
	else if(t==""){
		alert("게시판 내용을 입력해주세요.")
	}
	else{
		f.submit();
	}
}