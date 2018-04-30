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
</head>
<body>
<div class="container-fluid">
  <jsp:doBody/>
</div>
</body>
</html>
