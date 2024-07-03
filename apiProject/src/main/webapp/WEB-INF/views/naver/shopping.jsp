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
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a {
		text-decoration : none;
		color:white;
	}
	#kh-bg {
		width:800px;
		height : 450px;
		background-image: url('https://image.dongascience.com/Photo/2023/04/2ac455dfb54d3b597b921fac2a1c4c78.jpg');
		margin-top : 30px;
		background-repeat : no-repeat;
		background-size : contain;
	}
	.items {
		width : 1000px;
		margin : auto;
		display : flex;
		flex-wrap : wrap;
		gap : 20px;
	}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
      <form class="d-flex">
        <input class="form-control me-2" type="search" id="keyword" placeholder="Search" aria-label="Search">
        <button id="search-btn" class="btn btn-outline-success" type="button">Search</button>
      </form>
    </div>
  </div>
</nav>
<div id="kh-bg">

</div>
<hr/>
<div id="total-count">

</div>
<div class="items">

</div>
<button class="button btn-lg" style="background:lightgreen; color:white; font-weight:bold;" onclick="nextPage();">다음상품</button>


<script>
	$('#search-btn').click(() => {
		searchItem();
	});
	
	var startNo=1;

	function nextPage() {
		startNo += 9;
		searchItem();
	};
	
	function searchItem() {

		const $keyword = $('#keyword').val();
		console.log($keyword);
		$.ajax({
			url : 'product/',
			type : 'get',
			data : {
				keyword : $keyword,
				start : startNo
			},
			success : product => {
				$('#total-count').fadeOut
				console.log(product);
				$('#total-count').html('총 <b>' + product.total + '</b> 건의 '+ $keyword + '이(가) 검색되었습니다.');
				const items = product.items;
				let item = '';
				for(let i in items) {
					item += 
							'<div class="card" style="width: 18rem;">'
					  	+	'<img src="'+ items[i].image +'" class="card-img-top" alt="...">'
					  	+	'<div class="card-body">'
					    +	'<h5 class="card-title">'+ items[i].brand +'</h5>'
					    +	'<p class="card-text">'+ items[i].title +'</p>'
					  	+	'</div>'
					  	+	'<ul class="list-group list-group-flush">'
					    +	'<li class="list-group-item">가격</li>'
					    +	'<li class="list-group-item">'+items[i].lprice+'</li>'
					  	+	'</ul>'
					  	+	'<div class="card-body">'
					    +	'<a href="'+items[i].link+'" class="card-link">구매하러가기</a>'
					  	+	'</div>'
						+	'</div>'
				}
				$('.items').html(item);
				
			}
		});
	};
</script>

</body>
</html>