<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<script type="text/javascript">
	$(function() {
		$("select.detail").change(function() {
			const target=$(this).data("target");
			const option=$(this).find("option:selected");
			
			if(option.index()==0){
				$("#"+target).val("");
			}
			else{
				$("#"+target).val(option.text());	
			}
			
			
		});
	});
</script>
</head>
<body>
	<div>
		<div>
			<h1>제품 등록</h1>
		</div>
		<div>
			<form method="post">
			
				<div>
					<label>제품명:</label>
					<input name="name" type="text">
				</div>
				<div>
					<label>바코드:</label>
					<input name="barcode" type="text"><button type="button"> 자동생성</button>
				</div>
				<hr>
				<c:set var="domainId" value="0"></c:set>
				<c:forEach var="item" items="${list }">
					<c:if test="${item.domainId != domainId }">
						<c:if test="${domainId !=0 }">
								</select>
								</div>
						
						</c:if>
						<c:set var="domainId" value="${item.domainId }"></c:set>
						<div>
							<label>${item.caption}</label>
							<input name="${ item.domainName}" type="text" id="${item.domainName}">
							<select class="detail" data-target="${item.domainName }">
								<option >직접입력</option>
					</c:if>
			
					
							
								<option value="${item.id }">${item.name }</option>
							
						
						
				
				</c:forEach>
				<c:if test="${domainId !=0 }">
					</select>
					</div>
						
				</c:if>
				<div>
					<button>등록</button>
				</div>
			</form>
		</div>
		<div>
			<a href="list"><button type="button">취소</button> </a>
		</div>
	</div>
</body>
</html>