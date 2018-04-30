<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<%@ attribute name="title" required="false" %>
<!DOCTYPE html>
<html>
<head>
  <c:if test="${not empty title}">
    <title>${title}</title>
  </c:if>
  <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
  <link rel="stylesheet" href="<c:url value="/css/bootstrap-grid.min.css"/>">
  <link rel="stylesheet" href="<c:url value="/css/bootstrap-reboot.min.css"/>">
</head>
<body>
<div class="container">
  <jsp:doBody/>
</div>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>
