<%@page import="logic.User"%> <%@page import="logic.NormalUser"%> <%@page
contentType="text/html" pageEncoding="UTF-8"%>
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
    <div class="container">
      <header>
        <div class="header-container">
          <h2>Enrule</h2>

          <form action="#" method="post" class="searcher">
            <input class="field" type="text" name="" />
            <i class="fa-solid fa-magnifying-glass"></i>
          </form>
        </div>
      </header>

      <div class="main">
        <div class="panel pa-configuration">
          <div class="panel-info configuration">
            <% User user = (User) request.getSession().getAttribute("user");%>
            <h2>Tú</h2>
            <div class="profile-user">
              <div class="user">
                <a href="edit-user.jsp">
                  <img
                    src="<%=user.getPhoto() %>"
                    alt=""
                    width="50px"
                    height="50px"
                  />
                </a>
              </div>
              <div class="profile-details">
                <p><%=user.getName() %></p>
              </div>
            </div>
            <div class="buttons"></div>
          </div>
        </div>

        <div class="panel pa-content">
          <div class="content">
            <div class="ur-post">
              <textarea
                name=""
                id=""
                cols="30"
                rows="10"
                placeholder="Write here ..."
              ></textarea>
              <div class="ur-post-buttons">
                <button type="button" class="content-btn">
                  Write <i class="fa-regular fa-pen-to-square"></i>
                </button>
                <button type="button" class="content-btn">
                  File <i class="fa-regular fa-file"></i>
                </button>
                <button type="submit" class="content-btn">
                  Post <i class="fa-solid fa-location-arrow"></i>
                </button>
              </div>
            </div>
            <div class="horizontal-line"></div>
            <div class="posts">
              <div class="post">
                <div class="post-info">
                  <div class="user">
                    <img
                      src="./images/foto-1.jpg"
                      alt="Carlos Jesús Barrantes Saldarriaga"
                    />
                  </div>
                  <div class="post-details">
                    <span>Carlos Barrantes Saldarriaga</span>
                    <span>21.09pm 4/09/2023</span>
                  </div>
                  <i class="fa-solid fa-ellipsis-vertical"></i>
                </div>
                <div class="post-content">
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                  Harum quisquam similique, aliquam, tempore molestias dicta
                  atque saepe officiis possimus pariatur voluptatibus ab
                  laboriosam facilis neque eveniet, magni voluptates laudantium
                  recusandae? Excepturi eum asperiores cupiditate dolor
                  perferendis repudiandae esse debitis, veritatis deserunt
                  labore corrupti quasi, facere amet! Esse molestias quam
                  voluptatibus voluptates repudiandae, eveniet id ducimus saepe
                  facilis sapiente delectus libero?
                </div>
                <div class="post-response">
                  <i id="heart" class="fa-regular fa-heart purple-heart"></i>
                  <button type="button" class="content-btn">Responder</button>
                </div>
              </div>
              <div class="post">
                <div class="post-info">
                  <div class="user">
                    <img
                      src="./images/foto-2.jpg"
                      alt="Carlos Jesús Barrantes Saldarriaga"
                    />
                  </div>
                  <div class="post-details">
                    <span>Carlos Barrantes Saldarriaga</span>
                    <span>21.09pm 4/09/2023</span>
                  </div>
                  <i class="fa-solid fa-ellipsis-vertical"></i>
                </div>
                <div class="post-content">
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                  Harum quisquam similique, aliquam, tempore molestias dicta
                  atque saepe officiis possimus pariatur voluptatibus ab
                  laboriosam facilis neque eveniet, magni voluptates laudantium
                  recusandae? Excepturi eum asperiores cupiditate dolor
                  perferendis repudiandae esse debitis, veritatis deserunt
                  labore corrupti quasi, facere amet! Esse molestias quam
                  voluptatibus voluptates repudiandae, eveniet id ducimus saepe
                  facilis sapiente delectus libero?
                </div>
                <div class="post-response">
                  <i class="fa-regular fa-heart purple-heart"></i>
                  <button type="button" class="content-btn">Responder</button>
                </div>
              </div>
              <div class="post">
                <div class="post-info">
                  <div class="user">
                    <img
                      src="./images/foto-3.jpg"
                      alt="Carlos Jesús Barrantes Saldarriaga"
                    />
                  </div>
                  <div class="post-details">
                    <span>Carlos Barrantes Saldarriaga</span>
                    <span>21.09pm 4/09/2023</span>
                  </div>
                  <i class="fa-solid fa-ellipsis-vertical"></i>
                </div>
                <div class="post-content">
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                  Harum quisquam similique, aliquam, tempore molestias dicta
                  atque saepe officiis possimus pariatur voluptatibus ab
                  laboriosam facilis neque eveniet, magni voluptates laudantium
                  recusandae? Excepturi eum asperiores cupiditate dolor
                  perferendis repudiandae esse debitis, veritatis deserunt
                  labore corrupti quasi, facere amet! Esse molestias quam
                  voluptatibus voluptates repudiandae, eveniet id ducimus saepe
                  facilis sapiente delectus libero?
                </div>
                <div class="post-response">
                  <i class="fa-regular fa-heart purple-heart"></i>
                  <button type="button" class="content-btn">Responder</button>
                </div>
              </div>
              <div class="post">
                <div class="post-info">
                  <div class="user">
                    <img
                      src="./images/foto-4.jpg"
                      alt="Carlos Jesús Barrantes Saldarriaga"
                    />
                  </div>
                  <div class="post-details">
                    <span>Carlos Barrantes Saldarriaga</span>
                    <span>21.09pm 4/09/2023</span>
                  </div>
                  <i class="fa-solid fa-ellipsis-vertical"></i>
                </div>
                <div class="post-content">
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                  Harum quisquam similique, aliquam, tempore molestias dicta
                  atque saepe officiis possimus pariatur voluptatibus ab
                  laboriosam facilis neque eveniet, magni voluptates laudantium
                  recusandae? Excepturi eum asperiores cupiditate dolor
                  perferendis repudiandae esse debitis, veritatis deserunt
                  labore corrupti quasi, facere amet! Esse molestias quam
                  voluptatibus voluptates repudiandae, eveniet id ducimus saepe
                  facilis sapiente delectus libero?
                </div>
                <div class="post-response">
                  <i class="fa-regular fa-heart purple-heart"></i>
                  <button type="button" class="content-btn">Responder</button>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="panel pa-recommendations">
          <div class="panel-info recommendations">
            <div class="panel-title">
              <h3>Añadir a tus contactos</h3>
              <div class="a-style">
                <a href="./contactos-recom.jsp">Todos</a>
              </div>
            </div>
            <div class="rec-user">
              <div class="profile">
                <div class="user">
                  <img src="./images/foto-4.jpg" alt="Foto de perfil" />
                </div>
              </div>
              <div class="profile-plus-button">
                <div class="profile-info">
                  <span>Carlos Barrantes Saldarriaga</span>
                  <span>Descripción breve</span>
                </div>
                <div class="add">
                  <button class="content-btn">Añadir</button>
                </div>
              </div>
            </div>
            <div class="rec-user">
              <div class="profile">
                <div class="user">
                  <img src="./images/foto-1.jpg" alt="Foto de perfil" />
                </div>
              </div>
              <div class="profile-plus-button">
                <div class="profile-info">
                  <span>Carlos Barrantes Saldarriaga</span>
                  <span>Descripción breve</span>
                </div>
                <div class="add">
                  <button class="content-btn">Añadir</button>
                </div>
              </div>
            </div>
            <div class="rec-user">
              <div class="profile">
                <div class="user">
                  <img src="./images/foto-2.jpg" alt="Foto de perfil" />
                </div>
              </div>
              <div class="profile-plus-button">
                <div class="profile-info">
                  <span>Carlos Barrantes Saldarriaga</span>
                  <span>Descripción breve</span>
                </div>
                <div class="add">
                  <button class="content-btn">Añadir</button>
                </div>
              </div>
            </div>

            <div class="horizontal-line"></div>
          </div>
        </div>
      </div>
    </div>

    <script src="./js/code.js"></script>
  </body>
</html>
