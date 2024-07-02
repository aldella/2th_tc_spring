/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.87
 * Generated at: 2024-06-28 06:21:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>B강의장 프로젝트 입니다</title>\r\n");
      out.write("<style>\r\n");
      out.write("	#content { height:500px; }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/menubar.jsp", out, false);
      out.write("\r\n");
      out.write("	<div id=\"content\">\r\n");
      out.write("	<a href=\"ajax2\"> test </a>\r\n");
      out.write("	<div class=\"innerOuter\">\r\n");
      out.write("		<h3>게시글 조회수 TOP5</h3>\r\n");
      out.write("		<br>\r\n");
      out.write("		<a href=\"boardlist\" style=\"float:right; color:lightgray; font-weight:800; font-size:14px;\">더보기</a>\r\n");
      out.write("		\r\n");
      out.write("		<table class=\"table table-hover\" align=\"center\" id=\"boardList\">\r\n");
      out.write("			<thead>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th>글번호</th>\r\n");
      out.write("					<th>제목</th>\r\n");
      out.write("					<th>작성자</th>\r\n");
      out.write("					<th>조회수</th>\r\n");
      out.write("					<th>작성일</th>\r\n");
      out.write("					<th>첨부파일</th>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</thead>\r\n");
      out.write("			<tbody>\r\n");
      out.write("				<!-- BOARD테이블에서 count컬럼값이 제일 높은 상위 5개의 게시글을 조회해서 뿌려줄 것 -->\r\n");
      out.write("			</tbody>\r\n");
      out.write("		</table>\r\n");
      out.write("		<table id=\"board-detail\" class=\"table\">\r\n");
      out.write("			<thead>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th></th>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</thead>\r\n");
      out.write("		</table>\r\n");
      out.write("	</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script>\r\n");
      out.write("	$(() => {\r\n");
      out.write("		findTopFiveBoard();\r\n");
      out.write("		\r\n");
      out.write("	})\r\n");
      out.write("	\r\n");
      out.write("	$(document).on('click','#boardList > tbody > tr', (e) => {\r\n");
      out.write("		const boardNo = $(e.currentTarget).children().eq(0).text();\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url : 'boards/'+boardNo,\r\n");
      out.write("			type : 'get',\r\n");
      out.write("			success : result => {\r\n");
      out.write("				console.log(result);\r\n");
      out.write("				let value = '';\r\n");
      out.write("				value += '<tr>'\r\n");
      out.write("					   + '<td width=\"300\">' +result.boardTitle+'</td>'\r\n");
      out.write("					   + '<td width=\"600\">' +result.boardContent+'</td>'\r\n");
      out.write("					   + '<td width=\"200\">' +result.Writer+'</td>'\r\n");
      out.write("					   + '</tr>';\r\n");
      out.write("				document.getElementById('board-detail').innerHTML=value;\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	function findTopFiveBoard() {\r\n");
      out.write("		\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url : 'boards',\r\n");
      out.write("			type : 'get',\r\n");
      out.write("			// data : 보낼 거 있을때만 적는건데 보낼 게 없으니까 적지말기\r\n");
      out.write("			success : boards => {\r\n");
      out.write("				let value=\"\";\r\n");
      out.write("				for(let i in boards) {\r\n");
      out.write("					value += \"<tr>\"\r\n");
      out.write("							+\"<td>\"+boards[i].boardNo+\"</td>\"\r\n");
      out.write("							+\"<td>\"+boards[i].boardTitle+\"</td>\"\r\n");
      out.write("							+\"<td>\"+boards[i].boardWriter+\"</td>\"\r\n");
      out.write("							+\"<td>\"+boards[i].count+\"</td>\"\r\n");
      out.write("							+\"<td>\"+boards[i].createDate+\"</td>\"\r\n");
      out.write("							+\"<td>\";\r\n");
      out.write("							if(boards[i].originName != null) {\r\n");
      out.write("								value+=\"有\";\r\n");
      out.write("							}\r\n");
      out.write("							value+=\"</td></tr>\";\r\n");
      out.write("				}\r\n");
      out.write("				$('#boardList tbody').html(value);\r\n");
      out.write("			},\r\n");
      out.write("			error : e => { console.log(e) }\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("	</script>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
