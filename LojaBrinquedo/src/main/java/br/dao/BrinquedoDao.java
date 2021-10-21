package br.dao;

import java.sql.*;

import br.bean.Brinquedo;
import br.util.ConnectionFactory; 

public class BrinquedoDao {
	private Connection conn ; 
	private PreparedStatement ps; 
	private ResultSet rs ;  
	private Brinquedo brinquedo; 
	
	// metodo construtor
	
	public BrinquedoDao() throws Exception
	{
		try 
		{
			this.conn = ConnectionFactory.getConnection();
		}catch(Exception e )
		{
			throw new Exception(e.getMessage()); 
		}
	}
	// metodo salvar  
	
	public void salvar(Brinquedo brinquedo) throws Exception
	{
		
		if(brinquedo == null ) 
		{
			throw new Exception("Preencha as informações");
		}
		try 
		{
			
			String sql = "INSERT INTO tbBrinquedo(status,nome_brinquedo,preco_brinquedo,descricao_brinquedo,foto_brinquedo,id_categoria,cod_brinquedo) values(?,?,?,?,?,?,?)";
			conn = this.conn; 
			ps= conn.prepareStatement(sql); 
			ps.setBoolean(1,true);
			ps.setString(2,brinquedo.getNomeBrinquedo());
			ps.setDouble(3, brinquedo.getPreco());
			ps.setString(4, brinquedo.getDescricao());
			ps.setString(5, brinquedo.getFoto()); 
			ps.setInt(6,brinquedo.getCategoria());
			ps.setString(7, brinquedo.getCodBrinquedo());
			ps.executeUpdate(); 
			
		}catch(SQLException sql ) 
		{
			throw new Exception("erro ao cadastrar os dados" +sql );
		}finally 
		{
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	

}
