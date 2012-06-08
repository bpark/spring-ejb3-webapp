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

<%@ include file="/WEB-INF/views/header.jsp" %>

<div class="container">

    <!-- Main hero unit for a primary marketing message or call to action -->
    <div class="hero-unit">
        <h1>blogboard.org</h1>
        <p><fmt:message key="blogboard.description"/></p>
        <p><a class="btn btn-primary btn-large" href="${newUrl}"><fmt:message key="blogboard.new"/></a></p>
    </div>

    <div class="row">
        <c:forEach var="article" items="${articles}">
            <div class="span4">
                <h2>${article.title}</h2>
                <p>${article.shortContent}&hellip;</p>
                <c:url var="articleUrl" value="/blogposts/${article.id}"/>
                <p><a class="btn" href="${articleUrl}">View full article &raquo;</a></p>
            </div>
        </c:forEach>
    </div>

</div>

<%@ include file="/WEB-INF/views/footer.jsp" %>