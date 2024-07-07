import java.util.Scanner;

public class W2051753_CinemaManagement {
    private final int[][] seat_pattern;
    private final int num_of_seats_per_rows;
    private final int num_of_rows;

    public W2051753_CinemaManagement(int rows, int seatsPerRow) {
        this.num_of_rows = rows;
        this.num_of_seats_per_rows = seatsPerRow;
        this.seat_pattern = new int[num_of_rows][num_of_seats_per_rows];
        setAllToZero();
    }

    //set all array element to 0 cuz it need to represent as 0 at the start
    public void setAllToZero() {
        for (int i = 0; i < num_of_rows; i++) {
            for (int j = 0; j < num_of_seats_per_rows; j++) {
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

            if (option < 1 || (option >= 7 && option != 8)) {
                System.out.println("Invalid option. Please try again.");
                print_Menu();
            }

            if (option == 8) {
                System.out.println("Exiting Programme.! Thank You.");
                break;
            }

            switch (option) {

                case 1 -> buy_ticket();
                case 2 -> cancel_ticket();
                case 3 -> print_seating_area();
                case 4 -> find_first_available();
                case 5 -> print_Menu();
                case 6 -> print_Menu();
                case 7 -> print_Menu();
                default -> System.out.println("wrong input");
            }
        }
    }

    public void buy_ticket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row number (1 to " + (num_of_rows) + "): ");
        int rowNum = scanner.nextInt();
        System.out.print("Enter seat number (1 to " + (num_of_seats_per_rows) + "): ");
        int seatNum = scanner.nextInt();

        //change real world input into array fitted
        rowNum=rowNum-1;
        seatNum=seatNum-1;

        if (rowNum >= 0 && rowNum < num_of_rows && seatNum >= 0 && seatNum < num_of_seats_per_rows) {
            if (seat_pattern[rowNum][seatNum] == 0) {
                seat_pattern[rowNum][seatNum] = 1;
                System.out.println("The seat has been booked");
            } else {
                System.out.println("This seat is not available");
            }
        } else {
            System.out.println("Invalid Row or Seat Number.!");
        }
    }

    public void  cancel_ticket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row number (1 to " + (num_of_rows) + "): ");
        int rowNum = scanner.nextInt();
        System.out.print("Enter seat number (1 to " + (num_of_seats_per_rows) + "): ");
        int seatNum = scanner.nextInt();

        //change real world input into array fitted
        rowNum=rowNum-1;
        seatNum=seatNum-1;

        if (rowNum >= 0 && rowNum < num_of_rows && seatNum >= 0 && seatNum < num_of_seats_per_rows) {
            if (seat_pattern[rowNum][seatNum] == 1) {
                seat_pattern[rowNum][seatNum] = 0;
                System.out.println("The seat has been cancelled");

            } else {
                System.out.println("This seat is already available");
            }
        } else {
            System.out.println("Invalid Row or Seat Number.!");
        }
    }

    public void print_seating_area() {
        System.out.println("    ***********************");
        System.out.println("    *       SCREEN        *");
        System.out.println("    ***********************");

        for (int i = 0; i < num_of_rows; i++) {
            for (int j = 0; j < num_of_seats_per_rows; j++) {
                if (j == (num_of_seats_per_rows / 2)) {
                    System.out.print("  ");
                }
                if(seat_pattern[i][j]==1){
                    System.out.print("X"+" ");
                }else {
                    System.out.print(seat_pattern[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public void  find_first_available() {
        boolean didFind = false;

        for (int i = 0; i < num_of_rows; i++) {
            for (int j = 0; j < num_of_seats_per_rows; j++) {
                if (seat_pattern[i][j] == 1) {
                    continue;
                } else {
                    System.out.println("Row - " + (i+1)+ ' ' +"Seat -" + (j+1));
                    didFind=true;
                    break;
                }
            }
            if (didFind){
               break;
            }

        }
    if(!didFind){
        System.out.println("Unfortunately . All seats are booked !");
    }
    }
}



