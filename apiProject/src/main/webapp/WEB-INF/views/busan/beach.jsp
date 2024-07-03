<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table table-success">
	<thead>
		<tr>
			<th>1</th>
			<th>2</th>
			<th>3</th>
			<th>4</th>
		</tr>
	</thead>
	<tbody id="tbody">
	</tbody>
</table>

<script>
	$(() => {
		$.ajax({
			url : 'beach',
			type : 'get',
			success : info => {
				console.log(info.getBeachInfo.body.items.item);
				const items = info.getBeachInfo.body.items.item;
				let strEl ='';
				for(let i in items) {
					strEl += '<tr>'
						  +  '<td>' + item.inspecArea+ '</td>'
						  +  '<td>' + item.water1+ '</td>'
						  +  '<td>' + item.water2+ '</td>'
						  +  '<td>' + item.inspecYm+ '</td>'
						  + '</tr>';
				};
				$('#tbody').html(strEl);
			}
		});
	});
</script>

</body>
</html>