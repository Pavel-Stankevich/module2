<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<ui:html title="task11">
  <div class="row">
    <div class="col-md-6 offset-md-3">
      <table class="table">
        <thead>
        <tr>
          <th scope="col" width="3%">#</th>
          <th scope="col" width="3%"><spring:message code="label.id"/></th>
          <th scope="col"><spring:message code="label.login"/></th>
          <th scope="col" width="5%"><spring:message code="label.view"/></th>
          <th scope="col" width="5%"><spring:message code="label.edit"/></th>
          <th scope="col" width="5%"><spring:message code="label.delete"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}" varStatus="status">
          <tr>
            <c:url var="viewUrl" value="viewUser.html?userId=${user.id}"/>
            <c:url var="editUrl" value="editUser.html?userId=${user.id}"/>
            <c:url var="deleteUrl" value="deleteUser.html?userId=${user.id}"/>

            <th scope="row">${status.count}</th>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>
              <a class="btn btn-light btn-sm" href="${viewUrl}"><i class="fas fa-user-circle fa-lg"></i></a>
            </td>
            <td>
              <a class="btn btn-light btn-sm" href="${editUrl}"><i class="fas fa-pencil-alt fa-lg"></i></a></td>
            <td>
              <a class="btn btn-light btn-sm" href="${deleteUrl}"><i class="fas fa-trash-alt fa-lg"></i></a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
      <a class="btn btn-light" href="editUser.html"><i class="fas fa-user-plus fa-lg"></i><spring:message code="label.add"/></a>
      <a class="btn btn-light" href="?theme=white">White theme</a>
      <a class="btn btn-light" href="?theme=dark">Dark theme</a>
    </div>
  </div>
</ui:html>
