package HelloWorld;

import Lib.*;

public class HelloWorld
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        String result = MyClass.acrostic(args);
        System.out.println("Acrostic result: " + result);


    }
}
