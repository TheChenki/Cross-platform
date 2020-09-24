package SignalLib.calculations;

import java.util.Collections;
import java.util.List;

public class SignalCharacteristicsCalculator
{
    public Integer calculateDynamicRange(List<Integer> numbers)
    {
        Integer min = Collections.min(numbers);
        Integer max = Collections.max(numbers);

        return max - min;
    }

    public Integer calculateSignalEnergy(List<Integer> numbers)
    {
        Integer result = 0;

        for (Integer i : numbers)
        {
            result += (i * i);
        }

        return result;
    }

    public Float calculateAverageSignalStrength(List<Integer> numbers)
    {
        Float result = 0f;

        for (Integer i : numbers)
        {
            result += (i * i);
        }

        return result / numbers.size();
    }

    public Float calculateAverageSignalSamplesValue(List<Integer> numbers)
    {
        Float result = 0f;

        for (Integer i : numbers)
        {
            result += i;
        }

        return result / numbers.size();
    }

    public Float calculateSignalSampleValuesVariance(List<Integer> numbers)
    {
        Float m = calculateAverageSignalSamplesValue(numbers);
        Float result = 0f;

        for (Integer i : numbers)
        {
            result += ((i - m) * (i - m));
        }

        return result / numbers.size();
    }
}
