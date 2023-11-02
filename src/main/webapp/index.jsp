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

    <link href="css/style.css" rel="stylesheet" />
    <script
      src="https://kit.fontawesome.com/ef5a8b4bfd.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
    <div class="container-xxl">
      <header class="d-flex m-2 justify-content-end align-items-center">
        <button
          class="btn me-2"
          data-bs-toggle="modal"
          data-bs-target="#popup-sign-up"
        >
          Sing Up
        </button>
        <button
          class="btn"
          data-bs-toggle="modal"
          data-bs-target="#popup-login"
        >
          Login
        </button>
      </header>

      <div class="home mt-5 text-center">
        <h1>ENRULE</h1>
        <p>
          Enrule ayuda a las empresas a reclutar trabajadores de manera
          efectiva, además servirá como un recurso valioso para personas en
          busca de empleo o interesadas en cambiar de trabajo.
        </p>
      </div>

      <!--Popup-->
      <div
        class="modal fade"
        id="popup-sign-up"
        tabindex="-1"
        aria-labelledby="popup-sign-upLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog modal-dialog-centered modal-lg">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="popup-sign-upLabel">Regístrate</h5>
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <div class="modal-body" style="max-height: 80vh; overflow-y: auto">
              <form
                id="form-sign-up"
                class="form-sign-up"
                action="SvUser"
                method="POST"
                enctype="multipart/form-data"
              >
                <div class="mb-3">
                  <label for="email" class="form-label">Correo</label>
                  <input
                    type="email"
                    class="form-control"
                    id="email"
                    name="email"
                    required
                  />
                </div>
                <div class="mb-3">
                  <label for="password" class="form-label">Contraseña</label>
                  <input
                    type="password"
                    class="form-control"
                    id="password"
                    name="password"
                    required
                  />
                </div>
                <div class="mb-3">
                  <label>Elija una de las dos opciones</label><br />
                  <div class="form-check form-check-inline">
                    <input
                      class="form-check-input"
                      type="radio"
                      name="option"
                      value="normal"
                      id="normal-user-option"
                      required
                    />
                    <label class="form-check-label" for="normal-user-option"
                      >Normal</label
                    >
                  </div>
                  <div class="form-check form-check-inline">
                    <input
                      class="form-check-input"
                      type="radio"
                      name="option"
                      value="company"
                      id="company-user-option"
                      required
                    />
                    <label class="form-check-label" for="company-user-option"
                      >Empresa</label
                    >
                  </div>
                </div>
                <div id="normal-user-questions" class="hidden">
                  <div class="mb-3">
                    <label for="dni" class="form-label">DNI</label>
                    <input
                      type="text"
                      class="form-control"
                      id="dni"
                      name="dni"
                      required
                      disabled
                    />
                  </div>
                  <div class="mb-3">
                    <label for="profession" class="form-label">Profesión</label>
                    <input
                      type="text"
                      class="form-control"
                      id="profession"
                      name="profession"
                      required
                      disabled
                    />
                  </div>
                  <div class="mb-3">
                    <label for="cv" class="form-label">CV (opcional)</label>
                    <input
                      type="file"
                      class="form-control"
                      id="cv"
                      name="cv"
                      accept=".pdf, .docx"
                      disabled
                    />
                  </div>
                </div>
                <div id="company-user-questions" class="hidden">
                  <div class="mb-3">
                    <label for="ruc" class="form-label">RUC</label>
                    <input
                      type="text"
                      class="form-control"
                      id="ruc"
                      name="ruc"
                      required
                      disabled
                    />
                  </div>
                  <div class="mb-3">
                    <label for="description" class="form-label"
                      >Descripción</label
                    >
                    <input
                      type="text"
                      class="form-control"
                      id="description"
                      name="description"
                      required
                      disabled
                    />
                  </div>
                </div>
                <div class="mb-3">
                  <label for="image" class="form-label">Foto de perfil</label>
                  <input
                    type="file"
                    class="form-control"
                    id="image"
                    name="image"
                    accept="image/*"
                  />
                </div>
                <button type="submit" class="btn btn-primary">
                  Regístrate
                </button>
                <a id="hyper-login" class="hyper" href="#"
                  >¿Ya tienes una cuenta?</a
                >
              </form>
            </div>
          </div>
        </div>
      </div>

      <div
        class="modal fade"
        id="popup-login"
        tabindex="-1"
        aria-labelledby="popup-loginLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog modal-dialog-centered modal-lg">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="popup-loginLabel">Iniciar Sesión</h5>
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <div class="modal-body" style="max-height: 80vh; overflow-y: auto">
              <form
                id="form-login"
                class="form-login"
                action="SvLogin"
                method="POST"
              >
                <div class="mb-3">
                  <label for="email" class="form-label">Correo</label>
                  <input
                    type="email"
                    class="form-control"
                    id="email"
                    name="email"
                    required
                  />
                </div>
                <div class="mb-3">
                  <label for="password" class="form-label">Contraseña</label>
                  <input
                    type="password"
                    class="form-control"
                    id="password"
                    name="password"
                    required
                  />
                </div>

                <button type="submit" class="btn btn-primary">
                  Iniciar sesión
                </button>

                <a id="hyper-sign-up" class="hyper" href="#"
                  >¿No estás registrado?</a
                >
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>
    <script src="./js/code.js"></script>
  </body>
</html>
