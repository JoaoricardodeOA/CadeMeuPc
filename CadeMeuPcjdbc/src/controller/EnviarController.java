package controller;



import java.sql.SQLException;

import controllerHelper.EnviarHelper;
import dao.Conexao;
import model.Equipamento;
import model.Ocorrencia;
import view.EnviarView;

public class EnviarController {
	private final EnviarView view;
	private EnviarHelper helper;
	private Conexao conexao;

	public EnviarController(EnviarView view) {
		this.view = view;
		this.helper = new EnviarHelper(view);
	}
	 public void lerDados() {
		Equipamento e =  helper.lerEquipamento();
		conexao = new Conexao();
		try {
		e = conexao.lerEnviarEquipamentojdbc(e);
		if(e == null){
			view.exibeMensagem("equipamento já em manutenção ou dados incorretos");
			return ;
		}
		Ocorrencia o = helper.lerOcorrencia(e);
		view.exibeMensagem("Dados enviados");
		conexao.lerEnviarOcorrenciajdbc(o);
		}catch(SQLException o) {
			view.exibeMensagem("Erro sql");
		}
	 }
	
}
