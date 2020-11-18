package Flyweight;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Main
{
    public static void main(String[] args)
    {
        BacteriaFactory factory = new BacteriaFactory();

        Scanner scanner = new Scanner(System.in);
        Pattern bacteriaCommand = Pattern.compile("^(!bacteria) (?<type>[A-C]) (?<x>\\d+) (?<y>\\d+)$");
        Matcher matcher;

        while(true)
        {
            String s = scanner.nextLine();

            matcher = bacteriaCommand.matcher(s);
            if(matcher.find())
            {
                int x = parseInt(matcher.group("x"));
                int y = parseInt(matcher.group("y"));
                String type = matcher.group("type");

                factory.getBacteria(type).display(x,y);
            }
        }
    }
}
