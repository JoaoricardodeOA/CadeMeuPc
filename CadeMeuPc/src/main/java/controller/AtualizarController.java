package controller;

import controllerHelper.AtualizarHelper;
import dao.Conexao;
import model.Ocorrencia;
import view.AtualizarView;

public class AtualizarController {
	private AtualizarView view;
	private AtualizarHelper helper;
	public AtualizarController(AtualizarView view) {
		this.view = view;
		this.helper = new AtualizarHelper(view);
	}
	public void lerDados() {
		Ocorrencia o = helper.lerDados();
		Conexao conexao = new Conexao();
		conexao.lerAtualizar(o);
	}
	
}
