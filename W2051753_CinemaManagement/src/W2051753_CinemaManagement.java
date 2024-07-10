import java.util.Scanner;

public class W2051753_CinemaManagement {
    private final int[][] seat_pattern;
    private final int num_of_seats_per_rows;
    private final int num_of_rows;
    private final Ticket[] tickets;
    private int soldTicketCount = 0;
    private int rowPrice=0;



    public W2051753_CinemaManagement(int rows, int seatsPerRow) {
        this.num_of_rows = rows;
        this.num_of_seats_per_rows = seatsPerRow;
        this.seat_pattern = new int[num_of_rows][num_of_seats_per_rows];
        this.tickets = new Ticket[48]; //whole possibilities can be (numrows * columns)
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
        selectOption();
    }

    public void selectOption() {
        System.out.print("Select Option : ");
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
                case 5 -> print_tickets_info();
                case 6 -> search_ticket();
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
        rowNum--;
        seatNum--;

        if (rowNum >= 0 && rowNum < num_of_rows && seatNum >= 0 && seatNum < num_of_seats_per_rows) {
            if (seat_pattern[rowNum][seatNum] == 0) {
                seat_pattern[rowNum][seatNum] = 1;

                int[] seatPriceArr= {12,10,8};

                if (rowNum==0){
                    rowPrice = seatPriceArr[0];
                }else if(rowNum==1 ){
                    rowPrice = seatPriceArr[1];
                }else {
                    rowPrice=seatPriceArr[2];
                }



                System.out.print("What is your First Name ->");
                String name = scanner.next();

                System.out.print("What is your SurName ->");
                String surname = scanner.next();

                System.out.print("What is your Email ->");
                String email = scanner.next();

                Person person = new Person( name,surname,email);
                Ticket ticket = new Ticket(rowNum+1,rowPrice,seatNum+1,person,soldTicketCount+1);
                tickets[soldTicketCount++]=ticket;
//                totalPrice += price;//add one into tickets

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
        rowNum--;
        seatNum--;

        if (rowNum >= 0 && rowNum < num_of_rows && seatNum >= 0 && seatNum < num_of_seats_per_rows) {
            if (seat_pattern[rowNum][seatNum] == 1) {
                seat_pattern[rowNum][seatNum] = 0;

                boolean didFind = false;

                for (int i = 0; i < soldTicketCount; i++) {
                    if (tickets[i].getRow() == rowNum + 1 && tickets[i].getSeat() == seatNum + 1) {
                        tickets[i] = null;
                        didFind = true;

                        for (int j = i; j < soldTicketCount - 1; j++) {
                            tickets[j] = tickets[j + 1];
                        }

                        tickets[soldTicketCount - 1] = null;
                        soldTicketCount--;

                        break;
                    }
                }
                if (didFind) {
                    System.out.println("The seat has been cancelled.");
//                    print_tickets_info();

                } else {
                    System.out.println("No ticket found for the specified seat.");
                }

            } else {
                System.out.println("This seat is already available");
            }
        } else {
            System.out.println("Invalid Row or Seat Number.!");
        }
    }

    public void print_seating_area() {
        System.out.println("    ***********************");
        System.out.println("    *        SCREEN       *");
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
    public void  find_first_available() { //kinda like find first linear Algoritham
        boolean didFind = false;

        for (int i = 0; i < num_of_rows; i++) {
            for (int j = 0; j < num_of_seats_per_rows; j++) {
                if (seat_pattern[i][j] == 1) {
                    continue;
                } else {
                    System.out.println("Row - " + (i + 1) + ' ' + "Seat -" + (j + 1));
                    didFind = true;
                    break;
                }
            }
            if (didFind) {
                break;
            }
        }
        if (!didFind) {
            System.out.println("Unfortunately . All seats are booked !");
        }
    }  //total pricee still not implimented
    public void  print_tickets_info(){
        for (int i = 0; i < soldTicketCount; i++) {
            tickets[i].printTicketInfo();

        }
    }

    public void  search_ticket(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is the Row? ->");
        int rowSearch = scanner.nextInt();

        System.out.print("What is the Seat? ->");
        int seatSearch = scanner.nextInt();

        rowSearch--;
        seatSearch--;

        boolean searchTickFound = false;
        for(int i=0 ; i < soldTicketCount;i++){
            if(tickets[i] != null && tickets[i].getRow() == rowSearch+1 && tickets[i].getSeat() == seatSearch + 1){
                    tickets[i].printTicketInfo();
                    searchTickFound = true;
                    break;
            }
        }
        if (!searchTickFound) {
            System.out.println("This seat is available.");
        }
        
    }



}






