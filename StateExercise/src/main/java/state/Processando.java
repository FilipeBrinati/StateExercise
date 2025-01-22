package state;

public class Processando extends PedidoState {

    public boolean avancar(PedidoContext context) {
        context.setEstado(new Enviado());
		return true;
    }

    public String getEstado() {
        return "Processando";
    }
}

