<%--
  ~ This file is part of websocktets-gl - simple WebSocket example
  ~ Copyright (C) 2012  Burt Parkers
  ~
  ~ This program is free software: you can redistribute it and/or modify
  ~ it under the terms of the GNU General Public License as published by
  ~ the Free Software Foundation, either version 3 of the License, or
  ~ (at your option) any later version.
  ~
  ~ This program is distributed in the hope that it will be useful,
  ~ but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~ MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  ~ GNU General Public License for more details.
  ~
  ~ You should have received a copy of the GNU General Public License
  ~ along with this program.  If not, see <http://www.gnu.org/licenses/>.

  author: Burt Parkers
  --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css" />" type="text/css" media="screen, projection">
    <style>
        body {
            padding-top: 60px;
        }
    </style>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap-responsive.css" />" type="text/css" media="screen, projection">
</head>

<body>

<c:url var="newUrl" value="/blogposts/new"/>
<c:url var="homeUrl" value="/"/>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">blogboard</a>

            <div class="nav-collapse">
                <ul class="nav">
                    <li class="active"><a href="${homeUrl}"><fmt:message key="nav.home"/></a></li>
                    <li><a href="${newUrl}"><fmt:message key="nav.new"/></a></li>
                </ul>
            </div>
        </div>
    </div>
</div>