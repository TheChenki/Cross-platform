package AbstractFactory.Concrete;

import AbstractFactory.Abstract.CargoPlane;
import AbstractFactory.Abstract.AbstractFactory;
import AbstractFactory.Abstract.PassengerPlane;

public class BoeingFactory implements AbstractFactory
{
    @Override
    public CargoPlane createCargoPlane()
    {
        return new BoeingCargoPlane();
    }

    @Override
    public PassengerPlane createPassengerPlane()
    {
        return new BoeingPassengerPlane();
    }
}
