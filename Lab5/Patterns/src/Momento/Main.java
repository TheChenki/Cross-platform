package Momento;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Main
{
    public static void main(String[] args)
    {
        Sudoku sudoku = new Sudoku();
        History history = new History();

        Scanner scanner = new Scanner(System.in);
        Pattern setCommand = Pattern.compile("^(!set) (?<x>[1-9]) (?<y>[1-9]) (?<number>[0-9])$");
        Pattern backCommand = Pattern.compile("^(!back)$");
        Matcher matcher;

        while (true)
        {
            sudoku.printField();

            String s = scanner.nextLine();

            matcher = setCommand.matcher(s);
            if(matcher.find())
            {
                history.saveToHistory(sudoku.save());

                int x = parseInt(matcher.group("x"));
                int y = parseInt(matcher.group("y"));
                int number = parseInt(matcher.group("number"));
                sudoku.setNumber(x ,y, number);

                continue;
            }

            matcher = backCommand.matcher(s);
            if(matcher.find())
            {
                Memento m = history.getFromHistory();

                if(m != null)
                    sudoku.load(m);

            }
        }
    }

}
