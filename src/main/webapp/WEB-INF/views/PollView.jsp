<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="false" %>
<html>
  <head>  
    <title>Psephoi Polling App</title>  
    <style>
    
    </style>
    
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
  <form method="post" action="pollresult">
  <div id="ctrl-as-choice" ng-controller="PollController as c">
  <table class="table">
  	<thead>
  		<tr>
  			<th scope="col"> Psephoi Polling App Question </th>
  		</tr>
  	</thead>
  	<tbody>
  		<tr>
  			<th scope="row"><input type="radio" name="ans" value="Yes" ng-model="c.poll"> Choice 1 </th>
  		</tr>
  		<tr>
 			<th scope="row"><input type="radio" name="ans" value="No" ng-model="c.poll"> Choice 2 </th>
  		</tr>
  		<tr>
 			<th scope="row"><input type="radio" name="ans" value="Maybe"> Neither </th>
  		</tr>
  		<tr>
  			<th scope="row"><input type="Submit" value="Submit"></th>
  		</tr>
  	</tbody>
  </table>
  </form>
      
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/poll_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/poll_controller.js' />"></script>
  </body>
</html>