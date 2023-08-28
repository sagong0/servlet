/* 로그인 */
function login(){
	if(f.uid.value == ""){
		alert("아이디를 입력해주세요.");
		f.uid.focus();
		return false;
	}
	else if(f.upw.value == ""){
		alert("비밀번호를 입력해주세요.");
		f.upw.focus();
		return false;
	}
	else{				
		return;
	}
}


/* 회원가입 */
function join(){
	if(f.uid.value==""){
		alert("아이디를 입력해주세요.");
	}
	else if(f.uname.value==""){
		alert("이름을 입력해주세요.");
	}
	else if(f.upw.value==""){
		alert("패스워드를 입력해주세요.");
	}
	else if(f.upw2.value==""){
		alert("패스워드확인을 입력해주세요.");
	}
	else if(f.tellcorp.value ==""){
		alert("통신사를 선택해주세요.");
	}
	else if(f.uno.value == ""){
		alert("연락처를 입력해주세요.")
	}
	else if(f.uemail.value==""){
		alert("이메일을 입력해주세요.");
	}
	else if(f.upw.value != f.upw2.value){
		alert("비밀번호가 일치하지 않습니다.");
	}
	else{
		if(f.uno.value.length < 10){
			alert("올바른 휴대폰 번호를 입력하세요.");
		}
		else if(isNaN(f.uno.value)==true){	// is Not a Number(숫자아니면 트루값나옴.)
			alert("정상적인 휴대폰 번호를 입력해주세요.");
		}
		else if(f.uemail.value.indexOf("@") == -1){	//indexOf : 문자열중에서 @ 단어 포함되어있는지 없는지 검토.
			// @ 포함되면 -1 이 안나옴.
			alert("올바른 이메일 주소를 입력하세요.");
		}
		else{
			f.submit();		
		}
	}
}
