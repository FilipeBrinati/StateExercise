package state;

public class Cancelado extends PedidoState {

    @Override
    public boolean cancelar(PedidoContext context) {
    	return false;
    }

    @Override
    public String getEstado() {
        return "Cancelado";
    }
}

