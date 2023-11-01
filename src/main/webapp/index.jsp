<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="author" content="Carlos" />
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
    <div class="container">
      <header>
        <div class="header-login">
          <button class="content-btn">Sing Up</button>
          <button class="content-btn">Login</button>
        </div>
      </header>

      <div class="home">
        <h1>ENRULE</h1>
        <p>
          Enrule ayuda a las empresas a reclutar trabajadores de manera
          efectiva, además servirá como un recurso valioso para personas en
          busca de empleo o interesadas en cambiar de trabajo.
        </p>
      </div>

      <!--Popup-->
      <div class="popup" id="popup">
        <div class="popup-content" id="popup-content">
          <form
            id="form-sign-up"
            class="form-sign-up"
            action="SvUser"
            method="POST"
            enctype="multipart/form-data"
          >
            <h2 class="form-title">Registrese</h2>
            <div id="questions">
              <div class="user-questions">
                <div class="question">
                  <label>Correo</label
                  ><input type="email" name="email" required />
                </div>
                <div class="question">
                  <label>Contraseña</label
                  ><input type="password" name="password" required />
                </div>
                <div class="question">
                  <label>Elija una de las dos opciones</label>
                  <span
                    ><input
                      type="radio"
                      name="option"
                      value="normal"
                      id="normal-user-option"
                      required
                    />
                    Normal
                  </span>
                  <span>
                    <input
                      type="radio"
                      name="option"
                      value="company"
                      id="company-user-option"
                      required
                    />Empresa</span
                  >
                </div>
              </div>
              <div id="normal-user-questions" class="hidden">
                <div class="question">
                  <label>DNI</label
                  ><input type="text" name="dni" required disabled />
                </div>
                <div class="question">
                  <label>Profesión</label
                  ><input type="text" name="profession" required disabled />
                </div>
                <div class="question">
                  <label>CV (opcional):</label>
                  <input type="file" name="cv" accept=".pdf, .docx" disabled />
                </div>
              </div>
              <div id="company-user-questions" class="hidden">
                <div class="question">
                  <label>RUC</label
                  ><input type="text" name="ruc" required disabled />
                </div>
                <div class="question">
                  <label>Descripción</label
                  ><input type="text" name="description" required disabled />
                </div>
              </div>
              <div class="question">
                <label>Foto de perfil</label
                ><input type="file" name="image" accept="image/*" />
              </div>
            </div>
            <input type="submit" value="Registrese" />
            <a id="hyper-login" class="hyper" href="#"
              >¿Ya tienes una cuenta?</a
            >
          </form>
          <form
            id="form-login"
            class="form-login"
            action="SvLogin"
            method="POST"
          >
            <h2 class="form-title">Iniciar Sesión</h2>
            <div class="user-questions">
              <div class="question">
                <label>Correo</label
                ><input type="email" name="email" required />
              </div>
              <div class="question">
                <label>Contraseña</label
                ><input type="password" name="password" required />
              </div>
            </div>

            <input type="submit" value="Iniciar sesion" />

            <a id="hyper-sign-up" class="hyper" href="#"
              >¿No estas registrado?</a
            >
          </form>
          <button class="close-btn" id="close-btn">
            <i class="fa-solid fa-x"></i>
          </button>
        </div>
      </div>
    </div>

    <script src="./js/code.js"></script>
  </body>
</html>
