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

        int dynamicRange = signalCalculator.calculateDynamicRange(numbers);
        int signalEnergy = signalCalculator.calculateSignalEnergy(numbers);
        float avgSignalStrength = signalCalculator.calculateAverageSignalStrength(numbers);
        float avgSignalSamplesValue = signalCalculator.calculateAverageSignalSamplesValue(numbers);
        float signalSampleValuesVariance = signalCalculator.calculateSignalSampleValuesVariance(numbers);
        float correlationInterval = signalCalculator.calculateCorrelationInterval(numbers);

        System.out.println("Динамический диапазон: " + dynamicRange);
        System.out.println("Энергия: " + signalEnergy);
        System.out.println("Средняя мощность: " + avgSignalStrength);
        System.out.println("Среднее значение: " + avgSignalSamplesValue);
        System.out.println("Дисперсия: " + signalSampleValuesVariance);
        System.out.println("Интервал корреляции: " + correlationInterval);

        for(int tau = -10; tau <= 10; tau++)
        {
            float result = signalCalculator.calculateAutocorrelation(numbers,tau);
            System.out.println("Автокорреляция(" + tau + "): " + result);
        }

    }
}
