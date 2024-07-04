package cl.praxis.firstprojectdao.controller;

import cl.praxis.firstprojectdao.model.UserDTO;
import cl.praxis.firstprojectdao.service.UserService;
import cl.praxis.firstprojectdao.service.serviceimpl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private UserService objUserService;

    // Método init para inicializar el DAO
    public void init() {
        objUserService = new UserServiceImpl();
    }

    // Método doGet para manejar las solicitudes GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateUser(request, response);
                    break;
                case "view":
                    viewUser(request, response);
                    break;
                default:
                    listUsers(request, response);
                    break;
            }
        } catch(SQLException ex) {
            throw new ServletException(ex);
        }
    }
    // Método doPost para manejar las solicitudes POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    // Método para listar todos los usuarios
    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<UserDTO> listUsers = objUserService.selectAllUsers();
        request.setAttribute("listUsers", listUsers);
        request.getRequestDispatcher("user-list.jsp").forward(request, response);
    }

    // Método para mostrar el formulario para un nuevo usuario
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("user-form.jsp").forward(request, response);
    }

    // Método para insertar un nuevo usuario y redirigir a la lista de usuarios
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        UserDTO newUser = new UserDTO(name,lastName,email,age);
        objUserService.insertUser(newUser);
        response.sendRedirect("user");
    }

    // Método para mostrar el formulario de edición de usuario
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDTO existingUser = objUserService.selectUser(id);
        request.setAttribute("user", existingUser);
        request.getRequestDispatcher("user-form.jsp").forward(request, response);
    }

    // Método para actualizar un usuario existente y redirigir a la lista de usuarios
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        Integer age = Integer.parseInt(request.getParameter("age"));
        UserDTO user = new UserDTO(id, name, lastName, email, age);
        objUserService.updateUser(user);
        response.sendRedirect("user");
    }

    // Método para eliminar un usuario
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        objUserService.deleteUser(id);
        response.sendRedirect("user");
    }

    // Método para ver los detalles de un usuario
    private void viewUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDTO user = objUserService.selectUser(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("user-view.jsp").forward(request, response);
    }
}
