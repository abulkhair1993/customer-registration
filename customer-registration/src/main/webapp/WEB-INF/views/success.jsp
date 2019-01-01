<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" >
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app.js">
</script>
</head>
<body>
    <div class="container">
        <form action="" method="post" class="registration-box">
            <div class="row">
                <label for="first-name">First Name</label>
                <input type="text" name="first-name" id="first-name" />
            </div>
            <div class="row">
                <label for="last-name">Last Name</label>
                <input type="text" name="last-name" id="last-name" />
            </div>
            <div class="row">
                <label for="email">Email</label>
                <input type="text" name="email" id="email" />
            </div>
            <div class="row">
                <label for="mobile">Mobile</label>
                <input type="text" name="mobile" id="mobile" />
            </div>
            <div class="row">
                <input type="button" onclick="validate()" value="submit"/>
            </div>
        </form>
        <br><br>
        <div id="message"></div>
    </div>
</body>
</html>
