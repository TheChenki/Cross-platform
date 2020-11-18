package AbstractFactory.Concrete;

import AbstractFactory.Abstract.PassengerPlane;

public class TuPassengerPlane implements PassengerPlane
{
    @Override
    public void takeOff()
    {
        System.out.println("Пассажирский самолет Ту взлетел");
    }

    @Override
    public void land()
    {
        System.out.println("Пассажирский самолет Ту приземлился");
    }

    @Override
    public void addPilot()
    {
        System.out.println("Пилот сел в пассажирский самолет Ту");
    }

    @Override
    public void addPassenger()
    {
        System.out.println("Пассажир сел в пассажирский самолет Ту");
    }
}
