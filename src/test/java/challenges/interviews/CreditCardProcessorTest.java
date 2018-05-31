package challenges.interviews;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreditCardProcessorTest {

    private CreditCardProcessor processor;

    @Before
    public void SetUp() {
        processor = new CreditCardProcessor();
    }

    @Test
    public void GetCardType() {
        Assert.assertEquals("Unknown", processor.getCardType("4111"));
        Assert.assertEquals("VISA", processor.getCardType("4111111111111111"));
        Assert.assertEquals("Amex", processor.getCardType("341111111111111"));
        Assert.assertEquals("Amex", processor.getCardType("371111111111111"));
        Assert.assertEquals("Discovery", processor.getCardType("6011111111111111"));
        Assert.assertEquals("Discovery", processor.getCardType("6511111111111111"));
        Assert.assertEquals("JCB", processor.getCardType("3511111111111111"));
        Assert.assertEquals("JCB", processor.getCardType("35111111111111111"));
        Assert.assertEquals("JCB", processor.getCardType("351111111111111111"));
        Assert.assertEquals("JCB", processor.getCardType("3511111111111111111"));
    }

}
