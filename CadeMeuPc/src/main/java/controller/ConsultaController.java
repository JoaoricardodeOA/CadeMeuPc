package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.Conexao;
import model.Equipamento;
import model.Ocorrencia;
import view.Consulta;

public class ConsultaController {
	private Consulta view;
	public ConsultaController(Consulta view) {
		this.view = view;
	}
	public void lerDadosEquipamentos() {
		Conexao conexao = new Conexao();
		List<Equipamento> e = conexao.queryTodos();
		atualizaTabelaEquipamento(e);
	}
	private void atualizaTabelaEquipamento(List<Equipamento> e) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTable().getModel();
		tableModel.setNumRows(0);
		for (Equipamento equipamento : e) {
			tableModel.addRow(new Object[] {
					null,
					equipamento.getSerialNumber(),
					equipamento.getPatrimonio(),
					equipamento.getIdade(),
					equipamento.getModelo(),
					equipamento.getTipo(),
					equipamento.getReponsavel(),
					equipamento.getEmpresa(),
					equipamento.isManutencao(),
					equipamento.getVezesQuebrado(),
					null,
					null,
					null,
					null,
					null,
					null,
					null,
			});
		}
	}
	public void lerData() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date data = formatter.parse( view.getTextField().getText());
			Date data1 = formatter.parse(view.getTextField_1().getText());
			Conexao conexao = new Conexao();
			List<Ocorrencia> o = conexao.queryData(data, data1);
			atualizaTabelaOcorrencia(o);
		} catch (ParseException e) {
			view.exibeMensagem("Data no formato errado");
		}
	}
	public void lerAtividade() {
		Conexao conexao = new Conexao();
		List<Ocorrencia> o = conexao.queryAtividade();
		atualizaTabelaOcorrencia(o);
	}
	private void atualizaTabelaOcorrencia(List<Ocorrencia> o) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTable().getModel();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		tableModel.setNumRows(0);
		for (Ocorrencia ocorrencia : o) {
			tableModel.addRow(new Object[] {
					ocorrencia.getId(),
					ocorrencia.getEquipamento().getSerialNumber(),
					ocorrencia.getEquipamento().getPatrimonio(),
					ocorrencia.getEquipamento().getIdade(),
					ocorrencia.getEquipamento().getModelo(),
					ocorrencia.getEquipamento().getTipo(),
					ocorrencia.getEquipamento().getReponsavel(),
					ocorrencia.getEquipamento().getEmpresa(),
					ocorrencia.isSituacao(),
					ocorrencia.getEquipamento().getVezesQuebrado(),
					ocorrencia.getPrestador(),
					dateFormat.format(ocorrencia.getMes()),
					ocorrencia.getValor(),
					ocorrencia.getnF(),
					ocorrencia.getoS(),
					ocorrencia.getFonte(),
					ocorrencia.getProblema(),
			});
		}
	}
}
