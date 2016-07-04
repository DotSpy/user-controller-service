<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Zapili token ept</title>
    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootstrapCss"/>
</head>
<body>
<form name="createUser" id="createUser" method="post">
    Username: <input type="text" id="username" name="username"/><br/>
    Password: <input type="password" id="password" name="password"/><br/>
    <button class="submitBTN" onclick="searchViaAjax();">Submit</button>
</form>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
<script type="text/javascript">

    function searchViaAjax() {

        var search = {}
        search["username"] = $("#username").val();
        search["password"] = $("#password").val();

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "authorize",
            data: JSON.stringify(search),
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);
                display(data);
            },
            error: function (e) {
                console.log("ERROR: ", e);
                display(e);
            },
            done: function (e) {
                console.log("DONE");
            }
        });

    }
    //Ajax submit create user
    //    function ajaxSubmitCreateUserForm() {
    //        var user = {};
    //        user.name = $("#username").val();
    //        user.password = $("#password").val();
    //        var JSONObj = { "username":"name", "password":"pass" };
    //        $('#createUser').ajaxForm({
    //            headers: {
    //                Accept: 'application/json',
    //                'Content-Type': 'application/json'
    //            },
    //            url: 'authorize',
    //            type: "POST",
    //            data: JSON.stringify(JSONObj),
    //            dataType: 'json',
    //            contentType: 'application/json',
    //            success: function (response) {
    //                if (response.status == 'OK') {
    //                    alert("User/Developer is created");
    //                }
    //                else {
    //                    alert("FAILED, Try again ...");
    //                }
    //            },
    //            error: function () {
    //                alert('System error occured, please try again ...');
    //            }
    //        });
    //        $('#createUser').submit();
    //    }
</script>
</html>