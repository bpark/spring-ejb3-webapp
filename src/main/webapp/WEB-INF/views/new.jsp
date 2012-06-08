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

    <h1><fmt:message key="new.title"/></h1>

    <p><fmt:message key="new.description"/></p>

    <form:form modelAttribute="blogPost" method="post" class="well">
        <fieldset>
            <legend><fmt:message key="new.legend"/></legend>
            <p>
                <form:label	for="title" path="title"><fmt:message key="label.title"/></form:label>
                <form:input path="title" class="input-xxlarge"/>
            </p>
            <p>
                <form:label for="content" path="content"><fmt:message key="label.content"/></form:label>
                <form:textarea path="content" class="input-xxlarge" rows="9"/>
            </p>
            <p>
                <button type="submit" class="btn btn-primary"><fmt:message key="button.ok"/></button>
                <button class="btn"><fmt:message key="button.cancel"/></button>
            </p>
        </fieldset>
    </form:form>

</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>