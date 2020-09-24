package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import SignalLib.calculations.*;

public class Program
{
    public static void main(String[] args) throws IOException
    {
        List<Integer> numbers = readFile("D:\\14.bin");
        SignalCharacteristicsCalculator signalCalculator = new SignalCharacteristicsCalculator();

        Integer dynamicRange = signalCalculator.calculateDynamicRange(numbers);
        Integer signalEnergy = signalCalculator.calculateSignalEnergy(numbers);
        Float avgSignalStrength = signalCalculator.calculateAverageSignalStrength(numbers);
        Float avgSignalSamplesValue =  signalCalculator.calculateAverageSignalSamplesValue(numbers);
        Float signalSampleValuesVariance = signalCalculator.calculateSignalSampleValuesVariance(numbers);

        System.out.println(dynamicRange);
        System.out.println(signalEnergy);
        System.out.println(avgSignalStrength);
        System.out.println(avgSignalSamplesValue);
        System.out.println(signalSampleValuesVariance);

    }

    public static List<Integer> readFile(String path) throws IOException
    {
        List<Integer> list = new ArrayList<Integer>();
        FileInputStream inputStream = new FileInputStream(path);

        int readResult;
        do
        {
            readResult = inputStream.read();

            if (readResult != -1)
            {
                list.add(readResult);
            }

        }
        while (readResult != -1);

        return list;
    }
}
