package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();

        System.out.print("Check-in date (dd/mm/yyyy): ");
        String checkInInput = sc.next();
        LocalDate checkIn = LocalDate.parse(checkInInput, fmt);

        System.out.print("Check-out date (dd/mm/yyyy): ");
        String checkOutInput = sc.next();
        LocalDate checkOut = LocalDate.parse(checkOutInput, fmt);

        if (!checkOut.isAfter(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkInInput = sc.next();
            checkIn = LocalDate.parse(checkInInput, fmt);

            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOutInput = sc.next();
            checkOut = LocalDate.parse(checkOutInput, fmt);

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            }
            else {
                System.out.println("Updated Reservation: " + reservation);

            }

        }
        sc.close();
    }
}
