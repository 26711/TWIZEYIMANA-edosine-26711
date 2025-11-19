package _26711.q2;

import java.util.Date;
import java.util.Scanner;

// Base Entity class
class Entity {
    private int id;
    private Date createdDate;
    private Date updatedDate;

    public Entity(int id, Date createdDate, Date updatedDate) {
        if (id <= 0) throw new IllegalArgumentException("ID must be > 0");
        if (createdDate == null || updatedDate == null) throw new IllegalArgumentException("Dates must not be null");
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getId() { return id; }
    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID must be > 0");
        this.id = id;
    }
    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) {
        if (createdDate == null) throw new IllegalArgumentException("Created date must not be null");
        this.createdDate = createdDate;
    }
    public Date getUpdatedDate() { return updatedDate; }
    public void setUpdatedDate(Date updatedDate) {
        if (updatedDate == null) throw new IllegalArgumentException("Updated date must not be null");
        this.updatedDate = updatedDate;
    }
}

// Airport class
class Airport extends Entity {
    private String airportName;
    private String code;
    private String location;

    public Airport(int id, Date createdDate, Date updatedDate, String airportName, String code, String location) {
        super(id, createdDate, updatedDate);
        if (code == null || !code.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("Code must be 3 uppercase letters");
        }
        this.airportName = airportName;
        this.code = code;
        this.location = location;
    }

    public String getAirportName() { return airportName; }
    public void setAirportName(String airportName) { this.airportName = airportName; }
    public String getCode() { return code; }
    public void setCode(String code) {
        if (code == null || !code.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("Code must be 3 uppercase letters");
        }
        this.code = code;
    }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}

// Airline class
class Airline extends Airport {
    private String airlineName;
    private String airlineCode;
    private String contactEmail;

    public Airline(int id, Date createdDate, Date updatedDate, String airportName, String code, String location,
                  String airlineName, String airlineCode, String contactEmail) {
        super(id, createdDate, updatedDate, airportName, code, location);
        if (airlineCode == null || airlineCode.length() < 2 || airlineCode.length() > 4) {
            throw new IllegalArgumentException("Airline code must be 2-4 letters");
        }
        if (contactEmail == null || !contactEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.airlineName = airlineName;
        this.airlineCode = airlineCode;
        this.contactEmail = contactEmail;
    }

    public String getAirlineName() { return airlineName; }
    public void setAirlineName(String airlineName) { this.airlineName = airlineName; }
    public String getAirlineCode() { return airlineCode; }
    public void setAirlineCode(String airlineCode) {
        if (airlineCode == null || airlineCode.length() < 2 || airlineCode.length() > 4) {
            throw new IllegalArgumentException("Airline code must be 2-4 letters");
        }
        this.airlineCode = airlineCode;
    }
    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) {
        if (contactEmail == null || !contactEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.contactEmail = contactEmail;
    }
}

// Flight class
class Flight extends Airline {
    private String flightNumber;
    private String departure;
    private String destination;
    private double baseFare;

    public Flight(int id, Date createdDate, Date updatedDate, String airportName, String code, String location,
                 String airlineName, String airlineCode, String contactEmail, String flightNumber,
                 String departure, String destination, double baseFare) {
        super(id, createdDate, updatedDate, airportName, code, location, airlineName, airlineCode, contactEmail);
        if (flightNumber == null || flightNumber.isEmpty()) throw new IllegalArgumentException("Flight number must not be empty");
        if (departure == null || departure.isEmpty()) throw new IllegalArgumentException("Departure must not be empty");
        if (destination == null || destination.isEmpty()) throw new IllegalArgumentException("Destination must not be empty");
        if (baseFare <= 0) throw new IllegalArgumentException("Base fare must be > 0");
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.baseFare = baseFare;
    }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) {
        if (flightNumber == null || flightNumber.isEmpty()) throw new IllegalArgumentException("Flight number must not be empty");
        this.flightNumber = flightNumber;
    }
    public String getDeparture() { return departure; }
    public void setDeparture(String departure) {
        if (departure == null || departure.isEmpty()) throw new IllegalArgumentException("Departure must not be empty");
        this.departure = departure;
    }
    public String getDestination() { return destination; }
    public void setDestination(String destination) {
        if (destination == null || destination.isEmpty()) throw new IllegalArgumentException("Destination must not be empty");
        this.destination = destination;
    }
    public double getBaseFare() { return baseFare; }
    public void setBaseFare(double baseFare) {
        if (baseFare <= 0) throw new IllegalArgumentException("Base fare must be > 0");
        this.baseFare = baseFare;
    }
}

// Pilot class
class Pilot extends Flight {
    private String pilotName;
    private String licenseNumber;
    private int experienceYears;

    public Pilot(int id, Date createdDate, Date updatedDate, String airportName, String code, String location,
                String airlineName, String airlineCode, String contactEmail, String flightNumber,
                String departure, String destination, double baseFare, String pilotName,
                String licenseNumber, int experienceYears) {
        super(id, createdDate, updatedDate, airportName, code, location, airlineName, airlineCode, contactEmail,
              flightNumber, departure, destination, baseFare);
        if (licenseNumber == null || licenseNumber.isEmpty()) throw new IllegalArgumentException("License number must not be empty");
        if (experienceYears < 2) throw new IllegalArgumentException("Experience years must be ≥ 2");
        this.pilotName = pilotName;
        this.licenseNumber = licenseNumber;
        this.experienceYears = experienceYears;
    }

    public String getPilotName() { return pilotName; }
    public void setPilotName(String pilotName) { this.pilotName = pilotName; }
    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) {
        if (licenseNumber == null || licenseNumber.isEmpty()) throw new IllegalArgumentException("License number must not be empty");
        this.licenseNumber = licenseNumber;
    }
    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 2) throw new IllegalArgumentException("Experience years must be ≥ 2");
        this.experienceYears = experienceYears;
    }
}

// CabinCrew class
class CabinCrew extends Pilot {
    private String crewName;
    private String role;
    private String shift;

    public CabinCrew(int id, Date createdDate, Date updatedDate, String airportName, String code, String location,
                    String airlineName, String airlineCode, String contactEmail, String flightNumber,
                    String departure, String destination, double baseFare, String pilotName,
                    String licenseNumber, int experienceYears, String crewName, String role, String shift) {
        super(id, createdDate, updatedDate, airportName, code, location, airlineName, airlineCode, contactEmail,
              flightNumber, departure, destination, baseFare, pilotName, licenseNumber, experienceYears);
        if (role == null || role.isEmpty()) throw new IllegalArgumentException("Role must not be empty");
        if (!shift.equals("Day") && !shift.equals("Night")) {
            throw new IllegalArgumentException("Shift must be 'Day' or 'Night'");
        }
        this.crewName = crewName;
        this.role = role;
        this.shift = shift;
    }

    public String getCrewName() { return crewName; }
    public void setCrewName(String crewName) { this.crewName = crewName; }
    public String getRole() { return role; }
    public void setRole(String role) {
        if (role == null || role.isEmpty()) throw new IllegalArgumentException("Role must not be empty");
        this.role = role;
    }
    public String getShift() { return shift; }
    public void setShift(String shift) {
        if (!shift.equals("Day") && !shift.equals("Night")) {
            throw new IllegalArgumentException("Shift must be 'Day' or 'Night'");
        }
        this.shift = shift;
    }
}

// Passenger class
class Passenger extends CabinCrew {
    private String passengerName;
    private int age;
    private String gender;
    private String contact;

    public Passenger(int id, Date createdDate, Date updatedDate, String airportName, String code, String location,
                    String airlineName, String airlineCode, String contactEmail, String flightNumber,
                    String departure, String destination, double baseFare, String pilotName,
                    String licenseNumber, int experienceYears, String crewName, String role, String shift,
                    String passengerName, int age, String gender, String contact) {
        super(id, createdDate, updatedDate, airportName, code, location, airlineName, airlineCode, contactEmail,
              flightNumber, departure, destination, baseFare, pilotName, licenseNumber, experienceYears,
              crewName, role, shift);
        if (age <= 0) throw new IllegalArgumentException("Age must be > 0");
        if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") && !gender.equalsIgnoreCase("Other")) {
            throw new IllegalArgumentException("Gender must be Male, Female, or Other");
        }
        this.passengerName = passengerName;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
    }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }
    public int getAge() { return age; }
    public void setAge(int age) {
        if (age <= 0) throw new IllegalArgumentException("Age must be > 0");
        this.age = age;
    }
    public String getGender() { return gender; }
    public void setGender(String gender) {
        if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") && !gender.equalsIgnoreCase("Other")) {
            throw new IllegalArgumentException("Gender must be Male, Female, or Other");
        }
        this.gender = gender;
    }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}

// Booking class
class Booking extends Passenger {
    private Date bookingDate;
    private String seatNumber;
    private String travelClass;

    public Booking(int id, Date createdDate, Date updatedDate, String airportName, String code, String location,
                  String airlineName, String airlineCode, String contactEmail, String flightNumber,
                  String departure, String destination, double baseFare, String pilotName,
                  String licenseNumber, int experienceYears, String crewName, String role, String shift,
                  String passengerName, int age, String gender, String contact, Date bookingDate,
                  String seatNumber, String travelClass) {
        super(id, createdDate, updatedDate, airportName, code, location, airlineName, airlineCode, contactEmail,
              flightNumber, departure, destination, baseFare, pilotName, licenseNumber, experienceYears,
              crewName, role, shift, passengerName, age, gender, contact);
        if (!travelClass.equals("Economy") && !travelClass.equals("Business") && !travelClass.equals("First")) {
            throw new IllegalArgumentException("Travel class must be Economy, Business, or First");
        }
        this.bookingDate = bookingDate;
        this.seatNumber = seatNumber;
        this.travelClass = travelClass;
    }

    public Date getBookingDate() { return bookingDate; }
    public void setBookingDate(Date bookingDate) { this.bookingDate = bookingDate; }
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
    public String getTravelClass() { return travelClass; }
    public void setTravelClass(String travelClass) {
        if (!travelClass.equals("Economy") && !travelClass.equals("Business") && !travelClass.equals("First")) {
            throw new IllegalArgumentException("Travel class must be Economy, Business, or First");
        }
        this.travelClass = travelClass;
    }
}

// Payment class
class Payment extends Booking {
    private Date paymentDate;
    private String paymentMethod;
    private double amountPaid;

    public Payment(int id, Date createdDate, Date updatedDate, String airportName, String code, String location,
                  String airlineName, String airlineCode, String contactEmail, String flightNumber,
                  String departure, String destination, double baseFare, String pilotName,
                  String licenseNumber, int experienceYears, String crewName, String role, String shift,
                  String passengerName, int age, String gender, String contact, Date bookingDate,
                  String seatNumber, String travelClass, Date paymentDate, String paymentMethod, double amountPaid) {
        super(id, createdDate, updatedDate, airportName, code, location, airlineName, airlineCode, contactEmail,
              flightNumber, departure, destination, baseFare, pilotName, licenseNumber, experienceYears,
              crewName, role, shift, passengerName, age, gender, contact, bookingDate, seatNumber, travelClass);
        if (paymentMethod == null || paymentMethod.isEmpty()) throw new IllegalArgumentException("Payment method must not be empty");
        if (amountPaid <= 0) throw new IllegalArgumentException("Amount paid must be > 0");
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
    }

    public Date getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) {
        if (paymentMethod == null || paymentMethod.isEmpty()) throw new IllegalArgumentException("Payment method must not be empty");
        this.paymentMethod = paymentMethod;
    }
    public double getAmountPaid() { return amountPaid; }
    public void setAmountPaid(double amountPaid) {
        if (amountPaid <= 0) throw new IllegalArgumentException("Amount paid must be > 0");
        this.amountPaid = amountPaid;
    }
}

// Ticket class (final)
final class Ticket extends Payment {
    private String ticketNumber;
    private Date issueDate;

    public Ticket(int id, Date createdDate, Date updatedDate, String airportName, String code, String location,
                 String airlineName, String airlineCode, String contactEmail, String flightNumber,
                 String departure, String destination, double baseFare, String pilotName,
                 String licenseNumber, int experienceYears, String crewName, String role, String shift,
                 String passengerName, int age, String gender, String contact, Date bookingDate,
                 String seatNumber, String travelClass, Date paymentDate, String paymentMethod, double amountPaid,
                 String ticketNumber, Date issueDate) {
        super(id, createdDate, updatedDate, airportName, code, location, airlineName, airlineCode, contactEmail,
              flightNumber, departure, destination, baseFare, pilotName, licenseNumber, experienceYears,
              crewName, role, shift, passengerName, age, gender, contact, bookingDate, seatNumber, travelClass,
              paymentDate, paymentMethod, amountPaid);
        this.ticketNumber = ticketNumber;
        this.issueDate = issueDate;
    }

    public String getTicketNumber() { return ticketNumber; }
    public void setTicketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; }
    public Date getIssueDate() { return issueDate; }
    public void setIssueDate(Date issueDate) { this.issueDate = issueDate; }

    public void calculateFare() {
        double taxes = getBaseFare() * 0.15; // 15% tax
        double discount = 0;
        if (getTravelClass().equals("Business")) discount = getBaseFare() * 0.05;
        else if (getTravelClass().equals("First")) discount = getBaseFare() * 0.10;
        
        double finalFare = getBaseFare() + taxes - discount;
        
        System.out.println("26711: \n========== TICKET FARE CALCULATION ==========");
        System.out.println("26711: Base Fare: $" + String.format("%.2f", getBaseFare()));
        System.out.println("26711: Taxes (15%): $" + String.format("%.2f", taxes));
        System.out.println("26711: Discount: $" + String.format("%.2f", discount));
        System.out.println("26711: Final Fare: $" + String.format("%.2f", finalFare));
        System.out.println("26711: =============================================\n");
    }
}

// Main class
public class FlightBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date now = new Date();

        System.out.println("26711: ========== FLIGHT BOOKING SYSTEM ==========");
        
        try {
            System.out.print("26711: Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("26711: Enter Airport Name: ");
            String airportName = scanner.nextLine();

            System.out.print("26711: Enter Airport Code (3 uppercase letters): ");
            String code = scanner.nextLine().toUpperCase();

            System.out.print("26711: Enter Location: ");
            String location = scanner.nextLine();

            System.out.print("26711: Enter Airline Name: ");
            String airlineName = scanner.nextLine();

            System.out.print("26711: Enter Airline Code (2-4 letters): ");
            String airlineCode = scanner.nextLine();

            System.out.print("26711: Enter Contact Email: ");
            String contactEmail = scanner.nextLine();

            System.out.print("26711: Enter Flight Number: ");
            String flightNumber = scanner.nextLine();

            System.out.print("26711: Enter Departure: ");
            String departure = scanner.nextLine();

            System.out.print("26711: Enter Destination: ");
            String destination = scanner.nextLine();

            System.out.print("26711: Enter Base Fare (>0): ");
            double baseFare = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("26711: Enter Pilot Name: ");
            String pilotName = scanner.nextLine();

            System.out.print("26711: Enter License Number: ");
            String licenseNumber = scanner.nextLine();

            System.out.print("26711: Enter Experience Years (≥2): ");
            int experienceYears = scanner.nextInt();
            scanner.nextLine();

            System.out.print("26711: Enter Crew Name: ");
            String crewName = scanner.nextLine();

            System.out.print("26711: Enter Role: ");
            String role = scanner.nextLine();

            System.out.print("26711: Enter Shift (Day/Night): ");
            String shift = scanner.nextLine();

            System.out.print("26711: Enter Passenger Name: ");
            String passengerName = scanner.nextLine();

            System.out.print("26711: Enter Age (>0): ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("26711: Enter Gender (Male/Female/Other): ");
            String gender = scanner.nextLine();

            System.out.print("26711: Enter Contact: ");
            String contact = scanner.nextLine();

            System.out.print("26711: Enter Seat Number: ");
            String seatNumber = scanner.nextLine();

            System.out.print("26711: Enter Travel Class (Economy/Business/First): ");
            String travelClass = scanner.nextLine();

            System.out.print("26711: Enter Payment Method: ");
            String paymentMethod = scanner.nextLine();

            System.out.print("26711: Enter Amount Paid (>0): ");
            double amountPaid = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("26711: Enter Ticket Number: ");
            String ticketNumber = scanner.nextLine();

            Ticket ticket = new Ticket(id, now, now, airportName, code, location, airlineName, airlineCode,
                contactEmail, flightNumber, departure, destination, baseFare, pilotName, licenseNumber,
                experienceYears, crewName, role, shift, passengerName, age, gender, contact, now,
                seatNumber, travelClass, now, paymentMethod, amountPaid, ticketNumber, now);

            System.out.println("26711: \n========== ALL INSERTED DATA ==========");
            System.out.println("26711: ID: " + ticket.getId());
            System.out.println("26711: Created Date: " + ticket.getCreatedDate());
            System.out.println("26711: Updated Date: " + ticket.getUpdatedDate());
            System.out.println("26711: Airport Name: " + ticket.getAirportName());
            System.out.println("26711: Airport Code: " + ticket.getCode());
            System.out.println("26711: Location: " + ticket.getLocation());
            System.out.println("26711: Airline Name: " + ticket.getAirlineName());
            System.out.println("26711: Airline Code: " + ticket.getAirlineCode());
            System.out.println("26711: Contact Email: " + ticket.getContactEmail());
            System.out.println("26711: Flight Number: " + ticket.getFlightNumber());
            System.out.println("26711: Departure: " + ticket.getDeparture());
            System.out.println("26711: Destination: " + ticket.getDestination());
            System.out.println("26711: Base Fare: $" + ticket.getBaseFare());
            System.out.println("26711: Pilot Name: " + ticket.getPilotName());
            System.out.println("26711: License Number: " + ticket.getLicenseNumber());
            System.out.println("26711: Experience Years: " + ticket.getExperienceYears());
            System.out.println("26711: Crew Name: " + ticket.getCrewName());
            System.out.println("26711: Role: " + ticket.getRole());
            System.out.println("26711: Shift: " + ticket.getShift());
            System.out.println("26711: Passenger Name: " + ticket.getPassengerName());
            System.out.println("26711: Age: " + ticket.getAge());
            System.out.println("26711: Gender: " + ticket.getGender());
            System.out.println("26711: Contact: " + ticket.getContact());
            System.out.println("26711: Booking Date: " + ticket.getBookingDate());
            System.out.println("26711: Seat Number: " + ticket.getSeatNumber());
            System.out.println("26711: Travel Class: " + ticket.getTravelClass());
            System.out.println("26711: Payment Date: " + ticket.getPaymentDate());
            System.out.println("26711: Payment Method: " + ticket.getPaymentMethod());
            System.out.println("26711: Amount Paid: $" + ticket.getAmountPaid());
            System.out.println("26711: Ticket Number: " + ticket.getTicketNumber());
            System.out.println("26711: Issue Date: " + ticket.getIssueDate());
            System.out.println("26711: ========================================\n");

            ticket.calculateFare();

        } catch (Exception e) {
            System.out.println("26711: Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

