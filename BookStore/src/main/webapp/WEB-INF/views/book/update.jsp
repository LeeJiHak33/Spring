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
			<h1>도서 정보 변경</h1>
		</div>
		<div>
			<form method="post">
				<div>
					<label>도서번호:</label>
					<input name="bookid" type="text" value="${item.bookid}" readonly>
				</div>
				
				<div>
					<label>도서명:</label>
					<input name="bookname" type="text" value="${item.bookname}">
				</div>
				
				<div>
					<label>출판사:</label>
					<input name="publisher" type="text" value="${item.publisher}">
				</div>
				
				<div>
					<label>가격:</label>
					<input name="price" type="number" value="${item.price}">
				</div>
				
				<div>
					<button>변경</button>
				</div>
			</form>
		</div>
		<div>
			<a href="list">취소</a>
		</div>
	</div>
</body>
</html>