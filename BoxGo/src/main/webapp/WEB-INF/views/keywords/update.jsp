<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>
			<h1>용어 정보 변경</h1>
		</div>
		<div>
			<form method="post">
				<div>
					<label>용어번호:</label>
					<input name="id" type="text" value="${item.id}" readonly>
				</div>
				
				<div>
					<label>용어명:</label>
					<input name="name" type="text" value="${item.name}">
				</div>
				
				
				
				
				<div>
					<button>변경</button>
				</div>
			</form>
		</div>
		<div>
			<a href="../list">취소</a>
		</div>
	</div>
</body>
</html>