package challenges.interviews;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreditCardTest {

    private CreditCardProcessor helper;

    @Before
    public void SetUp() {
        helper = new CreditCardProcessor();
    }

    @Test
    public void GetCardType() {
        Assert.assertEquals("Unknown", helper.getCardType("4111"));
        Assert.assertEquals("VISA", helper.getCardType("4111111111111111"));
        Assert.assertEquals("Amex", helper.getCardType("341111111111111"));
        Assert.assertEquals("Amex", helper.getCardType("371111111111111"));
        Assert.assertEquals("Discovery", helper.getCardType("6011111111111111"));
        Assert.assertEquals("Discovery", helper.getCardType("6511111111111111"));
        Assert.assertEquals("JCB", helper.getCardType("3511111111111111"));
        Assert.assertEquals("JCB", helper.getCardType("35111111111111111"));
        Assert.assertEquals("JCB", helper.getCardType("351111111111111111"));
        Assert.assertEquals("JCB", helper.getCardType("3511111111111111111"));
    }

}
