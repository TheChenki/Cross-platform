package Flyweight;

import java.util.HashMap;

public class BacteriaFactory
{
    private HashMap<String, Bacteria> bacterias = new HashMap();

    public Bacteria getBacteria(String bacteriaType)
    {
        Bacteria bacteria = bacterias.get(bacteriaType);
        if (bacteria == null)
        {
            System.out.println("Добавление новой бактерии в хэш");
            switch (bacteriaType)
            {
                case "A":
                {
                    bacteria = new BacteriaA();
                    break;
                }
                case "B":
                {
                    bacteria = new BacteriaB();
                    break;
                }
                case "C":
                {
                    bacteria = new BacteriaC();
                    break;
                }
            }
            bacterias.put(bacteriaType, bacteria);
        }
        return bacteria;
    }
}
