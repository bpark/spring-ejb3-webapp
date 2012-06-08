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

    <h1><fmt:message key="spam.title"/></h1>

    <p><fmt:message key="spam.message"/></p>

    <p><a class="btn btn-primary btn-large" href="${homeUrl}"><fmt:message key="button.ok"/></a></p>

</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>