package Lib;

public class MyClass
{
    /**
     * @param args string array text
     * @return string acrostic
     */
    public static String acrostic(String[] args)
    {
        StringBuffer b = new StringBuffer();

        for (int i = 0; i < args.length; i++)
        {
            if (args[i].length() > i)
            {
                b.append(args[i].charAt(i));
            }
            else
            {
                b.append('?');
            }
        }

        return b.toString();
    }
}
