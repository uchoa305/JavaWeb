package br.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import br.bean.Brinquedo;
import br.bean.Categoria;
import br.dao.BrinquedoDao;
import br.dao.CategoriaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import com.google.gson.Gson;
/**
 * Servlet implementation class ServletCategoria
 */

@WebServlet("/categorias")
public class ServletCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletCategorias() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// cmd indica o tipo de ação 
				String cmd = request.getParameter("cmd"); 
				CategoriaDao dao; 
				// objeto CRUD ~
				Categoria categoria = new Categoria(); 
				
				// verificando se o cmd nao vem vazio
				if(cmd != null) 
				{
					try 
					{
						String path = request.getServletContext().getRealPath("/img");
						String url = null; 
						categoria.setCategoria(request.getParameter("txtNomeCategoria"));
						categoria.setDescricao(request.getParameter("txtDescricao"));
						categoria.setStatus(Boolean.parseBoolean(request.getParameter("slcStatus")));
					}catch (Exception e) {
						e.printStackTrace();
						
					}
					
				}
				try
				{
					
					dao = new CategoriaDao(); 
					RequestDispatcher rd = null; 
					
					if(cmd.equalsIgnoreCase("listar")) 
					{
						
						List<Categoria> clist = dao.listarCategorias();
		                Gson json = new Gson();
		                String categoriaList = json.toJson(clist);
		                response.setContentType("text/html");
		                response.getWriter().write(categoriaList);
			            
			          
						/*
						 * List categoriasList = dao.listarCategorias();
						 * response.setContentType("text/plain");
						 * response.setCharacterEncoding("UTF-8");
						 * response.getWriter().write(String.valueOf(dao));
						 */
						/*
						 * request.setAttribute("categoriaList", rd); rd =
						 * request.getRequestDispatcher("/FormCadastraBrinquedo.jsp");
						 * rd.forward(request, response);
						 */
					}
					
				}catch (Exception e) {
					// TODO: handle exception
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
	}

}
