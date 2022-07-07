package controller;

import java.sql.SQLException;

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
		if(o==null) {
			return ;
		}
		Conexao conexao = new Conexao();
		try {
			int rows = conexao.lerAtualizarjdbc(o);
			if(rows == 1) {
				view.exibeMensagem("Dados enviados");
			}else {
				view.exibeMensagem("Id não encontrado");
			}
		} catch (SQLException e) {
			view.exibeMensagem("erro sql");
		}
	}
	
}
