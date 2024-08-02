import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ReservationSystem {

    public List<Reservation> viewReservations(String filter) {

        List<Reservation> filteredReservations = new ArrayList<>();
        for (Reservation reservation : reservations.values()) {
            if (filter != null && reservation.tostring().contains(filter)) {
                filteredReservations.add(reservation);

            }
        }
        return filteredReservations;
        ;
    }

    public String checkAvailability(String date, String time) {
        for (Reservation reservation : reservations) {
            if (reservation.getDate().equals(date) && reservation.getTime().equals(time)) {
                int tableNumber = reservation.getTableNumber();
                for (Table table : tables) {
                    if (tableNumber == table.getTableNumber()) {
                        boolean availability = table.isAvailable();
                    }
                }

            }
            if (availability == true) {
                return "Table " + tableNumber + " is available.";
            } else {
                return "Table " + tableNumber + " is not available.";
            }
        }

    }
}

class Table {
    private int tableNumber;
    private boolean available;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.available = true;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public setAvailable(boolean available){
        this.available = available;
    }
}

class Reservation {
    private String reservationId;
    private String customerName;
    private String date;
    private String time;
    private int numPeople;
    private int tableNumber;

    public Reservation(String customerName, String date, String time, int numPeople, int tableNumber) {
        this.reservationId = generateID();
        this.customerName = customerName;
        this.date = date;
        this.time = time;
        this.numPeople = numPeople;
        this.tableNumber = tableNumber;
    }

    public String generateID() {
        Random random = new Random();
        long randomNumber = Math.abs(random.nextLong() % 10000000000L);

        return String.format("%010d", randomNumber);
    }

    // Getters and setters
    public String getReservationId() {
        return reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    @Override
    public String toString() {
        return String.format("Reservation ID: %s, Customer: %s, Date: %s, Time: %s, Number of People: %d",
                reservationId, customerName, date, time, numPeople);
    }
}

class myPart {
    public List<Reservation> generateSummary(String startDate, String endDate) {
        List<Reservation> summary = new LinkedList<>();
        // reservations would be a list of the reservations that have been booked hmm

        for (Reservation reservation : reservations) {
            if (reservation.getDate().compareTo(startDate) >= 0 &&
                    reservation.getDate().compareTo(endDate) <= 0) {
                summary.add(reservation);
            }
        }
        return summary;
    }
