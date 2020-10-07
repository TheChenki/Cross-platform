package SignalLib.calculations;

import java.util.Collections;
import java.util.List;

public class SignalCharacteristicsCalculator
{
    public int calculateDynamicRange(List<Integer> numbers)
    {
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);

        return max - min;
    }

    public int calculateSignalEnergy(List<Integer> numbers)
    {
        int result = 0;

        for (Integer i : numbers)
        {
            result += (i * i);
        }

        return result;
    }

    public float calculateAverageSignalStrength(List<Integer> numbers)
    {
        float result = 0f;

        for (Integer i : numbers)
        {
            result += (i * i);
        }

        return result / numbers.size();
    }

    public float calculateAverageSignalSamplesValue(List<Integer> numbers)
    {
        float result = 0f;

        for (Integer i : numbers)
        {
            result += i;
        }

        return result / numbers.size();
    }

    public float calculateSignalSampleValuesVariance(List<Integer> numbers)
    {
        float m = calculateAverageSignalSamplesValue(numbers);
        float result = 0f;

        for (Integer i : numbers)
        {
            result += ((i - m) * (i - m));
        }

        return result / numbers.size();
    }

    public float calculateAutocorrelation(List<Integer> numbers, int tau)
    {
        float m = calculateAverageSignalSamplesValue(numbers);
        float result = 0f;

        tau = (tau > 0) ? tau : -tau;

        for(int i = 0; i < numbers.size() - tau; i++)
        {
            result += (numbers.get(i + tau) - m) * (numbers.get(i) - m);
        }

        return result / (numbers.size() - tau);
    }

    public float calculateCorrelationInterval(List<Integer> numbers)
    {
        float result = 0f;

        for(int i = 0; i < numbers.size(); i++)
        {
            result += calculateAutocorrelation(numbers, i);
        }

        return result / calculateAutocorrelation(numbers, 0);
    }
}
