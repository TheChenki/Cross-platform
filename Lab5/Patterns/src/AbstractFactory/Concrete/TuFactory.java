package AbstractFactory.Concrete;

import AbstractFactory.Abstract.AbstractFactory;
import AbstractFactory.Abstract.CargoPlane;
import AbstractFactory.Abstract.PassengerPlane;

public class TuFactory implements AbstractFactory
{

    @Override
    public CargoPlane createCargoPlane()
    {
        return new TuCargoPlane();
    }

    @Override
    public PassengerPlane createPassengerPlane()
    {
        return new TuPassengerPlane();
    }
}
