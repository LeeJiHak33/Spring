<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	let isCheck;
	
	function checkId(mode){
		
		if(document.signup_form.id.value==""){
			alert("아이디를 입력해주세요");
			document.signup_form.id.focus();
			return;
		}
		
		if(mode){
			checkId_Async();	
		}
		else{
			checkId_Sync();
		}
	}
	
	//동기
	function checkId_Sync() {
		const form= document.signup_form;
		
		
		
		const xhr=new XMLHttpRequest();//서버랑 통신할 수 있게 하는거
		
		xhr.open("GET","checkId/"+form.id.value,false);//설정하기 method ,주소+입력한 값,동기적:false true:비동기
		
		xhr.send(); //동작시킴 / 실행하고 종료될때까지 머물러있음
		
		const result=xhr.responseText;
		console.log("[동기]응답"+result);
		if(result=="OK"){
			isCheck=form.id.value;
			alert("[동기]사용가능한 아이디 입니다.");
		}
		else{
			alert("[동기]이미 사용중인 아이디 입니다.")
		}
		
		
	}

	//비동기
	function checkId_Async(){
		const form=document.signup_form;
		
		const xhr=new XMLHttpRequest();
		
		//미리할일 지정
		xhr.onreadystatechange = function(){
			console.log(xhr.readyState);
			
			//request를 보내고 갔다가 오고난 후
			if(xhr.readyState == XMLHttpRequest.DONE){
				if(xhr.status == 200){
					const result=xhr.responseText;
					
					console.log("[비동기]응답"+result);
					
					if(result=="OK"){
						isCheck=true;
						alert("[비동기]사용가능한 아이디 입니다.");
					}
					else{
						alert("[비동기]이미 사용중인 아이디 입니다.")
					}
				}
			}
		}; 
		
		
		xhr.open("GET","checkId/"+form.id.value,true);
		xhr.send();//여기서 멈춰있지 않음
		
		
	}
	function signup(){
		//const val ->변경불가 ->immutable
		//let var ->변경 가능 ->mutable
		const form= document.signup_form;
		
		if(isCheck != form.id.value){
			alert("아이디 중복검사를 하셔야 합니다.");
			return;
		}
		
		if(form.id.value==""){
			alert("아이디를 입력해주세요");
			form.id.focus();
			return;
		}
		if(form.passwd.value==""){
			alert("비밀번호를 입력해주세요");
			form.passwd.focus();
			return;
		}
		if(form.passwd_valid.value==""){
			alert("비밀번호 확인를 입력해주세요");
			form.passwd_valid.focus();
			return;
		}
		if(form.name.value==""){
			alert("이름을 입력해주세요");
			form.name.focus();
			return;
		}
		if(form.passwd.value != form.passwd_valid.value){
			alert("비밀번호가 일치하지 않습니다.");
			form.passwd.focus();
			return;
		}
		
		form.submit();
		
	}
</script>
</head>
<body>
	<div>
		<div>
			<h3>회원가입</h3>
		</div>
		<div>
			<form name="signup_form" method="post">
				<!--  <input type="hidden" name="checkId"> -->
				<div>
					<label>아이디: </label>
					<input type="text" name="id" placeholder="아이디를 입력해주세요">
					<button type="button" onclick="checkId(false)">[동기]중복확인</button>
					<button type="button" onclick="checkId(true)">[비동기]중복확인</button>
				</div>
				<div>
					<label>비밀번호: </label>
					<input type="password" name="passwd" >
				</div>
				<div>
					<label>비밀번호확인: </label>
					<input type="password" name="passwd_valid" >
				</div>
				<div>
					<label>이름: </label>
					<input type="text" name="name" placeholder="이름을 입력하세요">
					
				</div>
				<div>
					<button type="button" onclick="signup()">회원가입</button>
					<a href="/"><button type="button">취소</button></a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>