package abstractFactory.creditCardSelector;

public class AmexPlatinumValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard){
        return false;
    }
}
