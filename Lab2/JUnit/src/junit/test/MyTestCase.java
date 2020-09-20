package junit.test;

import junit.framework.TestCase;

import java.util.Vector;

public class MyTestCase extends TestCase
{
    public Vector getContainer()
    {
        return container;
    }

    public void setContainer(Vector container)
    {
        this.container = container;
    }

    private Vector container;

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    @Override
    protected void setUp() throws Exception
    {
        container = new Vector();
    }

    public MyTestCase()
    {

    }

    public MyTestCase(String name)
    {
        super(name);
    }
}
