package com.geekcap.vmturbo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * Created by shaines on 7/24/16.
 */
class ThingTest {

    @Test
    void testN() {
        Thing t = new Thing();
        t.setN(5);
        Assertions.assertEquals(5, t.getN(), "N should be 5");
    }
}
