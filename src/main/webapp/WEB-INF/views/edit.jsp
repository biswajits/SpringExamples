<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Manage Customers</h1>
 
    <c:url var="editAction" value="/customer/edit/{id}"></c:url>
    
 	<c:out value="${customer}"></c:out>
    <form:form action="${editAction}" commandName="customer">
        <table>
            <c:if test="${!empty customer.name}">
                <tr>
                    <td><form:label path="id">
                            <spring:message text="ID" />
                        </form:label></td>
                    <td><form:input path="id" readonly="true" size="8"
                            disabled="true" /> <form:hidden path="id" /></td>
                </tr>
            </c:if>
            <tr>
                <td><form:label path="name">
                        <spring:message text="Name" />
                    </form:label></td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td><form:label path="address">
                        <spring:message text="Address" />
                    </form:label></td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td colspan="2">
                        <input type="submit"
                            value="<spring:message text="Edit Customer"/>" />
                    </td>
            </tr>
        </table>
    </form:form>

</body>
</html>