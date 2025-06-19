package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Contatos;

import java.io.IOException;
import java.util.ArrayList;

import dao.ContatosDAO;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/main" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContatosDAO dao = new ContatosDAO();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/main")) {
			listaContatos(request,response);
		}
	}

	protected void listaContatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Contatos> listaDeContatos = dao.listarContatos();
		request.setAttribute("contatos", listaDeContatos);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

}
