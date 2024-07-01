import java.util.Scanner;

public class W2051753_CinemaManagement {
    private final int[][] seat_pattern;
    private final int num_of_seats_per_rows;
    private final int num_of_rows;

    public W2051753_CinemaManagement(int rows, int seatsPerRow) {
        this.num_of_rows = rows;
        this.num_of_seats_per_rows = seatsPerRow;
        this.seat_pattern = new int[num_of_seats_per_rows][num_of_rows];
        setAllToZero();
    }

    //set arrays to 0 cuz it need to represent as 0 at the start
    public void setAllToZero() {
        for (int i = 0; i < num_of_seats_per_rows; i++) {
            for (int j = 0; j < num_of_rows; j++) {
                seat_pattern[i][j] = 0;
            }
        }
    }

    public void print_Menu() {
        System.out.println("---------------------------------------------------------");
        System.out.println("1) Buy a ticket");
        System.out.println("2) Cancel ticket");
        System.out.println("3) See seating plan");
        System.out.println("4) Find first seat available");
        System.out.println("5) Print ticket information and total price");
        System.out.println("6) Search ticket");
        System.out.println("7) Sort tickets by price");
        System.out.println("8) Exit");
        System.out.println("---------------------------------------------------------");
        System.out.println("Select Option : ");
        selectOption();
    }

    public void selectOption() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            int option = scanner.nextInt();

            if (option < 1 || (option > 3 && option != 8)) {
                System.out.println("Invalid option. Please try again.");
                print_Menu();
            }

            if (option == 8) {
                System.out.println("Exiting Programme.! Thank You.");
            }

            switch (option) {

                case 1 -> buy_ticket();
                case 2 -> System.out.println("innnn");
                case 3 -> print_Menu();
                case 4 -> print_Menu();
                case 5 -> print_Menu();
                case 6 -> print_Menu();
                case 7 -> print_Menu();
                default -> System.out.println("wrong input");
            }
        }
    public void buy_ticket () {
        


        }
    }


}