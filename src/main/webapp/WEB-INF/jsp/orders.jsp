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
      <th scope="col">Order id</th>
      <th scope="col">Owner id</th>
      <th scope="col">Owner email</th>
      <th scope="col">Owner full name</th>
      <th scope="col">Owner address</th>
      <th scope="col">Status</th>
      <th scope="col">Good id</th>
      <th scope="col">Good name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders}" varStatus="counter">
      <c:url var="editStatus" value="/editStatus.html"/>
     <form:form method="get" action="${editStatus}">
       <input type="hidden" name="orderId" value="${order.id}">
      <tr>
        <td>${counter.count}</td>
        <td>${order.id}</td>
        <td>${order.owner.id}</td>
        <td>${order.owner.email}</td>
        <td>${order.owner.fullName}</td>
        <td>${order.owner.address}</td>
        <td colspan="3">
            <select class="form-control" id="status" name="status">
              <c:forEach var="status" items="${statuses}">
                <option ${order.orderStatus eq status ? 'selected' : ''} value="${status}">${status}</option>
              </c:forEach>
            </select>
          <br>
          <button type="submit" class="btn btn-primary">Submit</button>
        </td>
      </tr>
     </form:form>
      <c:forEach var="good" items="${order.goods}">
        <tr>
        <td colspan="7"></td>
        <td>${good.id}</td>
        <td>${good.name}</td>
        </tr>
      </c:forEach>
    </c:forEach>
    </tbody>
  </table>
</ui:html>
