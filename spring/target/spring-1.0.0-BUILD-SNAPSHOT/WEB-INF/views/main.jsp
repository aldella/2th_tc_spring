<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B강의장 프로젝트 입니다</title>
<style>
	#content { height:500px; }
</style>
</head>
<body>
	<jsp:include page="common/menubar.jsp"></jsp:include>
	<div id="content">
	<a href="ajax2"> test </a>
	<div class="innerOuter">
		<h3>게시글 조회수 TOP5</h3>
		<br>
		<a href="boardlist" style="float:right; color:lightgray; font-weight:800; font-size:14px;">더보기</a>
		
		<table class="table table-hover" align="center" id="boardList">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
					<th>첨부파일</th>
				</tr>
			</thead>
			<tbody>
				<!-- BOARD테이블에서 count컬럼값이 제일 높은 상위 5개의 게시글을 조회해서 뿌려줄 것 -->
			</tbody>
		</table>
		<table id="board-detail" class="table">
			<thead>
				<tr>
					<th></th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<script>
	$(() => {
		findTopFiveBoard();
		
	})
	
	$(document).on('click','#boardList > tbody > tr', (e) => {
		const boardNo = $(e.currentTarget).children().eq(0).text();
		$.ajax({
			url : 'boards/'+boardNo,
			type : 'get',
			success : result => {
				console.log(result);
				let value = '';
				value += '<tr>'
					   + '<td width="300">' +result.boardTitle+'</td>'
					   + '<td width="600">' +result.boardContent+'</td>'
					   + '<td width="200">' +result.Writer+'</td>'
					   + '</tr>';
				document.getElementById('board-detail').innerHTML=value;
			}
		});
	});
	
	
	function findTopFiveBoard() {
		
		$.ajax({
			url : 'boards',
			type : 'get',
			// data : 보낼 거 있을때만 적는건데 보낼 게 없으니까 적지말기
			success : boards => {
				let value="";
				for(let i in boards) {
					value += "<tr>"
							+"<td>"+boards[i].boardNo+"</td>"
							+"<td>"+boards[i].boardTitle+"</td>"
							+"<td>"+boards[i].boardWriter+"</td>"
							+"<td>"+boards[i].count+"</td>"
							+"<td>"+boards[i].createDate+"</td>"
							+"<td>";
							if(boards[i].originName != null) {
								value+="有";
							}
							value+="</td></tr>";
				}
				$('#boardList tbody').html(value);
			},
			error : e => { console.log(e) }
		});
		
	}
	</script>
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>