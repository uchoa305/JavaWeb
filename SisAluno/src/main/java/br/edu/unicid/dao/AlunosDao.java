package br.edu.unicid.dao;

import java.sql.*; 
import java.util.List;
import java.util.ArrayList;
import br.edu.unicid.bean.Alunos;
import br.edu.unicid.util.ConnectionFactory;

public class AlunosDao
{
	private Connection conn; 
	private PreparedStatement ps; 
	private ResultSet rs ; 
	private  Alunos aluno; 
	
	//conexao banco
	public AlunosDao() throws Exception{}
	{
		try 
		{
			this.conn = ConnectionFactory.getConnection();
			
		}catch(Exception e) 
		{
			throw new Exception(e.getMessage());
		}
	}
	// metodo salvar
	public void salvar(Alunos alunos)  throws Exception
	{
		{
		
			if(alunos == null) 
			{
				throw new Exception("Preencha as informações " );
			}
			try 
			{
				String sql = "INSERT INTO tbaluno (caALuno, nomeAluno, emailAluno,dtaNasc,endAluno,idadeAluno) values(?,?,?,?,?,?)"; 
				conn  = this.conn;
				ps = conn.prepareStatement(sql);
				ps.setInt(1,alunos.getCaAluno());
				ps.setString(2,alunos.getNomeAluno());
				ps.setString(3,alunos.getEmailAluno());
				ps.setDate(4,new java.sql.Date(alunos.getDtaNasc().getTime()));
				ps.setString(5,alunos.getEndAluno());
				ps.setInt(6,alunos.getIdadeAluno());
				ps.executeUpdate(); 
				
			}catch (SQLException sql)
			{
				throw new Exception("Erro ao inserir os dados" + sql);
			}finally 
			{
				ConnectionFactory.closeConnection(conn, ps,rs);
			}
		} 
	}
	// metodo atualizar 
	public void atualizar(Alunos alunos)  throws Exception
	{
		{
			if(alunos == null) 
			{
				throw new Exception("Preencha as informações " );
			}
			try 
			{
				String sql = "UPDATE tbAluno set   nomeAluno=?, emailAluno=?,dtaNasc=?,endAluno=?,idadeAluno=? Where caAluno = ? "; 
				conn  = this.conn;
				ps = conn.prepareStatement(sql);
				ps.setString(1,alunos.getNomeAluno());
				ps.setString(2,alunos.getEmailAluno());
				ps.setDate(3,new java.sql.Date(alunos.getDtaNasc().getTime()));
				ps.setString(4,alunos.getEndAluno());
				ps.setInt(5,alunos.getIdadeAluno());
				ps.setInt(6,alunos.getCaAluno()); // passa o parametro do where
				ps.executeUpdate(); 
				
			}catch (SQLException sql)
			{
				throw new Exception("Erro ao inserir os dados" + sql);
			}finally 
			{
				ConnectionFactory.closeConnection(conn, ps,rs);
			}
		} 
	}
	// metodo de exclusao 
	public void excluir(Alunos alunos)  throws Exception
	{
		{
			if(alunos == null) 
			{
				throw new Exception("Preencha as informações " );
			}
			try 
			{
				String sql = " DELETE FROM tbAluno WHERE caAluno = ? "; 
				conn  = this.conn;
				ps = conn.prepareStatement(sql);
				ps.setInt(1,alunos.getCaAluno());
				ps.executeUpdate(); 
				
			}catch (SQLException sql)
			{
				throw new Exception("Erro ao inserir os dados" + sql);
			}finally 
			{
				ConnectionFactory.closeConnection(conn, ps,rs);
			}
		} 
	}
	
	// metodo buscar Aluno
	public Alunos procurarAluno(int ca_aluno)  throws Exception
	{
		{
			if(ca_aluno == 0) 
			{
				throw new Exception("Preencha as informações");
			}
			try 
			{
				String sql = "SELECT * FROM tbAluno Where caAluno=? ";
				conn = this.conn; 
				ps = conn.prepareStatement(sql);
				ps.setInt(1, ca_aluno);
				rs = ps.executeQuery(); 
				
				if(rs.next()) 
				{
					int ca = rs.getInt(1);
					String nome = rs.getString(2);
					String email = rs.getString(3);
					Date data = rs.getDate(4);
					String end = rs.getString(5);
					int idade = rs.getInt(6);
					
					aluno = new Alunos(ca,nome,email,data,idade,end);
				}
				return aluno;
			}
			catch(SQLException sql) 
			{
				throw new Exception("Erro ao buscar os dados" + sql);
			}
			finally 
			{
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
			
		}
	} 
	// metodo de listar todos alunos
	public List listartodosAlunos() throws Exception
	{
		{
			String sql = "SELECT * FROM tbAluno"; 
			conn = this.conn; 
			ps = conn.prepareStatement(sql); 
			rs = ps.executeQuery(); 
			
			List<Alunos> list = new ArrayList<Alunos>()  ;
			
			while(rs.next()) 
			{
				
				int ca = rs.getInt(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				Date data = rs.getDate(4);
				String end = rs.getString(5);
				int idade = rs.getInt(6);
				
				list.add(new Alunos(ca,nome,email,data,idade,end));
				
			}
			
			return list;
		}
		
	}
}

/*
 * Alunos novoAluno = new Alunos() ;
 * 
 * novoAluno.setCaAluno(rs.getInt(1)); novoAluno.setNomeAluno(rs.getString(2));
 * novoAluno.setEmailAluno(rs.getString(3));
 * novoAluno.setDtaNasc(rs.getDate(4)); novoAluno.setEndAluno(rs.getString(5));
 * novoAluno.setIdadeAluno(rs.getInt(6)); list.add(novoAluno);
 */
