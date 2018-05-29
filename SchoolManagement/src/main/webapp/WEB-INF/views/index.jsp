<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <title>Home - School Management</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
      <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
      <script src="<c:url value="/resources/js/popper.min.js"/>"></script>
      <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
   </head>
   <style>
      .card{
      width:350px;
      margin:0px auto;
      }
      #background {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background-image: url('resources/images/bg.jpg');
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-size: 100%;
      opacity: 0.4;
      filter:alpha(opacity=40);
      }
      #header-title{
      text-align:center;
      margin:25px; 
      text-transform:uppercase;
      }
   </style>
   <body>
      <div id="background"></div>
      <div class="container">
         <div class="row">
            <div class="col-12" id="header-title">
               <h2>School Management System</h2>
            </div>
         </div>
         <div class="row">
            <div class="col-6">
               <div class="card">
                  <img class="card-img-top" src="<c:url value="/resources/images/img_avatar1.png"/>" alt="Card image" style="width:100%"/>
                  <div class="card-body">
                     <h4 class="card-title">Student Management</h4>
                     <a href="<c:url value="/student"/>" class="btn btn-primary">Open Panel</a>
                  </div>
               </div>
            </div>
            <div class="col-6">
               <div class="card">
                  <img class="card-img-bottom" src="<c:url value="/resources/images/img_avatar6.png" />" alt="Card image" style="width:100%"/>
                  <div class="card-body">
                     <h4 class="card-title">Teacher Management</h4>
                     <a href="<c:url value="/teacher"/>" class="btn btn-primary">Open Panel</a>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </body>
</html>