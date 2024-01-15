package factoryMethod;

public class PagoEfectivo implements Pago{
    @Override
    public void crearPago() {
        System.out.println("Pago en efectivo");
    }
}
