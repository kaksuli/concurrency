package baeldung.concurrent.threadsafety;

import concurrent.threadsafety.mathutils.MathUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigInteger;


public class MathUtilsUnitTest {
    
    @Test
    public void whenCalledFactorialMethod_thenCorrect() {
        Assertions.assertEquals(MathUtils.factorial(2), new BigInteger("2"));
    }
}
