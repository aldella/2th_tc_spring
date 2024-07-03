<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=62930a8405c6bffe99ab8c11e470ff2f"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<input type="number" id="pageNo" value="1" placeholder="페이지 번호를 입력해주세요"> | <button id="btn">맛집찾기</button>
	
	<script>
		$('#btn').on('click', () => {
			const pageNo = $('#pageNo').val();
			$.ajax({
				url : 'foods/' + pageNo,
				type : 'get',
				success : result => {
					console.log(result);
					const items = result.getFoodKr.item; //result로 받아온 JSON에는 getFoodKr객체가 있으며, 그 안에는 또item객체가 있다.
					let text='';
					for(let i in items) {
						const item = items[i];
						const itemImg = item.MAIN_IMG_THUMB;
						text += '<tr>'
							 +	'<td>'+item.MAIN_TITLE+'</td>'
							 +	'<td>'+item.RPRSNTV_MENU+'</td>'
							 +	'<td>'+item.ADDR1+'</td>'
							 +	'<td>'+item.CNTCT_TEL+'</td>'
							 +	'<td>'+item.USAGE_DAY_WEEK_AND_TIME+'</td>'
							 +	'<td><img src="'+itemImg+'"/></td>'
							 +	'<td>'
							 +	'<form method="post" action="foods/detail">'
							 +	'<input type="hidden" name="title" value="'+item.MAIN_TITLE+'"/>'
							 +	'<input type="hidden" name="lat" value="'+item.LAT+'"/>'
							 +	'<input type="hidden" name="lng" value="'+item.LNG+'"/>'
							 +	'<input type="hidden" name="description" value="'+item.ITEMCNTNTS+'"/>'
							 +	'<button class="btn btn-sm btn-success">지도보기</button>'
							 +	'</form>'
							 +	'</td>'
							 +	'</tr>'
					};
					$('tbody').html(text);
				}
			});
		});
	</script>
	
	<table class="table">
		<thead>
			<tr>
				<th>가게명</th>
				<th>대표메뉴</th>
				<th>주소</th>
				<th>전화번호</th>
				<th>영업시간</th>
				<th>메뉴</th>
				<th>지도보기</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td></td>
			</tr>
		</tbody>
	</table>
</body>
</html>