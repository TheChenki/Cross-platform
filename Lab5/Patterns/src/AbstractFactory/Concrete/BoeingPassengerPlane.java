package AbstractFactory.Concrete;

import AbstractFactory.Abstract.PassengerPlane;

public class BoeingPassengerPlane implements PassengerPlane
{
    @Override
    public void takeOff()
    {
        System.out.println("Пассажирский самолет Боинг взлетел");
    }

    @Override
    public void land()
    {
        System.out.println("Пассажирский самолет Боинг приземлился");
    }

    @Override
    public void addPilot()
    {
        System.out.println("Пилот сел в пассажирский самолет Боинг");
    }

    @Override
    public void addPassenger()
    {
        System.out.println("Пассажир сел в пассажирский самолет Боинг");
    }
}
