<%@page import="logic.CompanyUser"%> <%@page import="logic.NormalUser"%> <%@page
import="logic.User"%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
      <form action="SvEditUser" method="post" enctype="multipart/form-data">
        <div class="form-group">
          <label for="correo">Correo</label>
          <input
            type="text"
            class="form-control"
            id="correo"
            value="<%=user.getEmail() %>"
          />
        </div>
        <div class="form-group">
          <label for="contraseña">Contraseña</label>
          <input
            type="password"
            class="form-control"
            id="contraseña"
            value="<%=user.getHashedPassword() %>"
          />
        </div>

        <% if(user instanceof NormalUser){ NormalUser useN = (NormalUser) user;
        %>
        <div class="form-group">
          <label for="dni">DNI</label>
          <input
            type="text"
            class="form-control"
            id="dni"
            value="<%=useN.getDni()%>"
          />
        </div>
        <div class="form-group">
          <label for="profesion">Profesión</label>
          <input
            type="text"
            class="form-control"
            id="profesion"
            value="<%=useN.getProfession() %>"
          />
        </div>
        <div class="form-group">
          <label for="cv">CV</label>
          <input
            type="file"
            class="form-control-file"
            id="cv"
            value="<%=useN.getCv() %>"
          />
        </div>
        <% } else if (user instanceof CompanyUser) { CompanyUser useC =
        (CompanyUser) user; %>
        <div class="form-group">
          <label for="descripcion">Descripción</label>
          <input
            type="text"
            class="form-control"
            id="descripcion"
            value="<%=useC.getDescription() %>"
          />
        </div>
        <% } %>
        <button type="submit" class="btn btn-primary">Enviar</button>
      </form>
    </div>
  </body>
</html>
