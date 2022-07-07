package controller;

import javax.swing.JOptionPane;

import dao.Conexao;
import view.Login;
import view.MenuView;

public class LoginController {
	private final Login view;
	
	public LoginController (Login view) {
		this.view = view;
	}
	
	public void verificarUsuario() {
		MenuView tela = new MenuView();
		String login = view.getLoginField().getText();
		String senha = view.getSenhaField().getText();
		Conexao conexao = new Conexao();
		if(login.equals("root") &&senha.equals("12345")) {
			tela.setVisible(true);	
			view.setVisible(false);
		}else {
			view.exibeMensagem("Usuario ou senha invalido(s)");
		}
	}
}
