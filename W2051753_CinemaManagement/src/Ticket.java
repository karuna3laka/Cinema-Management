public class Ticket {
    private int row;
    private int price;
    private int seat;
    private Person person;
    private int ticketcount;//handle total price


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        seat = seat;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Ticket(int row, int price, int seat, Person person, int ticketcount) {
        this.row = row;
        this.price = price;
        this.seat = seat;
        this.person = person;
        this.ticketcount=ticketcount;

    }

    public void printTicketInfo() {
        System.out.println("Ticket Information:");
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);

        System.out.println("Total Ticket Price:" + price);//here
        System.out.println("Person Information:");
        person.printPersonInfo();
    }
}
