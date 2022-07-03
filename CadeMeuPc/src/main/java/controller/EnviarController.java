package controller;



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
		e = conexao.lerEnviarEquipamento(e);
		if(e == null){
			view.exibeMensagem("equipamento já em manutenção");
			return ;
		}
		Ocorrencia o = helper.lerOcorrencia(e);
		conexao.lerEnviarOcorrencia(o);
	 }
	
}
