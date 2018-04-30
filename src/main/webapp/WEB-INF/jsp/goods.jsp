<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<ui:html title="task11 modele2">
  <table class="table table-hover">
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
    <c:forEach
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td colspan="2">Larry the Bird</td>
      <td>@twitter</td>
    </tr>
    </tbody>
  </table>
</ui:html>
