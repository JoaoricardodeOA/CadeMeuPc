package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import javax.swing.JOptionPane;

import model.Equipamento;
import model.Ocorrencia;

public class Conexao {
	private String user;
	private String password;
	public Conexao() {

	}
	
	public Connection getConnection(String user, String password) {
		String urlConnection = "jdbc:mysql://localhost/gerenciamento";
		this.user = user;
		this.password = password;
		try {	
			Connection con = DriverManager.getConnection(urlConnection, "root", "12345");
			return con;
		}catch(SQLException e) {
			return null;
		}
	}
	public Equipamento lerEnviarEquipamentojdbc(Equipamento e) throws SQLException{
		Connection con = this.getConnection(user, password);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		if(con == null) {
			return null;
		}
		PreparedStatement prst = con.prepareStatement("select * from equipamento where serialNumber ='"+e.getSerialNumber()+"'");
		ResultSet rs = prst.executeQuery();
		if(rs.next()) {
			if(rs.getBoolean("manutencao")) {
				return null;
			}else {
				e.setEmpresa(rs.getString("empresa"));
				e.setIdade(rs.getDate("idade"));
				e.setManutencao(rs.getBoolean("manutencao"));
				e.setModelo(rs.getString("modelo"));
				e.setPatrimonio(rs.getString("patrimonio"));
				e.setReponsavel(rs.getString("reponsavel"));
				e.setTipo(rs.getString("tipo"));
				e.setVezesQuebrado(rs.getInt("vezesQuebrado")+1);
				e.setId(rs.getLong("id"));
				prst = con.prepareStatement("update equipamento set vezesQuebrado ="+e.getVezesQuebrado()+", empresa='"+rs.getString("empresa")+"', reponsavel='"+rs.getString("reponsavel")+"', manutencao =true where serialNumber ='"+e.getSerialNumber()+"'");
				prst.executeUpdate();
			}
		}else {
			prst.close();
			prst = con.prepareStatement("insert into equipamento(vezesQuebrado, serialNumber, patrimonio, idade, modelo, tipo, reponsavel, empresa, manutencao) values ("+e.getVezesQuebrado()+", '"+e.getSerialNumber()+"','"+e.getPatrimonio()+"', '"+formatter.format(e.getIdade())+"', '"+e.getModelo()+"', '"+e.getTipo()+"', '"+e.getReponsavel()+"', '"+e.getEmpresa()+"', "+e.isManutencao()+")");
			prst.executeUpdate();
			prst = con.prepareStatement("select id from equipamento where serialNumber ='"+e.getSerialNumber()+"'");
			rs = prst.executeQuery();
			rs.next();
			e.setId(rs.getLong("id"));
		}
		prst.close();
		return e;
	}

	
	public void lerEnviarOcorrenciajdbc(Ocorrencia o) throws SQLException{
		Connection con = this.getConnection(user, password);
		if(con == null) {
			return ;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		
		PreparedStatement prst = con.prepareStatement("insert into ocorrencia(fonte, mes, nF, oS, prestador, problema, situacao, valor, equipamento_id) values ("+o.getFonte()+", '"+ formatter.format(o.getMes())+"','"+o.getnF()+"', '"+o.getoS()+"', '"+o.getPrestador()+"', '"+o.getProblema()+"', "+o.isSituacao()+", "+o.getValor()+", "+o.getEquipamento().getId()+")");
		prst.executeUpdate();
		prst.close();
	}

	
	public int lerAtualizarjdbc(Ocorrencia o) throws SQLException{
		Connection con = this.getConnection(user, password);
		if(con == null) {	
			return 0;
		}
		PreparedStatement prst = con.prepareStatement("update ocorrencia set nF ='"+o.getnF()+"', oS='"+o.getoS()+"', valor="+o.getValor()+" where id ="+o.getId());
		int rows = prst.executeUpdate();
		prst.close();
		return rows; 
	}
	

	
	public int lerReceberjdbc(Long id) throws SQLException{
		Connection con = this.getConnection(user, password);
		if(con == null) {
			return 0;
		}
		PreparedStatement prst = con.prepareStatement("update ocorrencia set situacao=false where id="+id);
		int rows = prst.executeUpdate();
		prst.close();
		prst = con.prepareStatement("select equipamento_id from ocorrencia where id="+id);
		ResultSet rs = prst.executeQuery();
		if(rows==1) {
			rs.next();
			prst = con.prepareStatement("update equipamento set manutencao=false where id="+rs.getLong("equipamento_id"));
			rows = prst.executeUpdate();
		}else {
			return 0;
		}
		prst.close();
		return rows;
	}
	
	public List<Equipamento> queryEnviadojdbc() throws SQLException {
		Connection con = this.getConnection(user, password);
		if(con == null) {
			return null;
		}
		List<Equipamento> list =new ArrayList<>();
		Equipamento e;
		PreparedStatement prst = con.prepareStatement("select * from equipamento where manutencao=true");
		ResultSet rs = prst.executeQuery();
		while(rs.next()) {
			e = new Equipamento();
			e.setEmpresa(rs.getString("empresa"));
			e.setIdade(rs.getDate("idade"));
			e.setManutencao(rs.getBoolean("manutencao"));
			e.setModelo(rs.getString("modelo"));
			e.setPatrimonio(rs.getString("patrimonio"));
			e.setReponsavel(rs.getString("reponsavel"));
			e.setSerialNumber(rs.getString("serialNumber"));
			e.setTipo(rs.getString("tipo"));
			e.setVezesQuebrado(rs.getInt("vezesQuebrado"));
			list.add(e);
		}
		rs.close();
		prst.close();
		con.close();
		return list;
	}

	public List<Equipamento> queryTodosjdbc() throws SQLException{
		Connection con = this.getConnection(user, password);
		if(con == null) {
			return null;
		}
		List<Equipamento> list =new ArrayList<>();
		Equipamento e;
		PreparedStatement prst = con.prepareStatement("select * from equipamento");
		ResultSet rs = prst.executeQuery();
		while(rs.next()) {
			e = new Equipamento();
			e.setId(rs.getLong("id"));
			e.setEmpresa(rs.getString("empresa"));
			e.setIdade(rs.getDate("idade"));
			e.setManutencao(rs.getBoolean("manutencao"));
			e.setModelo(rs.getString("modelo"));
			e.setPatrimonio(rs.getString("patrimonio"));
			e.setReponsavel(rs.getString("reponsavel"));
			e.setSerialNumber(rs.getString("serialNumber"));
			e.setTipo(rs.getString("tipo"));
			e.setVezesQuebrado(rs.getInt("vezesQuebrado"));
			list.add(e);
		}
		rs.close();
		prst.close();
		return list;
	}
	
	public List<Ocorrencia> queryDatajdbc(Date data, Date data1) throws SQLException{
		Connection con = this.getConnection(user, password);
		if(con == null) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String inicio = formatter.format(data);
		String fim = formatter.format(data1);
		List<Ocorrencia> list =new ArrayList<>();
		Equipamento e;
		Ocorrencia o;
		PreparedStatement prst = con.prepareStatement("SELECT a.*,b.vezesQuebrado, b.serialNumber, b.patrimonio, b.idade, b.modelo, b.tipo, b.reponsavel, b.empresa, b.manutencao FROM ocorrencia as A left JOIN equipamento as b on a.equipamento_id = b.id where a.mes>='"+inicio+"' and a.mes<='"+fim+"'");
		ResultSet rs = prst.executeQuery();
		while(rs.next()) {
			e = new Equipamento();
			e.setId(rs.getLong("id"));
			e.setEmpresa(rs.getString("empresa"));
			e.setIdade(rs.getDate("idade"));
			e.setManutencao(rs.getBoolean("manutencao"));
			e.setModelo(rs.getString("modelo"));
			e.setPatrimonio(rs.getString("patrimonio"));
			e.setReponsavel(rs.getString("reponsavel"));
			e.setSerialNumber(rs.getString("serialNumber"));
			e.setTipo(rs.getString("tipo"));
			e.setVezesQuebrado(rs.getInt("vezesQuebrado"));
			o = new Ocorrencia();
			o.setId(rs.getLong("id"));
			o.setMes(rs.getDate("mes"));
			o.setFonte(rs.getBoolean("fonte"));
			o.setnF(rs.getString("nF"));
			o.setoS(rs.getString("oS"));
			o.setPrestador(rs.getString("prestador"));
			o.setProblema(rs.getString("problema"));
			o.setSituacao(rs.getBoolean("situacao"));
			o.setValor(rs.getDouble("valor"));
			o.setEquipamento(e);
			list.add(o);		
		}
		rs.close();
		prst.close();
		return list;
	}

	public List<Ocorrencia> queryAtividadejdbc() throws SQLException{
		Connection con = this.getConnection(user, password);
		if(con == null) {
			return null;
		}
		List<Ocorrencia> list =new ArrayList<>();
		Equipamento e;
		Ocorrencia o;
		PreparedStatement prst = con.prepareStatement("SELECT a.*,b.vezesQuebrado, b.serialNumber, b.patrimonio, b.idade, b.modelo, b.tipo, b.reponsavel, b.empresa, b.manutencao FROM ocorrencia as A left JOIN equipamento as b on a.equipamento_id = b.id where a.situacao=true");
		ResultSet rs = prst.executeQuery();
		while(rs.next()) {
			e = new Equipamento();
			e.setId(rs.getLong("id"));
			e.setEmpresa(rs.getString("empresa"));
			e.setIdade(rs.getDate("idade"));
			e.setManutencao(rs.getBoolean("manutencao"));
			e.setModelo(rs.getString("modelo"));
			e.setPatrimonio(rs.getString("patrimonio"));
			e.setReponsavel(rs.getString("reponsavel"));
			e.setSerialNumber(rs.getString("serialNumber"));
			e.setTipo(rs.getString("tipo"));
			e.setVezesQuebrado(rs.getInt("vezesQuebrado"));
			o = new Ocorrencia();
			o.setId(rs.getLong("id"));
			o.setMes(rs.getDate("mes"));
			o.setFonte(rs.getBoolean("fonte"));
			o.setnF(rs.getString("nF"));
			o.setoS(rs.getString("oS"));
			o.setPrestador(rs.getString("prestador"));
			o.setProblema(rs.getString("problema"));
			o.setSituacao(rs.getBoolean("situacao"));
			o.setValor(rs.getDouble("valor"));
			o.setEquipamento(e);
			list.add(o);		
		}
		rs.close();
		prst.close();
		return list;
	}

}
