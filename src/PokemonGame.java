import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PokemonGame {
    public static void runPokemonGame() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, StoryBoard> plot = new HashMap<>();

        System.out.println("THUMPPPPP! You have fallen from your bed, " +
                "\nand have awaken from a deep slumber. You" +
                "\n had a strange dream last night about fighting " +
                "\n one of the strongest pokemon you have ever seen. " +
                "\nBut all is well you, are in your bedroom\n");

        System.out.println("Press enter to continue...");
        String con = scanner.nextLine();


        plot.put(0,new StoryBoard(0,"You have quit the game"));
//        plot.put(1, new StoryBoard(1, "THUMPPPPP! You have fallen from your bed, " +
//                "\nand have awaken from a deep slumber. You" +
//                "\n had a strange dream last night about fighting " +
//                "\n one of the strongest pokemon you have ever seen. " +
//                "\nBut all is well you, are in your bedroom"));
        plot.put(1, new StoryBoard(1, "You are in your bedroom"));
        plot.put(2, new StoryBoard(2, "You are in your bedroom bathroom, \nlooks like not much is going on here. \nBut there is a foul smell coming from the toilet."));
        plot.put(3, new StoryBoard(3, "You are now in the living room, \nnoise is coming from the kitchen"));
        plot.put(4, new StoryBoard(4, "You are now in the kitchen, \nyour mom is about to start cooking"));


        plot.get(1).addPaths("BATHROOM", 2);
        plot.get(1).addPaths("DOWNSTAIRS", 3);
        plot.get(1).addPaths("Q", 0);

        plot.get(2).addPaths("BEDROOM", 1);
        plot.get(2).addPaths("Q", 0);

        plot.get(3).addPaths("BEDROOM", 1);
        plot.get(3).addPaths("KITCHEN", 4);
        plot.get(3).addPaths("Q", 0);

        plot.get(4).addPaths("LIVINGROOM", 3);



        Map<String, String> dictionary = new HashMap<>();


        int loc = 1;
        int kitchenCounter = 0;
        while (true) {

            System.out.println(plot.get(loc).getDescription());

            //Limited dialog
            if (loc == 4 && kitchenCounter == 0) {
                System.out.println("Hey Sweetie...");
                con = scanner.nextLine();
                System.out.println("Im about to start cooking, \nwhat would you like");
                con = scanner.nextLine();
                while (con == "") {
                    System.out.println("Sorry I didnt get that, \ncould you tell me again");
                    con = scanner.nextLine();
                }
                System.out.println("Ok i will cook " + con + " with love");
                con = scanner.nextLine();
                kitchenCounter++;
            }
            if (loc == 0) {
                break;
            }
            Map<String, Integer> paths = plot.get(loc).getPaths();
            System.out.println("Available Paths");
            for (String path : paths.keySet()) {
                System.out.println(path + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            String[] sentence = direction.split(" ");
            boolean flag = true;
            while (flag) {
                for (String word : sentence) {

                    if (paths.containsKey(word)) {
                        loc = paths.get(word);
                        break;
                    }
                }flag=false; //never used
            }
            if (flag = false) {
                System.out.println("Please choose a valid path");
            }

        }


    }

}
