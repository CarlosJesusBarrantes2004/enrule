<%@page import="logic.User"%> <%@page contentType="text/html"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="author" content="Carlos, Marcelo, Hector" />
    <meta name="keywords" content="jobs, link, web" />
    <meta name="description" content="" />
    <title>ENRULE</title>

    <link rel="stylesheet" href="css/style.css" />
    <script
      src="https://kit.fontawesome.com/ef5a8b4bfd.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
    <div class="container-xxl">
      <% User user = (User) request.getSession().getAttribute("user");%>
      <form action="" method="post">
        <label>Correo</label>
        <input type="text" placeholder="<%=user.getEmail()%>" disabled />
        <label>Contraseña</label>
        <input type="password" placeholder="<%=user.getHashedPassword()%>" />

        <c:choose>
          <c:when test="${type eq 'normal'}">
            <input type="file" name="cv" value="${user.getCv()}" />
          </c:when>
          <c:when test="${type eq 'company'}">
            <input type="text" name="description" value="${user.description}" />
          </c:when>
        </c:choose>
      </form>
    </div>
  </body>
</html>
