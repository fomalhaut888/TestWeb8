<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	private String addZero(String s){
		if(s == null){
			return null;
		}else if(s.length() >= 4){
			return s;
		}else if(s.length() == 3){
			return "0" + s;
		}else if(s.length() == 2){
			return "00" + s;
		}else if(s.length() == 1){
			return "000" + s;
		}else if(s.length() == 1){
			return "000" + s;
		}else{
			return "0000";
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.blockStyle{
	width: 10px;
	height: 10px;
	border: 1px solid;
	margin-bottom: 5px;
	display: inline-block;
}

.linkStyle{
	border: 1px solid;
	display: inline;
}
</style>
</head>
<body>
<div>
<% for(int i = 0; i < 256; i++ ){ 
	String hex = Integer.toHexString(i);
	String link;
	if(hex.length() == 1){
		link = "0" + hex.toUpperCase();
	}else{
		link = hex.toUpperCase();
	}%>
	<div class="linkStyle"><a href="cssColor.jsp?prefix=<%=link %>"><%=link %></a></div>
<% } %>
</div>
<div>
<% String prefix = (request.getParameter("prefix") == null)?"00": request.getParameter("prefix");
   for(int i = 0; i < 65535; i++ ){ 
	String colorStr = "#" + prefix + addZero(Integer.toHexString(i)).toUpperCase(); %>
	<div class="blockStyle" style="background: <%= colorStr %>" title="<%= colorStr %>" ></div>
<% } %>
</div>
</body>
</html>