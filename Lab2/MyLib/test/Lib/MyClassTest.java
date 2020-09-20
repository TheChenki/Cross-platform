package Lib;

import static org.junit.jupiter.api.Assertions.*;

class MyClassTest
{

    @org.junit.jupiter.api.Test
    void acrostic()
    {
        System.err.println("Running testAcrostic...");
        String result = MyClass.acrostic(new String[] {"fnord", "polly", "tropism"});
        assertEquals("foo", result);
    }
}