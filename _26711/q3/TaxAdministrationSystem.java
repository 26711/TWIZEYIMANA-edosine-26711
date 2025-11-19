package _26711.q3;

import java.util.Date;
import java.util.Scanner;

// Custom Exception
class TaxDataException extends Exception {
    public TaxDataException(String message) {
        super(message);
    }
}

// Base Entity class
class Entity {
    private int id;
    private Date createdDate;
    private Date updatedDate;

    public Entity(int id, Date createdDate, Date updatedDate) throws TaxDataException {
        if (id <= 0) throw new TaxDataException("ID must be > 0");
        if (createdDate == null || updatedDate == null) throw new TaxDataException("Dates must not be null");
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getId() { return id; }
    public void setId(int id) throws TaxDataException {
        if (id <= 0) throw new TaxDataException("ID must be > 0");
        this.id = id;
    }
    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) throws TaxDataException {
        if (createdDate == null) throw new TaxDataException("Created date must not be null");
        this.createdDate = createdDate;
    }
    public Date getUpdatedDate() { return updatedDate; }
    public void setUpdatedDate(Date updatedDate) throws TaxDataException {
        if (updatedDate == null) throw new TaxDataException("Updated date must not be null");
        this.updatedDate = updatedDate;
    }
}

// TaxAuthority class
class TaxAuthority extends Entity {
    private String authorityName;
    private String region;
    private String email;

    public TaxAuthority(int id, Date createdDate, Date updatedDate, String authorityName, String region, String email) throws TaxDataException {
        super(id, createdDate, updatedDate);
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new TaxDataException("Invalid email format");
        }
        this.authorityName = authorityName;
        this.region = region;
        this.email = email;
    }

    public String getAuthorityName() { return authorityName; }
    public void setAuthorityName(String authorityName) { this.authorityName = authorityName; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public String getEmail() { return email; }
    public void setEmail(String email) throws TaxDataException {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new TaxDataException("Invalid email format");
        }
        this.email = email;
    }
}

// TaxCategory class
class TaxCategory extends TaxAuthority {
    private String categoryName;
    private double rate;
    private String code;

    public TaxCategory(int id, Date createdDate, Date updatedDate, String authorityName, String region, String email,
                      String categoryName, double rate, String code) throws TaxDataException {
        super(id, createdDate, updatedDate, authorityName, region, email);
        if (rate <= 0) throw new TaxDataException("Rate must be > 0");
        if (code == null || code.length() < 3) throw new TaxDataException("Code must be ≥ 3 chars");
        this.categoryName = categoryName;
        this.rate = rate;
        this.code = code;
    }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public double getRate() { return rate; }
    public void setRate(double rate) throws TaxDataException {
        if (rate <= 0) throw new TaxDataException("Rate must be > 0");
        this.rate = rate;
    }
    public String getCode() { return code; }
    public void setCode(String code) throws TaxDataException {
        if (code == null || code.length() < 3) throw new TaxDataException("Code must be ≥ 3 chars");
        this.code = code;
    }
}

// Taxpayer class
class Taxpayer extends TaxCategory {
    private String tin;
    private String taxpayerName;
    private String address;

    public Taxpayer(int id, Date createdDate, Date updatedDate, String authorityName, String region, String email,
                   String categoryName, double rate, String code, String tin, String taxpayerName, String address) throws TaxDataException {
        super(id, createdDate, updatedDate, authorityName, region, email, categoryName, rate, code);
        if (tin == null || !tin.matches("\\d{9}")) throw new TaxDataException("TIN must be 9 digits");
        if (taxpayerName == null || taxpayerName.isEmpty()) throw new TaxDataException("Taxpayer name must not be empty");
        this.tin = tin;
        this.taxpayerName = taxpayerName;
        this.address = address;
    }

    public String getTin() { return tin; }
    public void setTin(String tin) throws TaxDataException {
        if (tin == null || !tin.matches("\\d{9}")) throw new TaxDataException("TIN must be 9 digits");
        this.tin = tin;
    }
    public String getTaxpayerName() { return taxpayerName; }
    public void setTaxpayerName(String taxpayerName) throws TaxDataException {
        if (taxpayerName == null || taxpayerName.isEmpty()) throw new TaxDataException("Taxpayer name must not be empty");
        this.taxpayerName = taxpayerName;
    }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}

// Employer class
class Employer extends Taxpayer {
    private String employerName;
    private String employerTIN;
    private String contact;

    public Employer(int id, Date createdDate, Date updatedDate, String authorityName, String region, String email,
                   String categoryName, double rate, String code, String tin, String taxpayerName, String address,
                   String employerName, String employerTIN, String contact) throws TaxDataException {
        super(id, createdDate, updatedDate, authorityName, region, email, categoryName, rate, code, tin, taxpayerName, address);
        if (employerTIN == null || !employerTIN.matches("\\d{9}")) throw new TaxDataException("Employer TIN must be 9 digits");
        if (contact == null || !contact.matches("\\d{10}")) throw new TaxDataException("Contact must be 10 digits");
        this.employerName = employerName;
        this.employerTIN = employerTIN;
        this.contact = contact;
    }

    public String getEmployerName() { return employerName; }
    public void setEmployerName(String employerName) { this.employerName = employerName; }
    public String getEmployerTIN() { return employerTIN; }
    public void setEmployerTIN(String employerTIN) throws TaxDataException {
        if (employerTIN == null || !employerTIN.matches("\\d{9}")) throw new TaxDataException("Employer TIN must be 9 digits");
        this.employerTIN = employerTIN;
    }
    public String getContact() { return contact; }
    public void setContact(String contact) throws TaxDataException {
        if (contact == null || !contact.matches("\\d{10}")) throw new TaxDataException("Contact must be 10 digits");
        this.contact = contact;
    }
}

// Employee class
class Employee extends Employer {
    private String employeeName;
    private double salary;
    private String employeeTIN;

    public Employee(int id, Date createdDate, Date updatedDate, String authorityName, String region, String email,
                   String categoryName, double rate, String code, String tin, String taxpayerName, String address,
                   String employerName, String employerTIN, String contact, String employeeName, double salary, String employeeTIN2) throws TaxDataException {
        super(id, createdDate, updatedDate, authorityName, region, email, categoryName, rate, code, tin, taxpayerName, address,
              employerName, employerTIN, contact);
        if (salary <= 0) throw new TaxDataException("Salary must be > 0");
        if (employeeTIN2 == null || !employeeTIN2.matches("\\d{9}")) throw new TaxDataException("Employee TIN must be 9 digits");
        this.employeeName = employeeName;
        this.salary = salary;
        this.employeeTIN = employeeTIN2;
    }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) throws TaxDataException {
        if (salary <= 0) throw new TaxDataException("Salary must be > 0");
        this.salary = salary;
    }
    public String getEmployeeTIN() { return employeeTIN; }
    public void setEmployeeTIN(String employeeTIN) throws TaxDataException {
        if (employeeTIN == null || !employeeTIN.matches("\\d{9}")) throw new TaxDataException("Employee TIN must be 9 digits");
        this.employeeTIN = employeeTIN;
    }
}

// TaxDeclaration class
class TaxDeclaration extends Employee {
    private String declarationMonth;
    private double totalIncome;

    public TaxDeclaration(int id, Date createdDate, Date updatedDate, String authorityName, String region, String email,
                         String categoryName, double rate, String code, String tin, String taxpayerName, String address,
                         String employerName, String employerTIN, String contact, String employeeName, double salary, String employeeTIN2,
                         String declarationMonth, double totalIncome) throws TaxDataException {
        super(id, createdDate, updatedDate, authorityName, region, email, categoryName, rate, code, tin, taxpayerName, address,
              employerName, employerTIN, contact, employeeName, salary, employeeTIN2);
        if (totalIncome < 0) throw new TaxDataException("Total income must be ≥ 0");
        this.declarationMonth = declarationMonth;
        this.totalIncome = totalIncome;
    }

    public String getDeclarationMonth() { return declarationMonth; }
    public void setDeclarationMonth(String declarationMonth) { this.declarationMonth = declarationMonth; }
    public double getTotalIncome() { return totalIncome; }
    public void setTotalIncome(double totalIncome) throws TaxDataException {
        if (totalIncome < 0) throw new TaxDataException("Total income must be ≥ 0");
        this.totalIncome = totalIncome;
    }
}

// TaxAssessment class
class TaxAssessment extends TaxDeclaration {
    private Date assessmentDate;
    private double assessedTax;

    public TaxAssessment(int id, Date createdDate, Date updatedDate, String authorityName, String region, String email,
                        String categoryName, double rate, String code, String tin, String taxpayerName, String address,
                        String employerName, String employerTIN, String contact, String employeeName, double salary, String employeeTIN2,
                        String declarationMonth, double totalIncome, Date assessmentDate, double assessedTax) throws TaxDataException {
        super(id, createdDate, updatedDate, authorityName, region, email, categoryName, rate, code, tin, taxpayerName, address,
              employerName, employerTIN, contact, employeeName, salary, employeeTIN2, declarationMonth, totalIncome);
        if (assessedTax < 0) throw new TaxDataException("Assessed tax must be ≥ 0");
        this.assessmentDate = assessmentDate;
        this.assessedTax = assessedTax;
    }

    public Date getAssessmentDate() { return assessmentDate; }
    public void setAssessmentDate(Date assessmentDate) { this.assessmentDate = assessmentDate; }
    public double getAssessedTax() { return assessedTax; }
    public void setAssessedTax(double assessedTax) throws TaxDataException {
        if (assessedTax < 0) throw new TaxDataException("Assessed tax must be ≥ 0");
        this.assessedTax = assessedTax;
    }
}

// Payment class
class Payment extends TaxAssessment {
    private Date paymentDate;
    private double paymentAmount;

    public Payment(int id, Date createdDate, Date updatedDate, String authorityName, String region, String email,
                  String categoryName, double rate, String code, String tin, String taxpayerName, String address,
                  String employerName, String employerTIN, String contact, String employeeName, double salary, String employeeTIN2,
                  String declarationMonth, double totalIncome, Date assessmentDate, double assessedTax,
                  Date paymentDate, double paymentAmount) throws TaxDataException {
        super(id, createdDate, updatedDate, authorityName, region, email, categoryName, rate, code, tin, taxpayerName, address,
              employerName, employerTIN, contact, employeeName, salary, employeeTIN2, declarationMonth, totalIncome,
              assessmentDate, assessedTax);
        if (paymentAmount <= 0) throw new TaxDataException("Payment amount must be > 0");
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }
    public double getPaymentAmount() { return paymentAmount; }
    public void setPaymentAmount(double paymentAmount) throws TaxDataException {
        if (paymentAmount <= 0) throw new TaxDataException("Payment amount must be > 0");
        this.paymentAmount = paymentAmount;
    }
}

// TaxRecord class (final)
final class TaxRecord extends Payment {
    private String receiptNo;
    private double totalTax;

    public TaxRecord(int id, Date createdDate, Date updatedDate, String authorityName, String region, String email,
                    String categoryName, double rate, String code, String tin, String taxpayerName, String address,
                    String employerName, String employerTIN, String contact, String employeeName, double salary, String employeeTIN2,
                    String declarationMonth, double totalIncome, Date assessmentDate, double assessedTax,
                    Date paymentDate, double paymentAmount, String receiptNo, double totalTax) throws TaxDataException {
        super(id, createdDate, updatedDate, authorityName, region, email, categoryName, rate, code, tin, taxpayerName, address,
              employerName, employerTIN, contact, employeeName, salary, employeeTIN2, declarationMonth, totalIncome,
              assessmentDate, assessedTax, paymentDate, paymentAmount);
        this.receiptNo = receiptNo;
        this.totalTax = totalTax;
    }

    public String getReceiptNo() { return receiptNo; }
    public void setReceiptNo(String receiptNo) { this.receiptNo = receiptNo; }
    public double getTotalTax() { return totalTax; }
    public void setTotalTax(double totalTax) { this.totalTax = totalTax; }

    public void computeTax() {
        double credits = 50000; // Example credit amount
        double computedTax = (getSalary() * getRate()) - credits;
        if (computedTax < 0) computedTax = 0;
        
        System.out.println("26711: \n========== TAX COMPUTATION ==========");
        System.out.println("26711: Salary: $" + String.format("%.2f", getSalary()));
        System.out.println("26711: Tax Rate: " + (getRate() * 100) + "%");
        System.out.println("26711: Tax Before Credits: $" + String.format("%.2f", getSalary() * getRate()));
        System.out.println("26711: Credits: $" + String.format("%.2f", credits));
        System.out.println("26711: Computed Tax: $" + String.format("%.2f", computedTax));
        System.out.println("26711: Total Tax: $" + String.format("%.2f", getTotalTax()));
        System.out.println("26711: =====================================\n");
    }
}

// Main class
public class TaxAdministrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date now = new Date();

        System.out.println("26711: ========== TAX ADMINISTRATION SYSTEM ==========");
        
        try {
            System.out.print("26711: Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("26711: Enter Authority Name: ");
            String authorityName = scanner.nextLine();

            System.out.print("26711: Enter Region: ");
            String region = scanner.nextLine();

            System.out.print("26711: Enter Email: ");
            String email = scanner.nextLine();

            System.out.print("26711: Enter Category Name: ");
            String categoryName = scanner.nextLine();

            System.out.print("26711: Enter Tax Rate (>0): ");
            double rate = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("26711: Enter Code (≥3 chars): ");
            String code = scanner.nextLine();

            System.out.print("26711: Enter TIN (9 digits): ");
            String tin = scanner.nextLine();

            System.out.print("26711: Enter Taxpayer Name: ");
            String taxpayerName = scanner.nextLine();

            System.out.print("26711: Enter Address: ");
            String address = scanner.nextLine();

            System.out.print("26711: Enter Employer Name: ");
            String employerName = scanner.nextLine();

            System.out.print("26711: Enter Employer TIN (9 digits): ");
            String employerTIN = scanner.nextLine();

            System.out.print("26711: Enter Contact (10 digits): ");
            String contact = scanner.nextLine();

            System.out.print("26711: Enter Employee Name: ");
            String employeeName = scanner.nextLine();

            System.out.print("26711: Enter Salary (>0): ");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("26711: Enter Employee TIN (9 digits): ");
            String employeeTIN = scanner.nextLine();

            System.out.print("26711: Enter Declaration Month: ");
            String declarationMonth = scanner.nextLine();

            System.out.print("26711: Enter Total Income (≥0): ");
            double totalIncome = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("26711: Enter Assessed Tax (≥0): ");
            double assessedTax = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("26711: Enter Payment Amount (>0): ");
            double paymentAmount = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("26711: Enter Receipt Number: ");
            String receiptNo = scanner.nextLine();

            System.out.print("26711: Enter Total Tax: ");
            double totalTax = scanner.nextDouble();
            scanner.nextLine();

            TaxRecord record = new TaxRecord(id, now, now, authorityName, region, email, categoryName, rate, code,
                tin, taxpayerName, address, employerName, employerTIN, contact, employeeName, salary, employeeTIN,
                declarationMonth, totalIncome, now, assessedTax, now, paymentAmount, receiptNo, totalTax);

            System.out.println("26711: \n========== ALL INSERTED DATA ==========");
            System.out.println("26711: ID: " + record.getId());
            System.out.println("26711: Created Date: " + record.getCreatedDate());
            System.out.println("26711: Updated Date: " + record.getUpdatedDate());
            System.out.println("26711: Authority Name: " + record.getAuthorityName());
            System.out.println("26711: Region: " + record.getRegion());
            System.out.println("26711: Email: " + record.getEmail());
            System.out.println("26711: Category Name: " + record.getCategoryName());
            System.out.println("26711: Rate: " + record.getRate());
            System.out.println("26711: Code: " + record.getCode());
            System.out.println("26711: TIN: " + record.getTin());
            System.out.println("26711: Taxpayer Name: " + record.getTaxpayerName());
            System.out.println("26711: Address: " + record.getAddress());
            System.out.println("26711: Employer Name: " + record.getEmployerName());
            System.out.println("26711: Employer TIN: " + record.getEmployerTIN());
            System.out.println("26711: Contact: " + record.getContact());
            System.out.println("26711: Employee Name: " + record.getEmployeeName());
            System.out.println("26711: Salary: $" + record.getSalary());
            System.out.println("26711: Employee TIN: " + record.getEmployeeTIN());
            System.out.println("26711: Declaration Month: " + record.getDeclarationMonth());
            System.out.println("26711: Total Income: $" + record.getTotalIncome());
            System.out.println("26711: Assessment Date: " + record.getAssessmentDate());
            System.out.println("26711: Assessed Tax: $" + record.getAssessedTax());
            System.out.println("26711: Payment Date: " + record.getPaymentDate());
            System.out.println("26711: Payment Amount: $" + record.getPaymentAmount());
            System.out.println("26711: Receipt No: " + record.getReceiptNo());
            System.out.println("26711: Total Tax: $" + record.getTotalTax());
            System.out.println("26711: ========================================\n");

            record.computeTax();

        } catch (TaxDataException e) {
            System.out.println("26711: Tax Data Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("26711: Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

