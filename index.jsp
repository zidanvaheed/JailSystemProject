<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <!-- Bootstrap link for css-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <!-- css file link-->
    <style> <%@include file="/css/loginstyle.css" %> </style>
    <title>Jail Login Panel</title>
</head>
<body>
<!-- Bootstrap script links-->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<nav class="navbar navbar-style">
    <div class="container-0">
        <div class="image">
            <img class="img1" src="https://www.pinclipart.com/picdir/big/302-3022011_tribal-tattoos-clipart-transparent-background-png-download.png" alt="cool logo">
        </div>
    </div>
</nav>
<section class="Form" my-4 mx-5>
    <div class="container">
        <div class="row">
            <div class="col-lg-7">
                <h1 class="font-weight-bold py-3">Admin Login</h1>
                <form action="index" method="post">
                    <div class="form-row">
                        <div class="col-lg-7">
                            <label id="email" for="email">Email:</label>
                            <input  class="form-control" name="email" size="30" my-3 p-4>
                     </div>
                    </div>
                    <div class="form-row">
                        <div class="col-lg-7">
                            <label id="password" for="password">Password:</label>
                            <input  class="form-control" type="password" name="password" size="30" my-3 p-4>
                        </div>
                    </div>
                    <br>${message}
                    <div class="form-row">
                        <div class="col-lg-7">
                            <button type="submit" class="btn1 mt-3">Login</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
<!-- JS script for validation purposes-->
<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
<script type="text/javascript">

    $(document).ready(function() {
        $('#loginForm').validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },

                password: "required",
            },

            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },

                password: "Please enter password"
            }
        });

    });
</script>
</html>