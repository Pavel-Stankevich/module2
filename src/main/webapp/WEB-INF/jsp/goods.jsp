<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<ui:html title="task11 modele2">
  <table class="table table-sm table-hover">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Product name</th>
      <th scope="col">Count</th>
      <th scope="col">Buy now</th>
      <th scope="col">Add to cart</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="good" items="goods" varStatus="status">
      <tr>
        <td scope="row">${status.count}</td>
        <td>${good.name}</td>
        <td>${good.count}</td>
        <td>Buy now</td>
        <td>Add to cart</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</ui:html>
