package com.quantum.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quantum.entities.*;
import com.quantum.model.*;

/**
 * Servlet implementation class ServicioServlet
 */
@WebServlet("/")
public class ServicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicioDAO ServicioDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServicioServlet() {
		super();
		ServicioDAO = new ServicioDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

		System.out.println(action);
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertServicio(request, response);
				break;
			case "/delete":
				deleteServicio(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateServicio(request, response);
				break;
			default:
				listServicio(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("RegistroServicio.jsp");
		dispatcher.forward(request, response);
	}

	private void insertServicio(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String tienda = request.getParameter("tienda");
		Servicio newServicio = new Servicio();
		newServicio.setNombre(nombre);
		newServicio.setDescripcion(descripcion);
	//	Tienda tienda1 = TiendaDAO.find();
		ServicioDAO.insert(newServicio);
		response.sendRedirect("list");
	}

	private void listServicio(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Servicio> listServicio = ServicioDAO.list();
		request.setAttribute("listUser", listServicio);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		// User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		// request.setAttribute("user", existingUser);
		// dispatcher.forward(request, response);

	}

	private void updateServicio(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		// User book = new User(id, name, email, country);
		// userDAO.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteServicio(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		// userDAO.deleteUser(id);
		response.sendRedirect("list");

	}

}