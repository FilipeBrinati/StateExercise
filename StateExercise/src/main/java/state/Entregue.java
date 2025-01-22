package state;

public class Entregue extends PedidoState {

    @Override
    public boolean cancelar(PedidoContext context) {
    	return false;
    }

    @Override
    public String getEstado() {
        return "Entregue";
    }
}
