<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/4/25
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
    <script type="text/javascript" src="js/bootstrap.js" ></script>
    <script type="text/javascript">

    </script>
</head>
<body>

<div class="container">
    <form class="form-horizontal" action="#" method="get" >
        <div class="form-group">
            <label for="exampleInputName1">Username</label>
            <input type="text" class="form-control" id="exampleInputName1" placeholder="Username">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword2">Repassword</label>
            <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Repassword">
        </div>
        <div class="form-group">
            <label for="exampleInputRealName1">Realname</label>
            <input type="text" class="form-control" id="exampleInputRealName1" placeholder="Realname">
        </div>
        <div class="form-group">
            <label for="exampleInputCountry1">Country</label>
            <select class="form-control" id="exampleInputCountry1">
                <option>中国</option>
                <option>美国</option>
                <option>俄罗斯</option>
                <option>英国</option>
                <option>德国</option>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
        </div>
        <div class="form-group">
            <label for="exampleInputTelephone1">Telephone</label>
            <input type="tel" class="form-control" id="exampleInputTelephone1" placeholder="Telephone">
        </div>
        <div class="form-group">
            <label for="exampleInputAddress1">Address</label>
            <input type="text" class="form-control" id="exampleInputAddress1" placeholder="Address">
        </div>
        <div class="form-group">
            <label for="exampleInputBirthday1">Birthday</label>
            <input type="date" class="form-control" id="exampleInputBirthday1" >
        </div>
        <div class="form-group">
            <label >Male</label>
            <label class="radio-inline">
                <input type="checkbox" id="inlineCheckbox1" value="male"> male
            </label>
            <label class="radio-inline">
                <input type="checkbox" id="inlineCheckbox2" value="female"> female
            </label>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn btn-success">Success</button>
            </div>
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn btn-danger">Cancel</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>

