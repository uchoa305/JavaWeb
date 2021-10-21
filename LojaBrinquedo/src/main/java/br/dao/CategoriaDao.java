package br.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.bean.Categoria;
import br.util.ConnectionFactory;

public class CategoriaDao 
{
	private Connection conn ; 
	private PreparedStatement ps; 
	private ResultSet rs ;  
	Categoria categoria ; 
	
	
	public CategoriaDao() throws Exception
	{
		try
		{
			this.conn = ConnectionFactory.getConnection();
		}catch (Exception e) 
		{
			throw new Exception(e.getMessage());
		}
	}
	
	//metodo listar todas as categorias
	public List listarCategorias() throws Exception
	{
		String sql = "SELECT * FROM tbCategoria"; 
		conn = this.conn; 
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		
		List<Categoria> lista = new ArrayList<Categoria>();
		
		while(rs.next()) 
		{
			categoria = new Categoria();
			categoria.setId(rs.getInt(1));
			categoria.setStatus(rs.getBoolean(2));
			categoria.setCategoria(rs.getString(3));
			categoria.setDescricao(rs.getString(4));
			lista.add(categoria);
		}
		return lista;
	}

}
