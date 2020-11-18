package Momento;

import java.util.Arrays;

public class Sudoku
{
    private int[][] field = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
    };

    public void printField()
    {
        for(int i = 0; i < 9; i++)
        {
            if(i == 0 || i == 3 || i == 6)
            {
                System.out.println("+-------+-------+-------+");
            }
            System.out.print("| ");

            for (int j = 0; j < 9; j++)
            {
                if(field[i][j] != 0)
                {
                    System.out.print(field[i][j]+ " ");
                }
                else
                {
                    System.out.print(". ");
                }

                if (j == 2 || j == 5)
                {
                    System.out.print("| ");
                }
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");
    }

    public void setNumber(int x, int y, int number)
    {
        field[x-1][y-1] = number;
    }

    public Memento save()
    {
        int arr[][] = Arrays.stream(field).map(int[]::clone).toArray(int[][]::new);
        return new Snapshot(arr);
    }

    public void load(Memento snapshot)
    {
        Snapshot sh = (Snapshot) snapshot;
        this.field = Arrays.stream(sh.field).map(int[]::clone).toArray(int[][]::new);;
    }

    private class Snapshot implements Memento
    {
        private int[][] field;

        public Snapshot(int[][] field)
        {
            this.field = field;
        }
    }

}
