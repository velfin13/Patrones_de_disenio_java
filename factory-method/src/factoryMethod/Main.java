package factoryMethod;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        PagoFactory pagoFactory =  new PagoFactory();
        Pago pago =pagoFactory.obtenerPago(TipoPago.BANCO_PICHINCHA);
        pago.crearPago();
    }
}
