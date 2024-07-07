public class Ticket {
    private int row;
    private int price;
    private int Seat;
    private Person person;

    public Ticket(int row, int price, int seat, Person person) {
        this.row = row;
        this.price = price;
        this.Seat = seat;
        this.person = person;
    }
}
