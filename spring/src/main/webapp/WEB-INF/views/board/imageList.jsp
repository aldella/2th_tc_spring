<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<style>
		.portfolio-item{
			text-align: center;
			margin-bottom: 20px;
		}

		.portfolio-caption{
			padding : 10px;
		}

		.img-thumbnail:hover{
			opacity: 0.8;
			transform: scale(1.1);
			transition: all 1s ease-in-out;
		}

		h1{
			text-align: center;
			padding: 50px;
		}
	
	</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	<script>
		function detail(e) {
	/*		console.log( $(e).find('.thumbnail-date').val() ) ;
			console.log( $(e).find('.thumbnail-content').val() );
			console.log( $(e).find('.thumbnail-img').attr('src') );
			console.log( $(e).find('.thumbnail-title').text() );
			console.log( $(e).find('.thumbnail-writer').text() ); */
			
			$('.modal-title').html($(e).find('.thumbnail-title').val());
			$('#img-modal').attr('src', $(e).find('.thumbnail-img').attr('src') );
			$('#modal-writer').html( $(e).find('.thumbnail-writer').text() );
			$('#modal-content').html( $(e).find('.thumbnail-content').val() );
			$('#modal-date').html($(e).find('.thumbnail-date').val());
		}
	</script>
	<div class="container">

		<h1>사진게시판이당</h1>

		<section class="bg-light" id="portfolio" style="padding-top: 90px; padding-bottom: 0;">
			<div class="container">
				<div class="row">
				
				<c:forEach items="${board }" var="img">
					<div class="col-md-4 col-sm-6 portfolio-item" onclick="detail(this)">
					<input type="hidden" class="thumbnail-date" value="${ img.createDate }"/>
					<input type="hidden" class="thumbnail-content" value="${ img.boardContent }"/>
						<a class="portfolio-link" data-toggle="modal" href="#MyModal">
							<div class="portfolio-hover">
								<div class="portfolio-hover-content">
								</div>
							</div>
							<img class="img-thumbnail img-fluid thumbnail-img" src="${img.changeName }" alt="">
						</a>
						<div class="portfolio-caption">
							<h4 class="thumbnail-title">${img.boardTitle }</h4>
							<p class="text-muted thumbnail-writer">${img.boardContent }</p>
						</div>
					</div>
					
				</c:forEach>
				</div>
			</div>
		</section>
	
	</div> 
	
    <jsp:include page="../common/footer.jsp" />


    <div class="modal fade" id="MyModal">
	    <div class="modal-dialog">
		    <div class="modal-content">
		
		        <!-- Modal Header -->
		        <div class="modal-header">
			        <h4 class="modal-title">게시글 제목</h4>
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        </div>
		
		        <!-- Modal body -->
		        <div class="modal-body">
			        <div class="table-center">
			            <table class="intro-table">
			                <tr class="intro-tr">
			                    <td colspan="2">
			                        <img id="img-modal" class="img-fluid" src="" alt="" width="100%">
			                    </td>
			                </tr>
			                <tr class="intro-tr">
			                    <td style="background-color:#23C293; width:100px; text-align:center;">
			                        <strong><span style="color: white;">작성자</span></strong>
			                    </td>
			                    <td style="text-align:left;">
			                        <span id="modal-writer">폼폼푸린</span>
			                    </td>
			                </tr>
			                <tr class="intro-tr">
			                    <td style="background-color:#23C293; width:100px; text-align:center;">
			                        <strong><span style="color: white;">본문</span></strong>
			                    </td>
			                    <td style="text-align:left;">
			                        <span id="modal-content">어쩌고저쩌고</span><br>
			                    </td>
			                </tr>
			                <tr class="intro-tr">
			                    <td style="background-color:#23C293; width:100px; text-align:center;">
			                        <strong><span style="color: white;">작성일</span></strong>
			                    </td>
			                    <td style="text-align:left;">
			                        <span id="modal-date">2024-06-06</span>
			                    </td>
			                </tr>
			            </table>
			        </div>
		        </div>
		
		        <!-- Modal footer -->
		        <div class="modal-footer">
			        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
		        </div>
	        </div>
	    </div>
    </div>
</body>
</html>