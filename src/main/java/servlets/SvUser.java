package servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import logic.LogicController;
import logic.User;
import logic.NormalUser;
import logic.CompanyUser;

@MultipartConfig
@WebServlet(name = "SvUser", urlPatterns = {"/SvUser"})
public class SvUser extends HttpServlet {
    private final String PATH_CV = "/files/cv";
    private final String PATH_PHOTOS = "/files/photos";
    private final String SUBFOLDER_PHOTOS = "photos";
    private final String SUBFOLDER_CV = "cv";
    private final File UPLOAD_CV = new File(PATH_CV);
    private final File UPLOAD_PHOTOS = new File(PATH_PHOTOS);
    private final String[] PHOTO_EXTENSIONS = {".ico", ".png", ".jpg", ".jpeg"};
    private final String[] CV_EXTENSIONS = {".pdf", ".docx"};
    private final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImNhcmxvczIwMDRqYnMyMzA3QGdtYWlsLmNvbSJ9.I3Oopw-a4z195IpPrr6W2wBN6npbfHuOAicyKu9fY6Q";
    private final LogicController CONTROL = new LogicController();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    //User register
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = null;
        try {
            String selectOpt = request.getParameter("option");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Part partPhoto = request.getPart("image");
            String photo = null;

            if (partPhoto != null && isExtension(partPhoto.getSubmittedFileName(), PHOTO_EXTENSIONS)) {
                photo = saveFile(partPhoto, UPLOAD_PHOTOS, SUBFOLDER_PHOTOS);
            }

            if ("normal".equals(selectOpt)) {
                user = createUserFromApi(request, "dni", email, password, photo);
            } else if ("company".equals(selectOpt)) {
                user = createUserFromApi(request, "ruc", email, password, photo);
            }

            if (user != null) {
                if (user instanceof NormalUser) {
                    CONTROL.createNormalUser((NormalUser) user);
                } else if (user instanceof CompanyUser) {
                    CONTROL.createCompanyUser((CompanyUser) user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }

    private User createUserFromApi(HttpServletRequest request, String apiType, String email, String password, String photo) throws Exception {
        String identifier = request.getParameter(apiType);
        JsonObject json = fetchDataFromApi(identifier, apiType);

        if (json != null) {
            if ("dni".equals(apiType)) {
                String profession = request.getParameter("profession");
                Part partCv = request.getPart("cv");
                String cv = null;

                if (partCv != null && isExtension(partCv.getSubmittedFileName(), CV_EXTENSIONS)) {
                    cv = saveFile(partCv, UPLOAD_CV, SUBFOLDER_CV);
                }

                String name = json.getString("nombres") + " " + json.getString("apellidoPaterno") + " " + json.getString("apellidoMaterno");

                return new NormalUser(identifier, profession, cv, name, email, password, photo);
            } else if ("ruc".equals(apiType)) {
                String description = request.getParameter("description");
                String name = json.getString("razonSocial");
                String department = json.getString("departamento");
                String province = json.getString("provincia");
                String district = json.getString("distrito");
                String direction = json.getString("direccion");

                return new CompanyUser(identifier, description, department, province, district, direction, name, email, password, photo);
            }
        }

        return null;
    }

    private JsonObject fetchDataFromApi(String identifier, String apiType) {
        String apiUrl = "https://dniruc.apisperu.com/api/v1/" + apiType + "/" + identifier + "?token=" + TOKEN;

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                String jsonResponse = readResponseFromApi(connection);

                return parseJson(jsonResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String readResponseFromApi(HttpURLConnection connection) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            return responseBuilder.toString();
        }
    }

    private JsonObject parseJson(String json) {
        try (JsonReader jsonReader = Json.createReader(new StringReader(json))) {
            return jsonReader.readObject();
        }
    }

    private String saveFile(Part part, File pathUploads, String subfolder) {
        String pathRelative = "";

        try {
            Path path = Paths.get(part.getSubmittedFileName());
            String fileName = path.getFileName().toString();
            InputStream input = part.getInputStream();

            if (input != null) {
                ServletContext context = getServletContext();
                String absolutePath = context.getRealPath("/");
                File file = new File(absolutePath + "files/" + subfolder + "/" + fileName);

                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }

                pathRelative = "files/" + subfolder + "/" + fileName;
                Files.copy(input, file.toPath());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pathRelative;
    }

    private boolean isExtension(String fileName, String[] extensions) {
        for (String et : extensions) {
            if (fileName.toLowerCase().endsWith(et)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
