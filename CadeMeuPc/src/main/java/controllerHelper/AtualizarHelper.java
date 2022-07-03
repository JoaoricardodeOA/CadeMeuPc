package controllerHelper;

import model.Ocorrencia;
import view.AtualizarView;


public class AtualizarHelper {
  private AtualizarView view;
  public AtualizarHelper(AtualizarView view) {
	  this.view = view;
  }
  public Ocorrencia lerDados() {
	  Long id = Long.parseLong(view.getTextId().getText());
	  String nf = view.getTextNf().getText();
	  String os = view.getTextOs().getText();
	  double valor = Double.parseDouble(view.getTextValor().getText());
	  Ocorrencia o = new Ocorrencia();
	  o.setId(id);
	  o.setnF(nf);
	  o.setoS(os);
	  o.setValor(valor);
	  return o;
  }
}
