package controllerHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Equipamento;
import model.Ocorrencia;
import view.EnviarView;

public class EnviarHelper {
	private final EnviarView view;

	public EnviarHelper(EnviarView view) {
		this.view = view;
	}
	public Equipamento lerEquipamento() {
		 String serial = view.getTextSerial().getText().toLowerCase();
		 String patrimonio = view.getTextPatrimonio().getText().toLowerCase();
		 String empresa = view.getComboBoxEmpresa().getSelectedItem().toString().toLowerCase();
		 String modelo = view.getTextModelo().getText().toLowerCase();
		 String tipo = view.getTextTipo().getText().toLowerCase();
		 String responsavel = view.getTextResponsavel().getText().toLowerCase();
		 try {
			 int idade = Integer.parseInt(view.getTextIdade().getText());
			 Equipamento equipamento = new Equipamento(serial,patrimonio,idade,modelo,tipo,responsavel,empresa);
			 view.exibeMensagem("cadastro equipamento com sucesso");
			 return equipamento;
			 }catch(NumberFormatException a){
				 view.exibeMensagem("Idade em formato incorreto");
			 }
		 return null;

			
	 }
	public Ocorrencia lerOcorrencia(Equipamento equipamento) {
		String prestador = view.getTextPrestador().getText().toLowerCase();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String problema = view.getTextProblema().getText().toLowerCase();
		boolean fonte = view.getChckbxNewCheckBox().isSelected();
		String nf = view.getTextNF().getText().toLowerCase();
		String os = view.getTextOS().getText().toLowerCase();
		try {	
			double valor =Double.parseDouble(view.getTextValor().getText());
			Date data = formatter.parse(view.getTextData().getText()); 
			Ocorrencia ocorrencia = new Ocorrencia(prestador, data, equipamento, problema, fonte );
			ocorrencia.setValor(valor);
			ocorrencia.setnF(nf);
			ocorrencia.setoS(os);
			view.exibeMensagem("cadastro ocorrência com sucesso");
			return ocorrencia;
		}catch(ParseException e) {
			view.exibeMensagem("Data em formato incorreto");
		}catch(NumberFormatException a) {
			view.exibeMensagem("Valor em formato incorreto");
		}
		return null;
	}
}
