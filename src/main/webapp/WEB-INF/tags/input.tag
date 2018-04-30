<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="value" required="false" %>
<%@ attribute name="type" required="false" %>
<%@ attribute name="placeholder" required="false" %>
<ui:formGroup id="${name}" label="${label}">
  <input type="${empty type ? 'text' : type}" class="form-control" id="${name}" name="${name}" placeholder="${placeholder}" value="${value}">
</ui:formGroup>
