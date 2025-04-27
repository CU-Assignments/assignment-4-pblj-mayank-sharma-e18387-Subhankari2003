// Hard/TicketBookingSystem.java
class TicketCounter {
    private int ticketsAvailable = 10;

    public synchronized void bookTicket(String passengerName, int numberOfTickets) {
        if (numberOfTickets <= ticketsAvailable) {
            System.out.println(passengerName + " booked " + numberOfTickets + " ticket(s) successfully.");
            ticketsAvailable -= numberOfTickets;
        } else {
            System.out.println("Sorry " + passengerName + ", not enough tickets available!");
        }
    }
}

class BookingThread extends Thread {
    TicketCounter ticketCounter;
    String passengerName;
    int ticketsToBook;

    BookingThread(TicketCounter counter, String name, int tickets) {
        this.ticketCounter = counter;
        this.passengerName = name;
        this.ticketsToBook = tickets;
    }

    public void run() {
        ticketCounter.bookTicket(passengerName, ticketsToBook);
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        BookingThread passenger1 = new BookingThread(counter, "Alice", 4);
        BookingThread passenger2 = new BookingThread(counter, "Bob", 5);
        BookingThread passenger3 = new BookingThread(counter, "Charlie", 3);

        passenger1.start();
        passenger2.start();
        passenger3.start();
    }
}
