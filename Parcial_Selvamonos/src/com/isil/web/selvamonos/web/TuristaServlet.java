package com.isil.web.selvamonos.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isil.web.selvamonos.dao.TuristaDao;
import com.isil.web.selvamonos.model.Turista;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class TuristaServlet extends HttpServlet {
	
	 private static final long serialVersionUID = 1L;
	    private TuristaDao turistaDao;

	    public void init() {
	        turistaDao = new TuristaDao();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        doGet(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        String action = request.getServletPath();

	        try {
	            switch (action) {
	                case "/new":
	                    showNewForm(request, response);
	                    break;
	                case "/insert":
	                    insertTourist(request, response);
	                    break;
	                case "/delete":
	                    deleteTourist(request, response);
	                    break;
	                case "/edit":
	                    showEditForm(request, response);
	                    break;
	                case "/update":
	                    updateTourist(request, response);
	                    break;
	                default:
	                    listTourist(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }

	    private void listTourist(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
	        List < Turista > listUser = turistaDao.getAllTurista();
	        request.setAttribute("listUser", listUser);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("tourist-list.jsp");
	        dispatcher.forward(request, response);
	    }

	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("tourist-form.jsp");
	        dispatcher.forward(request, response);
	    }

	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Turista existingUser = turistaDao.getTurista(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("tourist-form.jsp");
	        request.setAttribute("tourist", existingUser);
	        dispatcher.forward(request, response);

	    }

	    private void insertTourist(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {
	        String name = request.getParameter("name");
	        String apellido = request.getParameter("apelido");
	        String documento = request.getParameter("documento");
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	        
	        Date nacimiento=null;
			try {
				nacimiento = dateFormat.parse(request.getParameter("nacimiento"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	        String origen = request.getParameter("origen");
	        String destino = request.getParameter("destino");
	        String hotel = request.getParameter("hotel");
	        int costo = Integer.parseInt(request.getParameter("costo"));
	        String email = request.getParameter("email");
	        Date iniciotour=null;
			try {
				iniciotour = dateFormat.parse(request.getParameter("iniciotour"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        Date fintour=null;
			try {
				fintour = dateFormat.parse(request.getParameter("fintour"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        Turista newTourist = new Turista(name, apellido, documento,nacimiento,origen,
	        		destino,hotel,costo,email,iniciotour,fintour);

	        turistaDao.saveTurista(newTourist);
	        response.sendRedirect("list");
	    }

	    private void updateTourist(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String apellido = request.getParameter("apelido");
	        String documento = request.getParameter("documento");
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	        
	        Date nacimiento=null;
			try {
				nacimiento = dateFormat.parse(request.getParameter("nacimiento"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	        String origen = request.getParameter("origen");
	        String destino = request.getParameter("destino");
	        String hotel = request.getParameter("hotel");
	        int costo = Integer.parseInt(request.getParameter("costo"));
	        String email = request.getParameter("email");
	        Date iniciotour=null;
			try {
				iniciotour = dateFormat.parse(request.getParameter("iniciotour"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        Date fintour=null;
			try {
				fintour = dateFormat.parse(request.getParameter("fintour"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        Turista turista = new Turista(name, apellido, documento,nacimiento,origen,
	        		destino,hotel,costo,email,iniciotour,fintour);
	        turistaDao.updateTurista(turista);
	        response.sendRedirect("list");
	    }

	    private void deleteTourist(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        turistaDao.deleteTurista(id);
	        response.sendRedirect("list");
	    }
}
