package com.example.my.capital.finder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class AppTest {

    @Test
    public void testFetchCapitalCity_ValidCountry() throws Exception {
        String capital = Main.fetchCapitalCity("France");
        assertEquals("Paris", capital);
    }

    @Test
    public void testFetchCapitalCity_InvalidCountry() throws Exception {
        String capital = Main.fetchCapitalCity("dsgtdfsgdfghdf");
        assertNull(capital);
    }
}
