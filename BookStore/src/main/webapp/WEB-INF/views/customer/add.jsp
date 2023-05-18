<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>
			<h1>고객 등록</h1>
		</div>
		<div>
			<form method="post">
				<div>
					<label>고객번호:</label>
					<input type="number" name="custid">
				</div>
				<div>
					<label>고객명:</label>
					<input type="text" name="name">
				</div>
				<div>
					<label>주소:</label>
					<input type="text" name="address">
				</div>
				<div>
					<label>전화번호:</label>
					<input type="text" name="phone">
				</div>
				<div>
					<button>등록</button>
					<a href="list"><button type="button">취소</button></a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>