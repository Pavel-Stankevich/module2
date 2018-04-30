<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<ui:html title="task11 modele2">
  <c:url var="registrationPage" value="/registration.html"/>
  <form:form method="post" action="${registrationPage}" modelAttribute="user">
    <ui:input name="email" type="email" label="Email" placeholder="Email" value="${user.email}"/>
    <ui:input name="password" type="password" label="Password" placeholder="Password"/>
    <ui:input name="fullName" label="Full name" placeholder="Full name" value="${user.fullName}"/>
    <ui:input name="address" label="Address" placeholder="Address" value="${user.address}"/>
    <ui:formGroup id="role.id" label="Role">
      <select class="form-control" id="role.id" name="role.id">
        <c:forEach var="role" items="${roles}">
          <option ${user.role.id eq role.id ? 'selected' : ''} value="${role.id}">${role.name}</option>
        </c:forEach>
      </select>
    </ui:formGroup>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form:form>
</ui:html>
