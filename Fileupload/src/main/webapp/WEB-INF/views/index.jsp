<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.1.min.js" ></script>
<script type="text/javascript">
	$(function() {
		$("#upload").click(function () {
			const form=document.getElementById("form");
			const formData=new FormData(form);
			
			console.dir(formData);
			//const a=[] //배열
			//const b={}// 객체
			
			//세팅객체
			$.ajax({
				type:'POST',
				url:'upload_ajax',
				enctype:'multipart/form-data',
				data: formData,
				async:true,
				cache:false,
				contentType: false,
				processData:false,
				success:function(data){
					console.log(data);
					
					//const li=$("<li><div>"+form.title.value+"</div><img src='images/"+data+"'></li>")
					const li=$("<li>");
					
					const div=$("<div>");
					div.text(form.title.value);
					
					const img=$("<img>");
					img.attr("src","images/"+data);
					
					
					li.append(div);
					li.append(img);
					
					$("ul").append(li);
					
					$("#empty_list").addClass("hide");
				}
			});
		});
	});
</script>
<style type="text/css">
	.hide{
		display: none;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<h1>이미지 갤러리</h1>
		</div>
		<div>
			<form id="form" method="post" action="upload" enctype="multipart/form-data">
				<div>
					<label>제목:</label>
					<input name="title" type="text" />
				</div>
				<div>
					<input name="uploadFile" type="file" />
				</div>
				<div>
					<button>[FORM]등록</button>
					<button id="upload" type="button">[AJAX]등록</button>
				</div>
			</form>
		</div>
		<hr>
		<div>
			<ul>
				<c:if test="${list.size() < 1 }">
					<li id="empty_list">
						<div>등록된 이미지가 없습니다.</div>
					</li>
				</c:if>
				<c:forEach items="${list}" var="item">
					<li>
						<div>${item.title }</div>
						<div><img src="images/${item.filename}"></div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>