<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Psephoi Polling App</title>  
    <style>
      .pollname.ng-valid {
          background-color: green;
      }
      .pollname.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .pollname.ng-dirty.ng-invalid-minlength {
          background-color: orange;
      }

      .email.ng-valid {
          background-color: green;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: orange;
      }

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container text-center" ng-controller="PollController as ctrl">
          <div class="panel panel-default">
              <div class="d-flex justify-content-center"><span class="lead">Poll Registration Form </span></div>
              <div class="formcontainer text-center">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.poll.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                            <div class="col-md-3">
                            </div>
                              <div class="col-md-4">
                                  <input type="text" ng-model="ctrl.poll.pollname" name="uname" class="pollname form-control input-sm" placeholder="Enter your desired polls name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                                <label class="col-md-2 control-lable" for="file">Poll Name</label>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                          	<div class="col-md-3">
                            </div>
                              <div class="col-md-4">
                                  <input type="text" ng-model="ctrl.poll.description" class="form-control input-sm" placeholder="Enter your polls description"/>
                              </div>
                              	  <label class="col-md-2 control-lable" for="file">Description</label>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                          	<div class="col-md-3">
                            </div>
                              <div class="col-md-4">
                                  <input type="text" ng-model="ctrl.poll.choice1" class="form-control input-sm" placeholder="Enter Choices for Poll"/>
                              </div>
								  <label class="col-md-2 control-lable" for="file">Choice 1</label>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                          	<div class="col-md-3">
                            </div>
                              <div class="col-md-4">
                                  <input type="text" ng-model="ctrl.poll.choice2" class="form-control input-sm" placeholder="Enter Choices for Poll"/>
                              </div>
                              	  <label class="col-md-2 control-lable" for="file">Choice 2</label>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                          	<div class="col-md-3">
                            </div>
                              <div class="col-md-4">
                                  <input type="email" ng-model="ctrl.poll.email" name="email" class="email form-control input-sm" placeholder="Enter your Email" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                              		  <label class="col-md-2 control-lable" for="file">Email</label>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.poll.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Clear Form</button>  
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Current Polls </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover table-striped">
                      <thead>
                          <tr class="table-dark">
                              <th>#</th>
                              <th>Name</th>
                              <th>Description</th>
                              <th>Choice 1</th>
                              <th>Choice 2</th>
                              <th>Creator's Email</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr class="table-dark" ng-repeat="u in ctrl.polls">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.pollname"></span></td>
                              <td><span ng-bind="u.description"></span></td>
                              <td><span ng-bind="u.choice1"></span></td>
                              <td><span ng-bind="u.choice2"></span></td>
                              <td><span ng-bind="u.email"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>
                              <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
   							  <a ng-href="/pollview">Vote here</a>	
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/poll_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/poll_controller.js' />"></script>
  </body>
</html>