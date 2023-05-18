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
			<h1>도서 등록</h1>
		</div>
		<div>
			<form method="post">
				<div>
					<label>도서번호:</label>
					<input name="bookid" type="text">
				</div>
				
				<div>
					<label>도서명:</label>
					<input name="bookname" type="text">
				</div>
				
				<div>
					<label>출판사:</label>
					<input name="publisher" type="text">
				</div>
				
				<div>
					<label>가격:</label>
					<input name="price" type="number">
				</div>
				
				<div>
					<button>등록</button>
				</div>
			</form>
		</div>
		<div>
			<a href="list">취소</a>
		</div>
	</div>
</body>
</html>