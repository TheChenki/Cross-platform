/**
 * This class demonstrates first java application
 * @author Denis Keshishyan d.keshishyan@student.csn.khai.edu
 * @version 1.0
 * @since 06.09.2020
 */
public class Lab1
{
    /**
     * This method demonstrates short student information
     * @param args Unused
     */
    public static void main(String[] args)
    {
		String[][] array = {
			{"*"," "," ","*"," "," ","*","*","*"," "," "," ","*","*","*"," "," "},
			{"*"," "," ","*"," "," ","*"," "," ","*"," "," ","*"," "," ","*"," "},
			{"*"," ","*"," "," "," ","*"," "," ","*"," "," ","*"," "," ","*"," "},
			{"*","*"," "," "," "," ","*"," "," ","*"," "," ","*","*","*"," "," "},
			{"*"," ","*"," "," "," ","*"," "," ","*"," "," ","*","*"," "," "," "},
			{"*"," "," ","*"," "," ","*"," "," ","*"," "," ","*"," ","*"," "," "},
			{"*"," "," ","*"," "," ","*","*","*"," "," "," ","*"," "," ","*"," "}
		};
        System.out.println("Group: 545a");
        System.out.println("Student: Keshishyan Denis Rubenovich");
        System.out.println("Variant: 5");
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[0].length; j++)
			{
				System.out.print(array[i][j]);
			}
			System.out.println("");
		}
    }
}
