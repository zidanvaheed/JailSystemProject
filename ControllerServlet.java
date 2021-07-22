package crud;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
    //private static final long serialVersionUID = 1L;
    private JailDAO jailDAO;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        jailDAO = new JailDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        //try method based on action

        try {
            switch (action) {
                case "/new" -> showNewForm(request, response);
                case "/insert" -> insertInmate(request, response);
                case "/delete" -> deleteInmate(request, response);
                case "/edit" -> showEditForm(request, response);
                case "/update" -> updateInmate(request, response);
                default -> listInmate(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listInmate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Jail> listJail = jailDAO.listAllBooks();
        request.setAttribute("listJail", listJail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("JailForm.jsp");
        dispatcher.forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Jail existingJail = jailDAO.getJail(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("JailForm.jsp");
        request.setAttribute("jail", existingJail);
        dispatcher.forward(request, response);

    }

    private void insertInmate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        String country = request.getParameter("country");
        String offense = request.getParameter("offense");
        String description = request.getParameter("description");

        Jail newJail = new Jail(name, sex, age, address, country, offense, description);
        jailDAO.insertBook(newJail);
        response.sendRedirect("list");
    }

    private void updateInmate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        String country = request.getParameter("country");
        String offense = request.getParameter("offense");
        String description = request.getParameter("description");

        Jail jail = new Jail(id, name, sex, age, address, country, offense, description);
        jailDAO.updateBook(jail);
        response.sendRedirect("list");
    }

    private void deleteInmate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Jail jail = new Jail(id);
        jailDAO.deleteBook(jail);
        response.sendRedirect("list");

    }
}