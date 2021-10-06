package br.edu.unicid.web;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.edu.unicid.bean.Alunos;
import br.edu.unicid.dao.AlunosDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletAluno")
public class ServletAluno extends HttpServlet {

	// método de conversão de String para Data
	private Date strToDate(String data) throws Exception {
		if (data == null) {
			return null;
		}

		Date dataF = null;

		try {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			long timestamp = dateFormat.parse(data).getTime();
			dataF = new Date(timestamp);

			return dataF;

		} catch (ParseException pe) {
			throw pe;
		}
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// variável cmd indica o tipo de ação - ()
		String cmd = request.getParameter("cmd");

		// criar um objeto dao - CRUD
		AlunosDao dao;

		// criar um objeto do tipo aluno
		Alunos aluno = new Alunos();

		if (cmd != null) {
			try {
				aluno.setCaAluno(Integer.parseInt(request.getParameter("txtCa")));
				aluno.setNomeAluno(request.getParameter("txtNome"));
				aluno.setEmailAluno(request.getParameter("txtEmail"));
				aluno.setDtaNasc(strToDate(request.getParameter("txtData")));
				aluno.setEndAluno(request.getParameter("txtEndereco"));
				aluno.setIdadeAluno(Integer.parseInt(request.getParameter("txtIdade")));

			} catch (Exception erro) {
				erro.printStackTrace();
			}
		}
		
		try {			
			dao = new AlunosDao();
			RequestDispatcher rd = null;
			
			//incluir aluno
			if(cmd.equalsIgnoreCase("incluir")) {
				dao.salvar(aluno);
				rd = request.getRequestDispatcher("ServletAluno?cmd=listar");
				rd.forward(request, response);
			}
			
			//atualizar aluno
			else if(cmd.equalsIgnoreCase("atualizar")) {
				dao.atualizar(aluno);
				rd = request.getRequestDispatcher("ServletAluno?cmd=listar");
				rd.forward(request, response);
			}
			
			//excluir aluno
			else if(cmd.equalsIgnoreCase("excluir")) {
				dao.excluir(aluno);
				rd = request.getRequestDispatcher("ServletAluno?cmd=listar");	
				rd.forward(request, response);
			}
			
			//listar todos os alunos
			else if(cmd.equalsIgnoreCase("listar")) {
				List alunosList = dao.listartodosAlunos();
				request.setAttribute("alunosList", alunosList);
				rd = request.getRequestDispatcher("/mostrarAlunoCads.jsp");
				rd.forward(request, response);
				
			}
			
			//consultar aluno
			else if(cmd.equalsIgnoreCase("con")) {
				aluno = dao.procurarAluno(aluno.getCaAluno());
				HttpSession session = request.getSession(true);
				session.setAttribute("aluno", aluno);
				rd = request.getRequestDispatcher("/formConAluno.jsp");	
				rd.forward(request, response);
			}
			// consulta atualiza aluno
			else if(cmd.equalsIgnoreCase("conAtualiza")) {
				aluno = dao.procurarAluno(aluno.getCaAluno());
				HttpSession session = request.getSession(true);
				session.setAttribute("aluno", aluno);
				rd = request.getRequestDispatcher("/formAtualizaAluno.jsp");	
				rd.forward(request, response);
			}
			
			
			//pagina inicial
			else if(cmd.equalsIgnoreCase("principal")) {
				rd = request.getRequestDispatcher("/index.jsp");				
			}
			
		}catch(Exception erro) {
			erro.printStackTrace();
			throw new ServletException(erro);
		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
	}	

}
