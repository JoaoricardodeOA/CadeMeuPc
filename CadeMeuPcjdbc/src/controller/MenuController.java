package controller;

import view.AtualizarView;
import view.Consulta;
import view.EnviarView;
import view.MenuView;
import view.ReceberView;

public class MenuController {
	private final MenuView view;
	private Consulta consulta;
	private AtualizarView atualizar;
	private ReceberView receber;
	private EnviarView enviar;
	public MenuController(MenuView view) {
		this.view = view;
	}
	public void abrirConsulta() {
		consulta = new Consulta();
		consulta.setVisible(true);
	}
	public void abrirAtualizar() {
		atualizar = new AtualizarView();
		atualizar.setVisible(true);
	}
	public void abrirEnviar() {
		enviar = new EnviarView();
		enviar.setVisible(true);
	}
	public void abrirReceber() {
		receber = new ReceberView();
		receber.setVisible(true);
	}
}
