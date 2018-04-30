<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>
<div class="form-group">
  <label for="${id}">${label}</label>
  <jsp:doBody/>
</div>
