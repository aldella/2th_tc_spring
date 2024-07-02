<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
조회할 음식 번호 : <input type="number" id="num">
<button id="select-btn">조회</button>
<div id="menudiv">

</div>
<script>
window.onload = () => {
	
	document.getElementById("select-btn").onclick = () => {
		$.ajax({
			url : 'ajax3.do',
			type : 'get',
			data : {
				menuNumber : document.getElementById('num').value
			},
			success : result => {
				console.log(result);
				const menu = "<p>"+result.menuName+"</p>";
				document.getElementById('menudiv').innerHTML = menu;
			},
			error : e => {
				console.log(e);
			}
		});
	}
	
}
</script>

<button onclick="findAll()">메뉴 전체조회</button>
<br>
<table>
	<thead>
		<tr>
			<th>메뉴명</th>
			<th>가격</th>
			<th>재료</th>
		</tr>
	</thead>
	
	<tbody>
	
	</tbody>
</table>
<script>
	function findAll() {
		$.ajax({
			url : 'find.do',
			type : 'get',
			success : result => {
				//console.log(result);
				
				const tbodyEl = document.getElementById('tbody');
				
				const trEl = document.createElement('tr');
				
				const tdFirst = document.createElement('td');
				const firstText = document.createTextNode(result[0].menuName);
				tdFirst.style.width = '200px';
				tdFirst.appendChild(firstText);
				
				trEl.appendChild(tdFirst);
				
				tbodyEl.appendChild(trEl);
				
			}
		});
	}
</script>


</body>
</html>