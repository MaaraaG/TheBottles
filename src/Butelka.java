
import java.util.Scanner;
public class Butelka {
    private double[] howManyLiters = {3.00, 12.00, 15.00, 20.00, 25.00, 30.00, 35.00, 45.00, 13.00, 25.00, 56.00, 89.00,
            39.00, 75.00, 62.00, 84.00, 21.00, 36.00, 54.00, 25.00, 89.00, 41.00, 24.00, 25.50, 24.30, 68.00, 47.90,
            54.30, 12.40, 10.70, 32.40, 28.40, 21.40, 71.20, 25.55, 27.69, 14.70, 5.12, 2.55, 1.50, 3.50, 5.00, 5.70,
            7.00, 1200.00, 100.00, 453.00, 873.25, 421.12, 111.11 };                                                     // content liquid in the bottle

    double[] capacity = {15, 27, 35, 45, 55, 65, 80, 58, 38, 81, 145, 128, 114, 137, 146, 105, 57, 90, 79, 114, 130,
            65, 50, 50, 92, 116, 102, 67, 23, 43, 61, 50, 93, 97, 53, 42, 20, 8, 4, 5, 9, 11, 13, 1207, 1300,  553, 1326, 1294, 532, 111}; // max content bottles


    void unsubscribe()
    {
        System.out.println("Hello!");
        System.out.println("In Magazine u have: " + capacity.length + " Bottles!");
        System.out.println();
        for (int i = 0; i < capacity.length; i++) {
            int z = i + 1;
            System.out.println("Bottle nr " + z + " have " + capacity[i] + " Liters of capacity with " + howManyLiters[i] + " liquid!");
                        }

        }


    void chooseOption()
    {
        Scanner end = new Scanner(System.in);
        System.out.println();
        System.out.print("What do you want to do? (pour from to/pour in/pour out/out): ");
        String x = end.nextLine();

        if (x.equalsIgnoreCase("pour from to"))
        {
            pourFromTo();
        }
        else if (x.equalsIgnoreCase("pour in"))
        {
            pourIn();
        }
        else if (x.equalsIgnoreCase("pour out"))
        {
            pourOut();
        }
        else if (x.equalsIgnoreCase("out"))
        {
            System.out.println("OK BYE!");
        }
        else {
            System.out.println("Sorry, it seems that you typed the wrong word ... ");
            chooseOption();
        }
    }

    void pourFromTo()
    {
            Scanner pft = new Scanner(System.in);
            System.out.println("=====================================");
            System.out.print("How much liquid do you want to pour?: ");
            double quantity = pft.nextDouble();                                          //Set a quantity liquid to pour

            System.out.println("=====================================");
            System.out.print("Choose the bottle number (from 1 to " + capacity.length + ") from which you want to pour the liquid: ");
            int bottleFrom = pft.nextInt() - 1;                                           //Set a bottle from you want to pour


            if (howManyLiters[bottleFrom] >= quantity)
            {
                bottleFrom++;
                System.out.print("Grate you choose bottle nr " + bottleFrom);
                bottleFrom--;
                System.out.println(" witch " + howManyLiters[bottleFrom] + " Liters!");
            }
                else
                    {
                    System.out.println("This bottle don't have enough liquid");
                    pourFromTo();
                    }

            System.out.println("=====================================");
            System.out.print("Now select the bottle number (from 1 to " + capacity.length + "): which you want to pour the liquid into: ");
            int bottleTo = pft.nextInt();
            bottleTo--;

                if (capacity[bottleTo] > quantity + howManyLiters[bottleTo]) {
                    if (bottleTo != bottleFrom) {
                        howManyLiters[bottleTo] += quantity;
                        howManyLiters[bottleFrom] -= quantity;
                        bottleTo++;
                        System.out.println();
                        System.out.print("In bottle nr " + bottleTo + " now is ");
                        bottleTo--;
                        System.out.println(howManyLiters[bottleTo] + " Liters! ");
                        System.out.println();
                    } else {
                        System.out.println("You can't pour to the same bottle!");
                        pourFromTo();
                    }
                } else {
                    if (bottleTo != bottleFrom) {
                        System.out.println("Too small bottle!");
                        howManyLiters[bottleFrom] = howManyLiters[bottleFrom] - (capacity[bottleTo] - howManyLiters[bottleTo]);
                        howManyLiters[bottleTo] = capacity[bottleTo];
                    }
                }
                System.out.println("Now your current quantity liquid in bottles equals: ");

            for (int i = 0; i < capacity.length; i++)
            {
                int z = i + 1;
                System.out.println("Bottle nr " + z + " have " + capacity[i] + " Liters of capacity with " + howManyLiters[i] + " liquid!");
            }

            Scanner choose = new Scanner(System.in);
            System.out.println("Do you want to proceed? (yes/no): ");
            String y = choose.nextLine();

            while (y != "no"){
                if (y.equalsIgnoreCase("yes"))
                {
                    chooseOption();
                }
                    else if (y.equalsIgnoreCase("no"))
                    {
                        System.out.println("OK BYE!");
                        System.out.println();
                        System.out.println("=================== END ===================");
                    }
                        else
                            System.out.println("Sorry, it seems that you typed the wrong word ... ");
                            y = choose.nextLine();
            }

    }


    void pourIn ()
    {
        Scanner pi = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.print("How much liquid do you want to pour in?: ");
        double howMany = pi.nextDouble();                                       //Set a quantity liquid to pour in

        System.out.println("=====================================");
        System.out.print("Now select the bottle number (from 1 to " + capacity.length + "): which you want to pour the liquid into: ");
        int bottleTo = pi.nextInt();                                            //Set the bottle to which you want to pour the liquid
        bottleTo--;

        if (capacity[bottleTo] >= howMany + howManyLiters[bottleTo])
        {
            howManyLiters[bottleTo] += howMany;
            bottleTo++;
            System.out.println();
            System.out.print("In bottle nr " + bottleTo + " now is ");
            bottleTo--;
            System.out.println(howManyLiters[bottleTo] + " Liters! ");
            System.out.println();
        }
            else
                {
                System.out.println("Too small bottle!");
                howManyLiters[bottleTo] = capacity[bottleTo];
                }

        System.out.println("Now your current quantity liquid in bottles equals: ");

        for (int i = 0; i < capacity.length; i++)
        {
            int z = i + 1;
            System.out.println("Bottle nr " + z + " have " + capacity[i] + " Liters of capacity with " + howManyLiters[i] + " liquid!");
        }

        Scanner pd = new Scanner(System.in);
        System.out.println("Do you want to proceed? (yes/no): ");
        String proceed = pd.nextLine();

        while (proceed != "no") {
            if (proceed.equalsIgnoreCase("yes")) {
                chooseOption();
            } else if (proceed.equalsIgnoreCase("no")) {
                System.out.println("OK BYE!");
                System.out.println();
                System.out.println("=================== END ===================");
            } else
                System.out.println("Sorry, it seems that you typed the wrong word ... ");
                proceed = pd.nextLine();
        }
    }

    void pourOut ()
    {
        Scanner po = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.print("How much liquid do you want to pour out?: ");
        double howMany = po.nextDouble();                                       //Set a quantity liquid to pour in

        System.out.println("=====================================");
        System.out.print("Now select the bottle number (from 1 to " + capacity.length + "): from which you want to pour the liquid out: ");
        int bottleFrom = po.nextInt();                                            //Set the bottle to which you want to pour the liquid
        bottleFrom--;

        if (howManyLiters[bottleFrom] >= howMany )
        {
            howManyLiters[bottleFrom] -= howMany;
            bottleFrom++;
            System.out.println();
            System.out.print("In bottle nr " + bottleFrom + " now is ");
            bottleFrom--;
            System.out.println(howManyLiters[bottleFrom] + " Liters! ");
            System.out.println();
        }
        else
        {
            System.out.println("Not enough liquid! You pour out only: " + howManyLiters[bottleFrom] + " Liters!" );
            howManyLiters[bottleFrom] = 0;
        }

        System.out.println("Now your current quantity liquid in bottles equals: ");

        for (int i = 0; i < capacity.length; i++)
        {
            int z = i + 1;
            System.out.println("Bottle nr " + z + " have " + capacity[i] + " Liters of capacity with " + howManyLiters[i] + " liquid!");
        }

        Scanner pd = new Scanner(System.in);
        System.out.print("Do you want to proceed? (yes/no): ");
        String proceed = pd.nextLine();
        while (proceed != "no")
        {
            if (proceed.equalsIgnoreCase("yes")) {
                chooseOption();
            } else if (proceed.equalsIgnoreCase("no")) {
                System.out.println("OK BYE!");
                System.out.println();
                System.out.println("=================== END ===================");
            } else
                System.out.println("Sorry, it seems that you typed the wrong word ... ");
                proceed = pd.nextLine();
        }

    }
}




//===============================================================================// Testujaca klasa
class ButelkaTester {
    public static void main(String[] args) {

        System.out.println();
        Butelka butelka = new Butelka();
        butelka.unsubscribe();
        butelka.chooseOption();
    }
}


