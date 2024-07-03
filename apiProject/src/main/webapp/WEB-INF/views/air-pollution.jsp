<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
지역 <br>
<select id="stationName" name="stationName">
	<option value="종로구">종로구</option>
	<option value="구로구">구로구</option>
	<option value="용산구">용산구</option>
</select>

<button id="btn">클릭</button> | <button id="btn-xml">버튼2</button>
<br><br>
<table class="table table-hover">
	<thead class="thead-dark">
		<tr>
			<th>1</th>
			<th>2</th>
			<th>3</th>
			<th>4</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
</body>

<script>
	$(() => {
		$('#btn').on('click', () => {
			//selectValue = $('#stationName').val();
			$.ajax({
				url : 'pollution',
				data : {
					stationName : $('#stationName').val()
				},
				type : 'get',
				success : result => {
					console.log(result);
					const items = result.response.body.items;
					let strEl = '';
					for (let i in items) {
						const item = items[i];
						
						strEl += '<tr>'
							  + '<td>'+ item.stationName +'</td>'
							  + '<td>'+ item.so2Value +'</td>'
							  + '<td>'+ item.coValue +'</td>'
							  + '<td>'+ item.so2Grade +'</td>'
							  + '</tr>'
					};
					$('tbody').html(strEl);
				}
				
			});
			
		});
		
		$('#btn-xml').on('click', () => {
			//selectValue = $('#stationName').val();
			$.ajax({
				url : 'pollution/xml',
				data :  {
					stationName : $('#stationName').val()
				},
				type : 'get',
				success : result => {
					console.log(result);
					//1. 응답 데이터에서 실제 화면에 출력해야하는 데이터가 담겨있는 요소를 선택
					
					const items=$(result).find('item');
					
					//2. 반복문을 통해 실제 데이터가 담긴 요소들에 접근해서 동적으로 요소를 만들어서 출력
					let value='';
					items.each((i,item) => {
						console.log(i+'번째 요소 : ');
						console.log(item);
						console.log($(item).find('stationName').text());
						
						value += '<tr>'
							  + '<td>'+ $(item).find('stationName').text() +'</td>'
							  + '<td>'+ $(item).find('so2Value').text() +'</td>'
							  + '<td>'+ $(item).find('coValue').text() +'</td>'
							  + '<td>'+ $(item).find('so2Grade').text() +'</td>'
					});
					$('tbody').html(value);
					
				}
			});
		});
		
	});
</script>

</html>