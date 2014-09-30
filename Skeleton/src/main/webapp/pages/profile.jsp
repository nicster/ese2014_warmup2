<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<h1>${aUser.firstName } ${aUser.lastName}'s Profile</h1>

<table>
  <tr>
    <th>User</th>
    <th>${aUser.id }</th>
  </tr>
  <tr>
  	<td>First Name</td>
  	<td>${aUser.firstName }</td>
  </tr>
  <tr>
  	<td>Last Name</td>
  	<td>${aUser.lastName }</td>
  </tr>
  <tr>
  	<td>E-Mail</td>
  	<td>${aUser.email }</td>
  </tr>
  <tr>
  	<td>Address</td>
  	<td>${aUser.address.street }</td>
  </tr>
  <tr>
  	<td>Team</td>
  	<td>${aUser.teamName }</td>
  </tr>
</table>


<c:import url="template/footer.jsp" />