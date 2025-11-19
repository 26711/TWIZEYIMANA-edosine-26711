package _26711.q6;

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

// Organization class
class Organization extends Entity {
    private String orgName;
    private String orgCode;
    private String rssbNumber;
    private String contactEmail;

    public Organization(int id, Date createdDate, Date updatedDate, String orgName, String orgCode,
                       String rssbNumber, String contactEmail) {
        super(id, createdDate, updatedDate);
        if (rssbNumber == null || !rssbNumber.matches("\\d{8}")) {
            throw new IllegalArgumentException("RSSB number must be 8 digits");
        }
        if (contactEmail == null || !contactEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (orgCode == null || orgCode.length() < 3) {
            throw new IllegalArgumentException("Org code must be ≥ 3 chars");
        }
        this.orgName = orgName;
        this.orgCode = orgCode;
        this.rssbNumber = rssbNumber;
        this.contactEmail = contactEmail;
    }

    public String getOrgName() { return orgName; }
    public void setOrgName(String orgName) { this.orgName = orgName; }
    public String getOrgCode() { return orgCode; }
    public void setOrgCode(String orgCode) {
        if (orgCode == null || orgCode.length() < 3) {
            throw new IllegalArgumentException("Org code must be ≥ 3 chars");
        }
        this.orgCode = orgCode;
    }
    public String getRssbNumber() { return rssbNumber; }
    public void setRssbNumber(String rssbNumber) {
        if (rssbNumber == null || !rssbNumber.matches("\\d{8}")) {
            throw new IllegalArgumentException("RSSB number must be 8 digits");
        }
        this.rssbNumber = rssbNumber;
    }
    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) {
        if (contactEmail == null || !contactEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.contactEmail = contactEmail;
    }
}

// Department class
class Department extends Organization {
    private String deptName;
    private String deptCode;
    private String managerName;

    public Department(int id, Date createdDate, Date updatedDate, String orgName, String orgCode,
                     String rssbNumber, String contactEmail, String deptName, String deptCode, String managerName) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail);
        if (deptCode == null || deptCode.length() < 3) {
            throw new IllegalArgumentException("Dept code must be ≥ 3 chars");
        }
        if (managerName == null || managerName.isEmpty()) {
            throw new IllegalArgumentException("Manager name must not be empty");
        }
        this.deptName = deptName;
        this.deptCode = deptCode;
        this.managerName = managerName;
    }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    public String getDeptCode() { return deptCode; }
    public void setDeptCode(String deptCode) {
        if (deptCode == null || deptCode.length() < 3) {
            throw new IllegalArgumentException("Dept code must be ≥ 3 chars");
        }
        this.deptCode = deptCode;
    }
    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) {
        if (managerName == null || managerName.isEmpty()) {
            throw new IllegalArgumentException("Manager name must not be empty");
        }
        this.managerName = managerName;
    }
}

// Employee class
class Employee extends Department {
    private String employeeID;
    private String fullName;
    private String position;
    private double baseSalary;
    private boolean rssbRegistered;

    public Employee(int id, Date createdDate, Date updatedDate, String orgName, String orgCode,
                   String rssbNumber, String contactEmail, String deptName, String deptCode, String managerName,
                   String employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName);
        if (employeeID == null || Integer.parseInt(employeeID) < 1000) {
            throw new IllegalArgumentException("Employee ID must be ≥ 1000");
        }
        if (baseSalary <= 0) throw new IllegalArgumentException("Base salary must be > 0");
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.position = position;
        this.baseSalary = baseSalary;
        this.rssbRegistered = rssbRegistered;
    }

    public String getEmployeeID() { return employeeID; }
    public void setEmployeeID(String employeeID) {
        if (employeeID == null || Integer.parseInt(employeeID) < 1000) {
            throw new IllegalArgumentException("Employee ID must be ≥ 1000");
        }
        this.employeeID = employeeID;
    }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        if (baseSalary <= 0) throw new IllegalArgumentException("Base salary must be > 0");
        this.baseSalary = baseSalary;
    }
    public boolean isRssbRegistered() { return rssbRegistered; }
    public void setRssbRegistered(boolean rssbRegistered) { this.rssbRegistered = rssbRegistered; }
}

// PayrollPeriod class
class PayrollPeriod extends Employee {
    private int month;
    private int year;
    private Date startDate;
    private Date endDate;

    public PayrollPeriod(int id, Date createdDate, Date updatedDate, String orgName, String orgCode,
                        String rssbNumber, String contactEmail, String deptName, String deptCode, String managerName,
                        String employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                        int month, int year, Date startDate, Date endDate) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName,
              employeeID, fullName, position, baseSalary, rssbRegistered);
        if (month < 1 || month > 12) throw new IllegalArgumentException("Month must be 1-12");
        if (year < 2000) throw new IllegalArgumentException("Year must be ≥ 2000");
        if (startDate == null || endDate == null) throw new IllegalArgumentException("Dates must not be null");
        this.month = month;
        this.year = year;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getMonth() { return month; }
    public void setMonth(int month) {
        if (month < 1 || month > 12) throw new IllegalArgumentException("Month must be 1-12");
        this.month = month;
    }
    public int getYear() { return year; }
    public void setYear(int year) {
        if (year < 2000) throw new IllegalArgumentException("Year must be ≥ 2000");
        this.year = year;
    }
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) {
        if (startDate == null) throw new IllegalArgumentException("Start date must not be null");
        this.startDate = startDate;
    }
    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) {
        if (endDate == null) throw new IllegalArgumentException("End date must not be null");
        this.endDate = endDate;
    }
}

// SalaryStructure class
class SalaryStructure extends PayrollPeriod {
    private double basicPay;
    private double transportAllowance;
    private double housingAllowance;

    public SalaryStructure(int id, Date createdDate, Date updatedDate, String orgName, String orgCode,
                          String rssbNumber, String contactEmail, String deptName, String deptCode, String managerName,
                          String employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                          int month, int year, Date startDate, Date endDate, double basicPay,
                          double transportAllowance, double housingAllowance) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName,
              employeeID, fullName, position, baseSalary, rssbRegistered, month, year, startDate, endDate);
        if (basicPay < 0) throw new IllegalArgumentException("Basic pay must be ≥ 0");
        if (transportAllowance < 0) throw new IllegalArgumentException("Transport allowance must be ≥ 0");
        if (housingAllowance < 0) throw new IllegalArgumentException("Housing allowance must be ≥ 0");
        this.basicPay = basicPay;
        this.transportAllowance = transportAllowance;
        this.housingAllowance = housingAllowance;
    }

    public double getBasicPay() { return basicPay; }
    public void setBasicPay(double basicPay) {
        if (basicPay < 0) throw new IllegalArgumentException("Basic pay must be ≥ 0");
        this.basicPay = basicPay;
    }
    public double getTransportAllowance() { return transportAllowance; }
    public void setTransportAllowance(double transportAllowance) {
        if (transportAllowance < 0) throw new IllegalArgumentException("Transport allowance must be ≥ 0");
        this.transportAllowance = transportAllowance;
    }
    public double getHousingAllowance() { return housingAllowance; }
    public void setHousingAllowance(double housingAllowance) {
        if (housingAllowance < 0) throw new IllegalArgumentException("Housing allowance must be ≥ 0");
        this.housingAllowance = housingAllowance;
    }
}

// Deduction class
class Deduction extends SalaryStructure {
    private double rssbContribution;
    private double payeTax;
    private double loanDeduction;

    public Deduction(int id, Date createdDate, Date updatedDate, String orgName, String orgCode,
                    String rssbNumber, String contactEmail, String deptName, String deptCode, String managerName,
                    String employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                    int month, int year, Date startDate, Date endDate, double basicPay,
                    double transportAllowance, double housingAllowance, double rssbContribution,
                    double payeTax, double loanDeduction) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName,
              employeeID, fullName, position, baseSalary, rssbRegistered, month, year, startDate, endDate,
              basicPay, transportAllowance, housingAllowance);
        if (rssbContribution < 0) throw new IllegalArgumentException("RSSB contribution must be ≥ 0");
        if (payeTax < 0) throw new IllegalArgumentException("PAYE tax must be ≥ 0");
        if (loanDeduction < 0) throw new IllegalArgumentException("Loan deduction must be ≥ 0");
        // RSSB contribution should be 5% of basicPay
        double expectedRSSB = basicPay * 0.05;
        if (Math.abs(rssbContribution - expectedRSSB) > 0.01) {
            System.out.println("26711: Warning: RSSB contribution should be 5% of basic pay (" + expectedRSSB + ")");
        }
        this.rssbContribution = rssbContribution;
        this.payeTax = payeTax;
        this.loanDeduction = loanDeduction;
    }

    public double getRssbContribution() { return rssbContribution; }
    public void setRssbContribution(double rssbContribution) {
        if (rssbContribution < 0) throw new IllegalArgumentException("RSSB contribution must be ≥ 0");
        this.rssbContribution = rssbContribution;
    }
    public double getPayeTax() { return payeTax; }
    public void setPayeTax(double payeTax) {
        if (payeTax < 0) throw new IllegalArgumentException("PAYE tax must be ≥ 0");
        this.payeTax = payeTax;
    }
    public double getLoanDeduction() { return loanDeduction; }
    public void setLoanDeduction(double loanDeduction) {
        if (loanDeduction < 0) throw new IllegalArgumentException("Loan deduction must be ≥ 0");
        this.loanDeduction = loanDeduction;
    }
}

// Allowance class
class Allowance extends Deduction {
    private double overtimeHours;
    private double overtimeRate;
    private double bonus;

    public Allowance(int id, Date createdDate, Date updatedDate, String orgName, String orgCode,
                    String rssbNumber, String contactEmail, String deptName, String deptCode, String managerName,
                    String employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                    int month, int year, Date startDate, Date endDate, double basicPay,
                    double transportAllowance, double housingAllowance, double rssbContribution,
                    double payeTax, double loanDeduction, double overtimeHours, double overtimeRate, double bonus) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName,
              employeeID, fullName, position, baseSalary, rssbRegistered, month, year, startDate, endDate,
              basicPay, transportAllowance, housingAllowance, rssbContribution, payeTax, loanDeduction);
        if (overtimeHours < 0) throw new IllegalArgumentException("Overtime hours must be ≥ 0");
        if (overtimeRate < 0) throw new IllegalArgumentException("Overtime rate must be ≥ 0");
        if (bonus < 0) throw new IllegalArgumentException("Bonus must be ≥ 0");
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
        this.bonus = bonus;
    }

    public double getOvertimeHours() { return overtimeHours; }
    public void setOvertimeHours(double overtimeHours) {
        if (overtimeHours < 0) throw new IllegalArgumentException("Overtime hours must be ≥ 0");
        this.overtimeHours = overtimeHours;
    }
    public double getOvertimeRate() { return overtimeRate; }
    public void setOvertimeRate(double overtimeRate) {
        if (overtimeRate < 0) throw new IllegalArgumentException("Overtime rate must be ≥ 0");
        this.overtimeRate = overtimeRate;
    }
    public double getBonus() { return bonus; }
    public void setBonus(double bonus) {
        if (bonus < 0) throw new IllegalArgumentException("Bonus must be ≥ 0");
        this.bonus = bonus;
    }
}

// Payroll class
class Payroll extends Allowance {
    private double grossSalary;
    private double totalDeductions;
    private double netSalary;

    public Payroll(int id, Date createdDate, Date updatedDate, String orgName, String orgCode,
                  String rssbNumber, String contactEmail, String deptName, String deptCode, String managerName,
                  String employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                  int month, int year, Date startDate, Date endDate, double basicPay,
                  double transportAllowance, double housingAllowance, double rssbContribution,
                  double payeTax, double loanDeduction, double overtimeHours, double overtimeRate, double bonus,
                  double grossSalary, double totalDeductions, double netSalary) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName,
              employeeID, fullName, position, baseSalary, rssbRegistered, month, year, startDate, endDate,
              basicPay, transportAllowance, housingAllowance, rssbContribution, payeTax, loanDeduction,
              overtimeHours, overtimeRate, bonus);
        // Calculate gross salary = basic + allowances
        double calculatedGross = basicPay + transportAllowance + housingAllowance + (overtimeHours * overtimeRate) + bonus;
        if (Math.abs(grossSalary - calculatedGross) > 0.01) {
            System.out.println("26711: Warning: Gross salary should be " + calculatedGross);
        }
        // Calculate net salary = gross - deductions
        double calculatedNet = grossSalary - totalDeductions;
        if (Math.abs(netSalary - calculatedNet) > 0.01) {
            System.out.println("26711: Warning: Net salary should be " + calculatedNet);
        }
        this.grossSalary = grossSalary;
        this.totalDeductions = totalDeductions;
        this.netSalary = netSalary;
    }

    public double getGrossSalary() { return grossSalary; }
    public void setGrossSalary(double grossSalary) { this.grossSalary = grossSalary; }
    public double getTotalDeductions() { return totalDeductions; }
    public void setTotalDeductions(double totalDeductions) { this.totalDeductions = totalDeductions; }
    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }
}

// Payslip class (final)
final class Payslip extends Payroll {
    private String payslipNumber;
    private Date issueDate;

    public Payslip(int id, Date createdDate, Date updatedDate, String orgName, String orgCode,
                  String rssbNumber, String contactEmail, String deptName, String deptCode, String managerName,
                  String employeeID, String fullName, String position, double baseSalary, boolean rssbRegistered,
                  int month, int year, Date startDate, Date endDate, double basicPay,
                  double transportAllowance, double housingAllowance, double rssbContribution,
                  double payeTax, double loanDeduction, double overtimeHours, double overtimeRate, double bonus,
                  double grossSalary, double totalDeductions, double netSalary, String payslipNumber, Date issueDate) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail, deptName, deptCode, managerName,
              employeeID, fullName, position, baseSalary, rssbRegistered, month, year, startDate, endDate,
              basicPay, transportAllowance, housingAllowance, rssbContribution, payeTax, loanDeduction,
              overtimeHours, overtimeRate, bonus, grossSalary, totalDeductions, netSalary);
        this.payslipNumber = payslipNumber;
        this.issueDate = issueDate;
    }

    public String getPayslipNumber() { return payslipNumber; }
    public void setPayslipNumber(String payslipNumber) { this.payslipNumber = payslipNumber; }
    public Date getIssueDate() { return issueDate; }
    public void setIssueDate(Date issueDate) { this.issueDate = issueDate; }

    public void generatePayslip() {
        double calculatedGross = getBasicPay() + getTransportAllowance() + getHousingAllowance() + 
                                (getOvertimeHours() * getOvertimeRate()) + getBonus();
        double calculatedDeductions = getRssbContribution() + getPayeTax() + getLoanDeduction();
        double calculatedNet = calculatedGross - calculatedDeductions;
        
        System.out.println("26711: \n========== PAYSLIP ==========");
        System.out.println("26711: Payslip Number: " + payslipNumber);
        System.out.println("26711: Issue Date: " + issueDate);
        System.out.println("26711: \n--- Employee Information ---");
        System.out.println("26711: Employee ID: " + getEmployeeID());
        System.out.println("26711: Full Name: " + getFullName());
        System.out.println("26711: Position: " + getPosition());
        System.out.println("26711: Department: " + getDeptName());
        System.out.println("26711: RSSB Registered: " + (isRssbRegistered() ? "Yes" : "No"));
        System.out.println("26711: \n--- Payroll Period ---");
        System.out.println("26711: Month: " + getMonth() + "/" + getYear());
        System.out.println("26711: Period: " + getStartDate() + " to " + getEndDate());
        System.out.println("26711: \n--- Earnings ---");
        System.out.println("26711: Basic Pay: $" + String.format("%.2f", getBasicPay()));
        System.out.println("26711: Transport Allowance: $" + String.format("%.2f", getTransportAllowance()));
        System.out.println("26711: Housing Allowance: $" + String.format("%.2f", getHousingAllowance()));
        System.out.println("26711: Overtime (" + getOvertimeHours() + " hrs @ $" + getOvertimeRate() + "/hr): $" + 
                          String.format("%.2f", getOvertimeHours() * getOvertimeRate()));
        System.out.println("26711: Bonus: $" + String.format("%.2f", getBonus()));
        System.out.println("26711: Gross Salary: $" + String.format("%.2f", calculatedGross));
        System.out.println("26711: \n--- Deductions ---");
        System.out.println("26711: RSSB Contribution (5%): $" + String.format("%.2f", getRssbContribution()));
        System.out.println("26711: PAYE Tax: $" + String.format("%.2f", getPayeTax()));
        System.out.println("26711: Loan Deduction: $" + String.format("%.2f", getLoanDeduction()));
        System.out.println("26711: Total Deductions: $" + String.format("%.2f", calculatedDeductions));
        System.out.println("26711: \n--- Net Salary ---");
        System.out.println("26711: Net Salary: $" + String.format("%.2f", calculatedNet));
        System.out.println("26711: ============================\n");
    }
}

// Main class
public class PayrollManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date now = new Date();

        System.out.println("26711: ========== PAYROLL MANAGEMENT SYSTEM (RSSB) ==========");
        
        try {
            System.out.print("26711: Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("26711: Enter Organization Name: ");
            String orgName = scanner.nextLine();

            System.out.print("26711: Enter Organization Code (≥3 chars): ");
            String orgCode = scanner.nextLine();

            System.out.print("26711: Enter RSSB Number (8 digits): ");
            String rssbNumber = scanner.nextLine();

            System.out.print("26711: Enter Contact Email: ");
            String contactEmail = scanner.nextLine();

            System.out.print("26711: Enter Department Name: ");
            String deptName = scanner.nextLine();

            System.out.print("26711: Enter Department Code (≥3 chars): ");
            String deptCode = scanner.nextLine();

            System.out.print("26711: Enter Manager Name: ");
            String managerName = scanner.nextLine();

            System.out.print("26711: Enter Employee ID (≥1000): ");
            String employeeID = scanner.nextLine();

            System.out.print("26711: Enter Full Name: ");
            String fullName = scanner.nextLine();

            System.out.print("26711: Enter Position: ");
            String position = scanner.nextLine();

            System.out.print("26711: Enter Base Salary (>0): ");
            double baseSalary = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("26711: Enter RSSB Registered (true/false): ");
            boolean rssbRegistered = scanner.nextBoolean();
            scanner.nextLine();

            System.out.print("26711: Enter Month (1-12): ");
            int month = scanner.nextInt();

            System.out.print("26711: Enter Year (≥2000): ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.print("26711: Enter Basic Pay (≥0): ");
            double basicPay = scanner.nextDouble();

            System.out.print("26711: Enter Transport Allowance (≥0): ");
            double transportAllowance = scanner.nextDouble();

            System.out.print("26711: Enter Housing Allowance (≥0): ");
            double housingAllowance = scanner.nextDouble();

            System.out.print("26711: Enter RSSB Contribution (≥0, should be 5% of basic pay): ");
            double rssbContribution = scanner.nextDouble();

            System.out.print("26711: Enter PAYE Tax (≥0): ");
            double payeTax = scanner.nextDouble();

            System.out.print("26711: Enter Loan Deduction (≥0): ");
            double loanDeduction = scanner.nextDouble();

            System.out.print("26711: Enter Overtime Hours (≥0): ");
            double overtimeHours = scanner.nextDouble();

            System.out.print("26711: Enter Overtime Rate (≥0): ");
            double overtimeRate = scanner.nextDouble();

            System.out.print("26711: Enter Bonus (≥0): ");
            double bonus = scanner.nextDouble();

            // Calculate gross and net
            double grossSalary = basicPay + transportAllowance + housingAllowance + (overtimeHours * overtimeRate) + bonus;
            double totalDeductions = rssbContribution + payeTax + loanDeduction;
            double netSalary = grossSalary - totalDeductions;

            scanner.nextLine(); // consume newline from previous double input
            System.out.print("26711: Enter Payslip Number: ");
            String payslipNumber = scanner.nextLine();

            Payslip payslip = new Payslip(id, now, now, orgName, orgCode, rssbNumber, contactEmail,
                deptName, deptCode, managerName, employeeID, fullName, position, baseSalary, rssbRegistered,
                month, year, now, now, basicPay, transportAllowance, housingAllowance, rssbContribution,
                payeTax, loanDeduction, overtimeHours, overtimeRate, bonus, grossSalary, totalDeductions,
                netSalary, payslipNumber, now);

            System.out.println("26711: \n========== ALL INSERTED DATA ==========");
            System.out.println("26711: ID: " + payslip.getId());
            System.out.println("26711: Created Date: " + payslip.getCreatedDate());
            System.out.println("26711: Updated Date: " + payslip.getUpdatedDate());
            System.out.println("26711: Organization Name: " + payslip.getOrgName());
            System.out.println("26711: Organization Code: " + payslip.getOrgCode());
            System.out.println("26711: RSSB Number: " + payslip.getRssbNumber());
            System.out.println("26711: Contact Email: " + payslip.getContactEmail());
            System.out.println("26711: Department Name: " + payslip.getDeptName());
            System.out.println("26711: Department Code: " + payslip.getDeptCode());
            System.out.println("26711: Manager Name: " + payslip.getManagerName());
            System.out.println("26711: Employee ID: " + payslip.getEmployeeID());
            System.out.println("26711: Full Name: " + payslip.getFullName());
            System.out.println("26711: Position: " + payslip.getPosition());
            System.out.println("26711: Base Salary: $" + payslip.getBaseSalary());
            System.out.println("26711: RSSB Registered: " + payslip.isRssbRegistered());
            System.out.println("26711: Month: " + payslip.getMonth());
            System.out.println("26711: Year: " + payslip.getYear());
            System.out.println("26711: Start Date: " + payslip.getStartDate());
            System.out.println("26711: End Date: " + payslip.getEndDate());
            System.out.println("26711: Basic Pay: $" + payslip.getBasicPay());
            System.out.println("26711: Transport Allowance: $" + payslip.getTransportAllowance());
            System.out.println("26711: Housing Allowance: $" + payslip.getHousingAllowance());
            System.out.println("26711: RSSB Contribution: $" + payslip.getRssbContribution());
            System.out.println("26711: PAYE Tax: $" + payslip.getPayeTax());
            System.out.println("26711: Loan Deduction: $" + payslip.getLoanDeduction());
            System.out.println("26711: Overtime Hours: " + payslip.getOvertimeHours());
            System.out.println("26711: Overtime Rate: $" + payslip.getOvertimeRate());
            System.out.println("26711: Bonus: $" + payslip.getBonus());
            System.out.println("26711: Gross Salary: $" + payslip.getGrossSalary());
            System.out.println("26711: Total Deductions: $" + payslip.getTotalDeductions());
            System.out.println("26711: Net Salary: $" + payslip.getNetSalary());
            System.out.println("26711: Payslip Number: " + payslip.getPayslipNumber());
            System.out.println("26711: Issue Date: " + payslip.getIssueDate());
            System.out.println("26711: ========================================\n");

            payslip.generatePayslip();

        } catch (Exception e) {
            System.out.println("26711: Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

