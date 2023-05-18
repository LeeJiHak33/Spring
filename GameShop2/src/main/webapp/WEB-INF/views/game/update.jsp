<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" >

 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
 
 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/lang/summernote-ko-KR.js"></script>
<script type="text/javascript">
	$(function(){
		$("#summernote").summernote({
			lang: 'ko-KR'
		});
		$("#files .delete").click(function(){
			const id=$(this).data("id"); //데이타셋을 불러오는거
			const button=$(this);
			$.ajax({
				type:'GET',
				url:'../delete_attach/'+id,
				success: function(result){
					console.log(result);	
					
					button.closest("li").remove();//클로저 검색해보기
				}
			});
		});
		$("#attachs").on("click",".delete",function(){
			//alert("delete");
			const div=$(this).closest(".input-group");
			div.remove();
		});
		$("#add").click(function() {
			//<input type="file" name="attach" class="form-control form-control-sm">
			//<input type="file" class="form-control form-control-sm" name="attach">
			//<button class="btn btn-outline-secondary" type="button" id="add">삭제</button>
			const div= $("<div>");
			div.addClass("input-group")
			div.addClass("mb-3");
			
			const input = $("<input>");
			input.attr("type", "file");
			input.attr("name", "attach");
			input.addClass("form-control");
			input.addClass("form-control-sm");
			
			const button=$("<button>");
			button.attr("type", "button");
			button.addClass("btn");
			button.addClass("btn-outline-danger");
			button.addClass("delete");
			button.text("삭제")
			
			div.append(input);
			div.append(button);
			
			$("#attachs").append(div);
			
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div>
			<h3>게임 정보변경</h3>
			
		</div>
		<div>
			<form method="post" enctype="multipart/form-data">
				<div>
					<label class="form-label">게임코드: ${item.id}</label>
				</div>
				<div class="form-group">
					<label class="form-label">게임명:</label>
					<input type="text" name="title" value="${item.title}" class="form-control">
				</div>
				<div class="form-group">
					<label class="form-label">게임 회사:</label>
					<select name="publisherId" class="form-select ">
						<option value="0">알수없음</option>
						<c:forEach var="publisher" items="${list }">
							<option value="${publisher.id}" ${publisher.id==item.publisherId ? 'selected' : '' }>${publisher.name }</option >
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label class="form-label">가격:</label>
					<input type="number" name="price" value="${item.price}" class="form-control">
				</div >
				<div class="form-group">
					<label class="form-label">출시일:</label>
					<input type="date" name="pubDate" value="${item.pubDateFormat}" class="form-control" >
				</div>
				<div>
					<label class="form-label">등록일: <fmt:formatDate value="${item.regDate}" pattern="yyyy년 MM월 dd일"/> </label>
				</div>
				<textarea id="summernote" name="contents" class="form-control" >${item.contents} </textarea>
				<div >
					<ul id="files">
						<c:if test="${ item.attachs.size()<1}">
							<li>첨부파일이 없습니다.</li>
						</c:if>

						<c:forEach var="attach" items="${item.attachs }">
							<li><a href="/upload/${attach.filename }">${attach.filename }</a> <button type="button" class="btn btn-sm btn-danger delete" data-id="${attach.id}"> 삭제</button></li>
						</c:forEach>
					</ul>
					
				</div>
				<div id="form-group">
					<label>첨부파일:
						<button type="button" id="add" class="btn btn-sm btn-primary">추가</button>
					</label>
					<div id="attachs">
						<div class="input-group mb-3">
							<input type="file" class="form-control form-control-sm" name="attach">
							
						</div>

					</div>

				</div>
				
				<div class="form-group mt-3">
					<button class="btn btn-sm btn-primary">변경</button>
					<a href="../list" ><button type="button" class="btn btn-sm btn-secondary">취소</button> </a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>