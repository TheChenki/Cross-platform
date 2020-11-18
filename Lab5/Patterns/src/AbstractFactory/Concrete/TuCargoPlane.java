package AbstractFactory.Concrete;

import AbstractFactory.Abstract.CargoPlane;

public class TuCargoPlane implements CargoPlane
{
    @Override
    public void takeOff()
    {
        System.out.println("Грузовой самолет Ту взлетел");
    }

    @Override
    public void land()
    {
        System.out.println("Грузовой самолет Ту приземлился");
    }

    @Override
    public void addPilot()
    {
        System.out.println("Пилот сел в грузовой самолет Ту");
    }

    @Override
    public void addCargo()
    {
        System.out.println("Груз добавлен в грузовой самолет Ту");
    }
}
