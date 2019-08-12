<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<html>
<head>
	<title>Login</title>
	<!-- import bootstrap -->
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<!--Custom styles-->
	<link rel="stylesheet"  href="resources/css/styles.css">
</head>
<body>
   
    
    
   
     
     <!-- /login?error=true -->
     <c:if test="${param.error == 'true'}">
         <div style="color:red;margin:10px 0px;">
          
                Login Failed!!!<br />
                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                 
         </div>
    </c:if>
       
     
   <div class="container">
   <form class="form-signin" name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
   		<h2 class="form-signin-heading">Please sign in</h2>
        <label for="username" class="sr-only">Email address</label>
        <input type='text' name='username' class="form-control" placeholder="User Name" required autofocus>
        <label for="password" class="sr-only">Password</label>
        <input type='password' name='password' class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
      
    </form>
    </div> <!-- /container -->
</body>
</html>