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
			<h1>항목 등록</h1>
		</div>
		<div>
			<form method="post">
			
				<div>
					<label>항목명:</label>
					<input name="name" type="text">
				</div>
				<div>
					<label>설명:</label>
					<input name="caption" type="text">
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