package factoryMethod;

import java.util.HashMap;

public class PagoFactory {

    public Pago obtenerPago(TipoPago tipoPago) throws NoSuchFieldException {
        switch (tipoPago) {
            case EFECTIVO:
                return new PagoEfectivo();
            case PAYPAL:
                return new PagoPaypal();
            case BANCO_PACIFICO:
                return new PagoPacifico();
            case BANCO_PICHINCHA:
                return new PagoPichincha();
            default:
                throw new NoSuchFieldException("Tipo de pago no existe");
        }
    }
}
