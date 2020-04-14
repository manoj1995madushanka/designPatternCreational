package abstractFactory.creditCardSelector;

public class AmexGoldValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard){
        return false;
    }
}
