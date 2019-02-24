package oop.Catalan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created on: 22/Apr/2017
 *
 * @author Dobromir
 */
public class TestCatalan
{
    @Test
    public void testCatalanOne()
    {
        assertEquals(CatalanNumber.catalan(1), Long.parseLong("1"));
    }

    @Test
    public void testCatalanTwo()
    {
        assertEquals(CatalanNumber.catalan(2), Long.parseLong("2"));
    }

    @Test
    public void testCatalanThree()
    {
        assertEquals(CatalanNumber.catalan(3), Long.parseLong("5"));
    }

    @Test
    public void testCatalanThirty()
    {
        assertEquals(CatalanNumber.catalan(30), Long.parseLong("3814986502092304"));
    }

    @Test
    public void testCatalanTwentyNine()
    {
        assertEquals(CatalanNumber.catalan(29), Long.parseLong("1002242216651368"));
    }

    @Test
    public void testCatalanTwentyEight()
    {
        assertEquals(CatalanNumber.catalan(28), Long.parseLong("263747951750360"));
    }

}
