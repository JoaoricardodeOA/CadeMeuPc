package controllerHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;

import exceptions.CamposInvalidosException;
import model.Equipamento;
import model.Ocorrencia;
import view.EnviarView;

public class EnviarHelper {
	private final EnviarView view;

	public EnviarHelper(EnviarView view) {
		this.view = view;
	}
	public Equipamento lerEquipamento() {
		 try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String serial = view.getTextSerial().getText().toLowerCase();
		 	String patrimonio = view.getTextPatrimonio().getText().toLowerCase();
		 	String empresa = view.getTextField().getText().toLowerCase();
		 	String modelo = view.getTextModelo().getText().toLowerCase();
		 	String tipo = view.getTextTipo().getText().toLowerCase();
		 	String responsavel = view.getTextResponsavel().getText().toLowerCase();
			Date idade = formatter.parse(view.getTextData().getText());
			 if(serial == null||patrimonio== null||modelo==null||tipo==null||responsavel==null||empresa==null) {
				 view.exibeMensagem("campos = serial, patrimonio, idade, modelo, tipo, responsavel e empresa precisam ser preenchidos");
				 return null;
			 }
			 Equipamento equipamento = new Equipamento(serial,patrimonio,idade,modelo,tipo,responsavel,empresa);
			 view.exibeMensagem("cadastro equipamento com sucesso");
			 return equipamento;
			 } catch (ParseException e) {
				// TODO Auto-generated catch block
				 view.exibeMensagem("Idade em formato incorreto");
			}
		 return null;

			
	 }
	public Ocorrencia lerOcorrencia(Equipamento equipamento) {
		 try {
			String prestador = view.getTextPrestador().getText().toLowerCase();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String problema = view.getTextProblema().getText().toLowerCase();
			boolean fonte = view.getChckbxNewCheckBox().isSelected();
			String nf = view.getTextNF().getText().toLowerCase();
			String os = view.getTextOS().getText().toLowerCase();	
			double valor =Double.parseDouble(view.getTextValor().getText().replace(",", "."));
			Date data = formatter.parse(view.getTextData().getText()); 
			Ocorrencia ocorrencia = new Ocorrencia(prestador, data, equipamento, problema, fonte );
			ocorrencia.setValor(valor);
			ocorrencia.setnF(nf);
			ocorrencia.setoS(os);
			if(prestador == null||problema== null) {
				 view.exibeMensagem("campos = prestador, problema, data e valor precisam ser preenchidos");
				 return null;
			 }
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
