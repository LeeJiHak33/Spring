<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<div>
			<h1>항목 목록</h1>
		</div>
		<form>
		<div class="row mb-2">
			<div class="col">
			</div>
			<div class="col-1">
				<select name="search" class="form-control form-control-sm">
					<option value="0">선택</option>
					<option value="1" ${pager.search == 1 ? 'selected' : ''}>항목번호</option>
					<option value="2" ${pager.search == 2 ? 'selected' : ''}>항목명</option>
					<option value="2" ${pager.search == 2 ? 'selected' : ''}>설명</option>
					
				</select>
			</div>
			<div class="col-5">
				<input type="text" name="keyword" class="form-control form-control-sm" value="${pager.search == 0 ? '' : pager.keyword}">
			</div>
			<div class="col-1 d-grid">
				<button class="btn btn-primary btn-sm">검색</button>
			</div>
		</div>
		</form>
		<form>
		<input type="hidden" name="search" value="4">
		<div class="row mb-2">
			<div class="col">
			</div>
			<div class="col-3">
				<div class="input-group input-group-sm">
					<label class="input-group-text ">가격 하한</label>
					<input type="text" name="lowPrice" class="form-control form-control-sm" value="${pager.lowPrice}">
				</div>
			</div>
			<div class="col-3">
				<div class="input-group input-group-sm">
					<label class="input-group-text">가격 상한</label>
					<input type="text" name="highPrice" class="form-control form-control-sm" value="${pager.highPrice}">
				</div>
			</div>
			<div class="col-1 d-grid">
				<button class="btn btn-primary btn-sm">검색</button>
			</div>
		</div>
		</form>
		<div>
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th>항목번호</th>
						<th>항목명</th>
						<th>설명</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="5">검색 된 데이터가 없습니다</td>
						</tr>
					</c:if>					
					<c:forEach var="item" items="${list}">						
						<tr>
							<td>${item.id}</td>
							<td>${item.name}</td>
							<td>${item.caption}</td>
							<td><a href="/keywords/${item.id }/list">용어관리</a><a href="update/${item.id}" class="btn btn-sm btn-warning">변경</a> <a href="delete/${item.id}" class="btn btn-sm btn-danger">삭제</a></td>
						</tr>
					</c:forEach>
				</tbody>
				
				<tfoot>
					<tr>
						<td colspan="5">
							<ul class="pagination">
								<li class="page-item"><a href="?page=1${pager.query}" class="page-link">처음</a></li>
								<li class="page-item"><a href="?page=${pager.prev}${pager.query}" class="page-link">이전</a></li>
								
								<c:forEach var="page" items="${pager.list}">
									<li class="page-item ${pager.page == page ? 'active' : ''}"><a href="?page=${page}${pager.query}" class="page-link">${page}</a></li>
								</c:forEach>
								
								<li class="page-item"><a href="?page=${pager.next}${pager.query}" class="page-link">다음</a></li>
								<li class="page-item"><a href="?page=${pager.last}${pager.query}" class="page-link">마지막</a></li>
							</ul>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div>
			<a href="add" class="btn btn-sm btn-primary mt-2">추가</a>
		</div>
		<div>
			<a href=".." class="btn btn-sm btn-info mt-2">처음으로</a>
		</div>
	</div>
</body>
</html>