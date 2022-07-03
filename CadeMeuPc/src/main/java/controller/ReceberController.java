package controller;

import dao.Conexao;
import view.ReceberView;

public class ReceberController {
	private ReceberView view; 
	public ReceberController(ReceberView view){
		this.view = view;
	}
	public void lerDados() {
		Long id = Long.parseLong(view.getTextField().getText());
		Conexao conexao= new Conexao();
		conexao.lerReceber(id);
	}
}
