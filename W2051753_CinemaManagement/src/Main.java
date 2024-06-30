import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // for user input
        System.out.println("* Welcome to The London Lumiere *");

        int rows=3;
        int seats_in_rows=16;

        W2051753_CinemaManagement cinema = new W2051753_CinemaManagement(seats_in_rows, rows);
//        cinema.printSeatPattern();
        cinema.print_Menu();

    }
}
