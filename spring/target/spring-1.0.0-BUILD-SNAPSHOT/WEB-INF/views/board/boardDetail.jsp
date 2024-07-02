<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style> 
        .content {
            background-color:rgb(247, 245, 245);
            width:80%;
            margin:auto;
        }
        .innerOuter {
            border:1px solid lightgray;
            width:80%;
            margin:auto;
            padding:5% 10%;
            background-color:white;
        }

        table * {margin:5px;}
        table {width:100%;}
    </style>
</head>
<body>
        
    <jsp:include page="../common/menubar.jsp" />

    <div class="content">
        <br><br>
        <div class="innerOuter">
            <h2>게시글 상세보기</h2>
            <br>

            <a class="btn btn-secondary" style="float:right;" href="">목록으로</a>
            <br><br>

            <table id="contentArea" align="center" class="table">
                <tr>
                    <th width="100">제목</th>
                    <td colspan="3">제목입니다요</td>
                </tr>
                <tr>
                    <th>${board.boardTitle }</th>
                    <td>${board.boardWriter }</td>
                    <th>작성일</th>
                    <td>${board.createDate }</td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td colspan="3">
			            <c:choose>
			            	<c:when test="${empty board.originName} ">
			            		첨부파일이 없습니다.
			            	</c:when>
			            	<c:otherwise>
			            		<a href="${board.changeName }" download="${board.originName }">${board.originName }</a>
			            	</c:otherwise>
			            </c:choose>
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3"></td>
                </tr>
                <tr>
                    <td colspan="4"><p style="height:150px;">${board.boardContent}</p></td>
                </tr>
            </table>
            <br>

            <div align="center">
            	<c:if test="${sessionScope.loginUser.userId eq requestScope.board.boardWriter }">
	                <!-- 수정하기, 삭제하기 버튼은 이 글이 본인이 작성한 글일 경우에만 보여져야 함 -->
                	<a class="btn btn-primary" onclick="postSubmit(this.innerHTML);">수정하기</a>
                	<a class="btn btn-primary" onclick="postSubmit(this.innerHTML);">삭제하기</a>
	                	
	                <form method="post" action="" id="postForm" method="post">
	                	<input type="hidden" name="boardNo" value="${board.boardNo }"/>
	                	<input type="hidden" name="filePath" value="${board.changeName }"/>
	                </form>
	                
	                <script>
	                	function postSubmit(el) {
	                		const attrValue = '수정하기' === el ? 'boardUpdateForm.do' : 'boardDelete.do';
	                		$('#postForm').attr('action', attrValue).submit();
	                	}
	                </script>
	                
                </c:if>
            </div>
            <br><br>

            <!-- 댓글 기능은 나중에 ajax 배우고 나서 구현할 예정! 우선은 화면구현만 해놓음 -->
            <table id="replyArea" class="table" align="center">
                <thead>
                    <tr>
						<c:choose>
							<c:when test="${ empty sessionScope.loginUser.userId }">
		                        <th colspan="3" style="vertical-align:middle">로그인된 사용자만 이용 가능합니다.</th> 
							</c:when>
							<c:otherwise>
								<th colspan="2">
		                            <textarea class="form-control" name="" id="content" cols="55" rows="2" style="resize:none; width:100%;">
		                            </textarea>
		                        </th>
		                        <th style="vertical-align:middle"><button class="btn btn-secondary" onclick="saveReply();">등록하기</button></th> 
							</c:otherwise>
						</c:choose>
						                    

                    </tr>
                    <tr>
                        <td colspan="3">댓글(<span id="rcount">3</span>)</td>
                    </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
        <br><br>

    </div>
	<script>
	
	$(() => {
		selectReply();
		
	})
	
	function saveReply() {
		if($('#content').val().trim() != '' ) {
			$.ajax({
				url : 'reply',
				data : {
					refBoardNo : ${board.boardNo},
					replyContent : $('#content').val(),
					replyWriter : '${sessionScope.loginUser.userId}'
				},
				type : 'post',
				success : result => {
					selectReply();
					$('#content').val('');
				}
			});
		} else {
			console.log('정규식 위반');
		}
	}
	
	function selectReply() {
		
		$.ajax({
			url : 'reply',
			get : 'get',
			data : {
				boardNo : ${ board.boardNo }
			},
			success : result => {
				//console.log(result);
				let resultStr = '';
				for (let i in result) {
					resultStr += '<tr>'
									+'<td>' + result[i].replyWriter + '</td>'
									+'<td>' + result[i].replyContent + '</td>'
									+'<td>' + result[i].createDate + '</td>'
									+ '<tr>';
				}
				$('#replyArea tbody').html(resultStr);
				$('#rcount').text(result.length);
			},
			error : e => {
				console.log(e);
			}
		});
		
	}
	
	</script>
	
	

    
    <jsp:include page="../common/footer.jsp" />
    
</body>
</html>