package controller;

import java.sql.SQLException;

import dao.Conexao;
import view.ReceberView;

public class ReceberController {
	private ReceberView view; 
	public ReceberController(ReceberView view){
		this.view = view;
	}
	public void lerDados() {
		try {
			Long id = Long.parseLong(view.getTextField().getText());	
			Conexao conexao= new Conexao();
			int rows = conexao.lerReceberjdbc(id);
			if(rows == 1) {
				view.exibeMensagem("Dados enviados");
			}else {
				view.exibeMensagem("Id não encontrado");
			}
		} catch (SQLException e) {
			view.exibeMensagem("erro sql");
		} catch (NumberFormatException e) {
			view.exibeMensagem("id não preenchido");
		}
 	}
}
