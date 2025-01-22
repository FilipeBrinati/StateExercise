package state;

public abstract class PedidoState {
	public boolean avancar(PedidoContext context) {
        return false;
	}
    public boolean cancelar(PedidoContext context) {
        context.setEstado(new Cancelado());
        return true;
    }
    public abstract String getEstado();
}
