package AbstractFactory;

import AbstractFactory.Abstract.CargoPlane;
import AbstractFactory.Abstract.PassengerPlane;
import AbstractFactory.Concrete.BoeingFactory;
import AbstractFactory.Concrete.TuFactory;

public class Main
{
    public static void main(String[] args)
    {
        BoeingFactory boeingFactory = new BoeingFactory();
        TuFactory tuFactory = new TuFactory();

        CargoPlane cargoPlane1 = boeingFactory.createCargoPlane();
        CargoPlane cargoPlane2 = tuFactory.createCargoPlane();

        PassengerPlane passengerPlane1 = boeingFactory.createPassengerPlane();
        PassengerPlane passengerPlane2 = tuFactory.createPassengerPlane();

        cargoPlane1.addCargo();
        cargoPlane1.takeOff();

        cargoPlane2.addCargo();
        cargoPlane2.takeOff();

        passengerPlane1.addPassenger();
        passengerPlane1.addPilot();

        passengerPlane2.addPassenger();
        passengerPlane2.addPilot();
    }
}

