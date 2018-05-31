package challenges.interviews;

public class CreditCardProcessor {

    private CreditCard[] creditCards;

    private CreditCard VISA;
    private CreditCard Amex;
    private CreditCard Discovery;
    private CreditCard JCB;

    public CreditCardProcessor() {
        VISA = new CreditCard("VISA", new String[]{"4"}, new int[]{16});
        Amex = new CreditCard("Amex", new String[]{"34", "37"}, new int[]{15});
        Discovery = new CreditCard("Discovery", new String[]{"60", "65"}, new int[]{16});
        JCB = new CreditCard("JCB", new String[]{"35"}, new int[]{16, 17, 18, 19});

        creditCards = new CreditCard[]{ VISA, Amex, Discovery, JCB };
    }

    public String getCardType(String cardNumber) {
        for (CreditCard creditCard : creditCards) {
            if (creditCard.matches(cardNumber)) {
                return creditCard.Name();
            }
        }
        return "Unknown";
    }
}
