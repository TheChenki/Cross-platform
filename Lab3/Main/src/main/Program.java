package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import SignalLib.calculations.*;
import SignalLib.io.FileReader;

public class Program
{
    public static void main(String[] args) throws IOException
    {
        List<Integer> numbers = null;

        if (args.length == 0)
        {
            System.out.println("Укажите путь к файлу");
            return;
        }

        try
        {
            numbers = FileReader.readFile(args[0]);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Файл не найден");
            return;
        }
        catch (IOException ex)
        {
            System.out.println("Ошибка файла");
            return;
        }

        SignalCharacteristicsCalculator signalCalculator = new SignalCharacteristicsCalculator();

        Integer dynamicRange = signalCalculator.calculateDynamicRange(numbers);
        Integer signalEnergy = signalCalculator.calculateSignalEnergy(numbers);
        Float avgSignalStrength = signalCalculator.calculateAverageSignalStrength(numbers);
        Float avgSignalSamplesValue = signalCalculator.calculateAverageSignalSamplesValue(numbers);
        Float signalSampleValuesVariance = signalCalculator.calculateSignalSampleValuesVariance(numbers);

        System.out.println(dynamicRange);
        System.out.println(signalEnergy);
        System.out.println(avgSignalStrength);
        System.out.println(avgSignalSamplesValue);
        System.out.println(signalSampleValuesVariance);
    }
}
