package AbstractFactory.Concrete;

import AbstractFactory.Abstract.CargoPlane;

public class BoeingCargoPlane implements CargoPlane
{
    @Override
    public void takeOff()
    {
        System.out.println("Грузовой самолет Боинг взлетел");
    }

    @Override
    public void land()
    {
        System.out.println("Грузовой самолет Боинг приземлился");
    }

    @Override
    public void addPilot()
    {
        System.out.println("Пилот сел в грузовой самолет Боинг");
    }

    @Override
    public void addCargo()
    {
        System.out.println("Груз добавлен в грузовой самолет Боинг");
    }
}
