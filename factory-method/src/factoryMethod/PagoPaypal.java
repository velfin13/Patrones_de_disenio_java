package factoryMethod;

public class PagoPaypal implements Pago{
    @Override
    public void crearPago() {
        System.out.println("pagando con el metodo paypal");
    }
}
