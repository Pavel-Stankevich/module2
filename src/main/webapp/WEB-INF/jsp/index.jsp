<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<ui:html title="task11 modele2">
  <c:url var="loginPage" value="/login.html"/>
  <form:form method="post" action="${loginPage}" modelAttribute="user">
    <ui:input name="email" type="email" label="Email" placeholder="Email"/>
    <ui:input name="password" type="password" label="Password" placeholder="Password"/>
    <button type="submit" class="btn btn-primary">Submit</button>
    <a class="btn btn-success" href="<c:url value="/registration.html"/>">Registration</a>
  </form:form>
</ui:html>
