<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HttpServletRequest Method Demo</title>
</head>
<body>
<p>HttpServletRequest Methods:</p>
<p><%="request.authenticate(response)=" + request.authenticate(response) %>(Servlet 3.0)</p>
<p><%="request.getSession().getId()=" + request.getSession().getId() %></p>
<p><%="request.getRequestedSessionId()=" + request.getRequestedSessionId() %></p>
<p><%//="request.changeSessionId()=" + request.changeSessionId() %>(Servlet 3.1)</p>
<p><%="request.getAuthType()=" + request.getAuthType() %></p>
<p><%="request.getCharacterEncoding()=" + request.getCharacterEncoding() %></p>
<p><%="request.getContentLength()=" + request.getContentLength() %></p>
<p><%="request.getContentLengthLong()=" + request.getContentLengthLong() %></p>
<p><%="request.getContentType()=" + request.getContentType() %></p>
<p><%="request.getContextPath()=" + request.getContextPath() %></p>
<p><%="request.getDateHeader()=" + request.getDateHeader("") %></p>
<p><%="request.getHeader(\"\")=" + request.getHeader("") %></p>
<p><%="request.getIntHeader()=" + request.getIntHeader("") %></p>
<p><%="request.getLocalAddr()=" + request.getLocalAddr() %></p>
<p><%="request.getLocalName()=" + request.getLocalName() %></p>
<p><%="request.getLocalPort()=" + request.getLocalPort() %></p>
<p><%="request.getMethod()=" + request.getMethod() %></p>
<p><%="request.getParameter(\"a\")=" + request.getParameter("a") %></p>
<p><%="request.getPathInfo()=" + request.getPathInfo() %></p>
<p><%="request.getPathTranslated()=" + request.getPathTranslated() %></p>
<p><%="request.getProtocol()=" + request.getProtocol() %></p>
<p><%="request.getQueryString()=" + request.getQueryString() %></p>
<p><%="request.getRemoteAddr()=" + request.getRemoteAddr() %></p>
<p><%="request.getRemoteHost()=" + request.getRemoteHost() %></p>
<p><%="request.getRemotePort()=" + request.getRemotePort() %></p>
<p><%="request.getRemoteUser()=" + request.getRemoteUser() %></p>
<p><%="request.getRequestURI()=" + request.getRequestURI() %></p>
<p><%="request.getScheme()=" + request.getScheme() %></p>
<p><%="request.getServerName()=" + request.getServerName() %></p>
<p><%="request.getServerPort()=" + request.getServerPort() %></p>
<p><%="request.getServletPath()=" + request.getServletPath() %></p>
<p><%="request.getAsyncContext()=" + request.getAsyncContext() %>(Servlet 3.0)</p>
<p><%="request.getDispatcherType()=" + request.getDispatcherType() %>(Servlet 3.0)</p>
<p><%="request.getHeaderNames()=" + request.getHeaderNames() %></p>
<% Enumeration<String> en = request.getHeaderNames(); 
   while(en.hasMoreElements()){
   		String headerName = en.nextElement(); %>
<p><%="#headerName=" + headerName %></p>
<p><%="request.getHeaders(" + headerName + ")=" + request.getHeaders(headerName) %></p>
<%		Enumeration<String> hEn = request.getHeaders(headerName);%>
<p><%="request.getHeader(" + headerName + ")=" + request.getHeader(headerName) %></p>
<%		while(hEn.hasMoreElements()){
			String header = hEn.nextElement();%>
<p><%="$header=" + header %></p>
	<%	}%>
<% } %>
<p><%="request.getLocale()=" + request.getLocale() %></p>
<p><%="request.getRequestURL().toString()=" + request.getRequestURL().toString() %></p>
<p><%="request.getUserPrincipal()=" + request.getUserPrincipal() %></p>
</body>
</html>