<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 05.02.2019
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>USER REGISTRATION</title>
</head>
<body>
<form action="FrontController" method=post>
    <input type="hidden" name="action" value="registration"/>
    <center>
        <table cellpadding=4 cellspacing=2 border=0>

            <th bgcolor="#CCCCFF" colspan=2>
                <font size=5>USER REGISTRATION</font>

                <font size=1>* Required Fields</font>
            </th>
            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    First Name*

                    <input type="text" name="login" value="" size=20 maxlength=20></td>
                <td  valign=top>
                    Login*

                    <input type="text" name="name" value="" size=20 maxlength=20></td>
            </tr>
            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    Surname*

                    <input type="text" name="surname" value="" size=25  maxlength=125>
                </td>
            </tr>
            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    Name*

                    <input type="text" name="name" value="" size=25  maxlength=125>
                </td>
            </tr>
            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    E-Mail*

                    <input type="text" name="email" value="" size=25  maxlength=125>
                </td>
            </tr>

            <tr bgcolor="#c8d8f8">
                <td valign=top colspan=2>
                    Registration date*

                    <input type="text" name="date_Registration" size=10 value=""  maxlength=10>
                </td>
            </tr>

            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    Password*

                    <input type="password" name="password1" size=10 value=""
                           maxlength=10></td>
                <td  valign=top>
                    Confirm Password*

                    <input type="password" name="password2" size=10 value=""
                           maxlength=10></td>
            </tr>
            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    Role *
                    <input type="text" name="role" size=20 value=""  maxlength=20>
                </td>
            </tr>
            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    Sex *
                    <input type= "radio" name="male" value="M"  maxlength=1>
                    <input type= "radio" name="female" value="?"  maxlength=1>
                </td>
            </tr>
            <tr bgcolor="#c8d8f8">
                <td  align=center colspan=2>
                    <input type="submit" value="Registration">
                    <input type="reset" value="Reset">
                </td>
            </tr>
            <c:if test="${not empty  requestScope.errorMessage }">
                <script type="text/javascript" >alert("${  requestScope.errorMessage }");</script>
            </c:if>
        </table>
    </center>
</form>
</body>
</html>
