package _26711.q4;

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
    private String address;
    private String contactEmail;

    public Organization(int id, Date createdDate, Date updatedDate, String orgName, String address, String contactEmail) {
        super(id, createdDate, updatedDate);
        if (contactEmail == null || !contactEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.orgName = orgName;
        this.address = address;
        this.contactEmail = contactEmail;
    }

    public String getOrgName() { return orgName; }
    public void setOrgName(String orgName) { this.orgName = orgName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
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

    public Department(int id, Date createdDate, Date updatedDate, String orgName, String address, String contactEmail,
                    String deptName, String deptCode) {
        super(id, createdDate, updatedDate, orgName, address, contactEmail);
        if (deptCode == null || deptCode.length() < 3 || !deptCode.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException("Dept code must be alphanumeric and ≥ 3 chars");
        }
        this.deptName = deptName;
        this.deptCode = deptCode;
    }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    public String getDeptCode() { return deptCode; }
    public void setDeptCode(String deptCode) {
        if (deptCode == null || deptCode.length() < 3 || !deptCode.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException("Dept code must be alphanumeric and ≥ 3 chars");
        }
        this.deptCode = deptCode;
    }
}

// Supplier class
class Supplier extends Department {
    private String supplierName;
    private String supplierTIN;
    private String contact;

    public Supplier(int id, Date createdDate, Date updatedDate, String orgName, String address, String contactEmail,
                   String deptName, String deptCode, String supplierName, String supplierTIN, String contact) {
        super(id, createdDate, updatedDate, orgName, address, contactEmail, deptName, deptCode);
        if (supplierTIN == null || !supplierTIN.matches("\\d{9}")) throw new IllegalArgumentException("Supplier TIN must be 9 digits");
        if (contact == null || !contact.matches("\\d{10}")) throw new IllegalArgumentException("Contact must be 10 digits");
        this.supplierName = supplierName;
        this.supplierTIN = supplierTIN;
        this.contact = contact;
    }

    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }
    public String getSupplierTIN() { return supplierTIN; }
    public void setSupplierTIN(String supplierTIN) {
        if (supplierTIN == null || !supplierTIN.matches("\\d{9}")) throw new IllegalArgumentException("Supplier TIN must be 9 digits");
        this.supplierTIN = supplierTIN;
    }
    public String getContact() { return contact; }
    public void setContact(String contact) {
        if (contact == null || !contact.matches("\\d{10}")) throw new IllegalArgumentException("Contact must be 10 digits");
        this.contact = contact;
    }
}

// Product class
class Product extends Supplier {
    private String productName;
    private double unitPrice;
    private int quantity;

    public Product(int id, Date createdDate, Date updatedDate, String orgName, String address, String contactEmail,
                  String deptName, String deptCode, String supplierName, String supplierTIN, String contact,
                  String productName, double unitPrice, int quantity) {
        super(id, createdDate, updatedDate, orgName, address, contactEmail, deptName, deptCode, supplierName, supplierTIN, contact);
        if (unitPrice <= 0) throw new IllegalArgumentException("Unit price must be > 0");
        if (quantity < 0) throw new IllegalArgumentException("Quantity must be ≥ 0");
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) {
        if (unitPrice <= 0) throw new IllegalArgumentException("Unit price must be > 0");
        this.unitPrice = unitPrice;
    }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity must be ≥ 0");
        this.quantity = quantity;
    }
}

// PurchaseOrder class
class PurchaseOrder extends Product {
    private String poNumber;
    private Date orderDate;
    private double totalAmount;

    public PurchaseOrder(int id, Date createdDate, Date updatedDate, String orgName, String address, String contactEmail,
                        String deptName, String deptCode, String supplierName, String supplierTIN, String contact,
                        String productName, double unitPrice, int quantity, String poNumber, Date orderDate, double totalAmount) {
        super(id, createdDate, updatedDate, orgName, address, contactEmail, deptName, deptCode, supplierName, supplierTIN, contact,
              productName, unitPrice, quantity);
        if (totalAmount <= 0) throw new IllegalArgumentException("Total amount must be > 0");
        this.poNumber = poNumber;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public String getPoNumber() { return poNumber; }
    public void setPoNumber(String poNumber) { this.poNumber = poNumber; }
    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) {
        if (totalAmount <= 0) throw new IllegalArgumentException("Total amount must be > 0");
        this.totalAmount = totalAmount;
    }
}

// Delivery class
class Delivery extends PurchaseOrder {
    private Date deliveryDate;
    private String deliveredBy;

    public Delivery(int id, Date createdDate, Date updatedDate, String orgName, String address, String contactEmail,
                   String deptName, String deptCode, String supplierName, String supplierTIN, String contact,
                   String productName, double unitPrice, int quantity, String poNumber, Date orderDate, double totalAmount,
                   Date deliveryDate, String deliveredBy) {
        super(id, createdDate, updatedDate, orgName, address, contactEmail, deptName, deptCode, supplierName, supplierTIN, contact,
              productName, unitPrice, quantity, poNumber, orderDate, totalAmount);
        if (deliveryDate == null) throw new IllegalArgumentException("Delivery date must not be null");
        if (deliveredBy == null) throw new IllegalArgumentException("Delivered by must not be null");
        this.deliveryDate = deliveryDate;
        this.deliveredBy = deliveredBy;
    }

    public Date getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(Date deliveryDate) {
        if (deliveryDate == null) throw new IllegalArgumentException("Delivery date must not be null");
        this.deliveryDate = deliveryDate;
    }
    public String getDeliveredBy() { return deliveredBy; }
    public void setDeliveredBy(String deliveredBy) {
        if (deliveredBy == null) throw new IllegalArgumentException("Delivered by must not be null");
        this.deliveredBy = deliveredBy;
    }
}

// Inspection class
class Inspection extends Delivery {
    private String inspectorName;
    private String status;
    private String remarks;

    public Inspection(int id, Date createdDate, Date updatedDate, String orgName, String address, String contactEmail,
                     String deptName, String deptCode, String supplierName, String supplierTIN, String contact,
                     String productName, double unitPrice, int quantity, String poNumber, Date orderDate, double totalAmount,
                     Date deliveryDate, String deliveredBy, String inspectorName, String status, String remarks) {
        super(id, createdDate, updatedDate, orgName, address, contactEmail, deptName, deptCode, supplierName, supplierTIN, contact,
              productName, unitPrice, quantity, poNumber, orderDate, totalAmount, deliveryDate, deliveredBy);
        if (!status.equals("Passed") && !status.equals("Failed")) {
            throw new IllegalArgumentException("Status must be 'Passed' or 'Failed'");
        }
        this.inspectorName = inspectorName;
        this.status = status;
        this.remarks = remarks;
    }

    public String getInspectorName() { return inspectorName; }
    public void setInspectorName(String inspectorName) { this.inspectorName = inspectorName; }
    public String getStatus() { return status; }
    public void setStatus(String status) {
        if (!status.equals("Passed") && !status.equals("Failed")) {
            throw new IllegalArgumentException("Status must be 'Passed' or 'Failed'");
        }
        this.status = status;
    }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}

// Invoice class
class Invoice extends Inspection {
    private String invoiceNo;
    private double invoiceAmount;

    public Invoice(int id, Date createdDate, Date updatedDate, String orgName, String address, String contactEmail,
                  String deptName, String deptCode, String supplierName, String supplierTIN, String contact,
                  String productName, double unitPrice, int quantity, String poNumber, Date orderDate, double totalAmount,
                  Date deliveryDate, String deliveredBy, String inspectorName, String status, String remarks,
                  String invoiceNo, double invoiceAmount) {
        super(id, createdDate, updatedDate, orgName, address, contactEmail, deptName, deptCode, supplierName, supplierTIN, contact,
              productName, unitPrice, quantity, poNumber, orderDate, totalAmount, deliveryDate, deliveredBy, inspectorName, status, remarks);
        if (invoiceAmount <= 0) throw new IllegalArgumentException("Invoice amount must be > 0");
        this.invoiceNo = invoiceNo;
        this.invoiceAmount = invoiceAmount;
    }

    public String getInvoiceNo() { return invoiceNo; }
    public void setInvoiceNo(String invoiceNo) { this.invoiceNo = invoiceNo; }
    public double getInvoiceAmount() { return invoiceAmount; }
    public void setInvoiceAmount(double invoiceAmount) {
        if (invoiceAmount <= 0) throw new IllegalArgumentException("Invoice amount must be > 0");
        this.invoiceAmount = invoiceAmount;
    }
}

// ProcurementReport class (final)
final class ProcurementReport extends Invoice {
    private Date reportDate;
    private String summary;

    public ProcurementReport(int id, Date createdDate, Date updatedDate, String orgName, String address, String contactEmail,
                            String deptName, String deptCode, String supplierName, String supplierTIN, String contact,
                            String productName, double unitPrice, int quantity, String poNumber, Date orderDate, double totalAmount,
                            Date deliveryDate, String deliveredBy, String inspectorName, String status, String remarks,
                            String invoiceNo, double invoiceAmount, Date reportDate, String summary) {
        super(id, createdDate, updatedDate, orgName, address, contactEmail, deptName, deptCode, supplierName, supplierTIN, contact,
              productName, unitPrice, quantity, poNumber, orderDate, totalAmount, deliveryDate, deliveredBy, inspectorName, status, remarks,
              invoiceNo, invoiceAmount);
        this.reportDate = reportDate;
        this.summary = summary;
    }

    public Date getReportDate() { return reportDate; }
    public void setReportDate(Date reportDate) { this.reportDate = reportDate; }
    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public void calculateTotal() {
        double total = getInvoiceAmount();
        
        System.out.println("26711: \n========== PROCUREMENT REPORT ==========");
        System.out.println("26711: Report Date: " + reportDate);
        System.out.println("26711: Summary: " + summary);
        System.out.println("26711: \n--- Total Calculation ---");
        System.out.println("26711: Invoice Amount: $" + String.format("%.2f", getInvoiceAmount()));
        System.out.println("26711: Total Procurement Amount: $" + String.format("%.2f", total));
        System.out.println("26711: ========================================\n");
    }
}

// Main class
public class ProcurementManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date now = new Date();

        System.out.println("26711: ========== PROCUREMENT MANAGEMENT SYSTEM ==========");
        
        try {
            System.out.print("26711: Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("26711: Enter Organization Name: ");
            String orgName = scanner.nextLine();

            System.out.print("26711: Enter Address: ");
            String address = scanner.nextLine();

            System.out.print("26711: Enter Contact Email: ");
            String contactEmail = scanner.nextLine();

            System.out.print("26711: Enter Department Name: ");
            String deptName = scanner.nextLine();

            System.out.print("26711: Enter Department Code (≥3 alphanumeric): ");
            String deptCode = scanner.nextLine();

            System.out.print("26711: Enter Supplier Name: ");
            String supplierName = scanner.nextLine();

            System.out.print("26711: Enter Supplier TIN (9 digits): ");
            String supplierTIN = scanner.nextLine();

            System.out.print("26711: Enter Contact (10 digits): ");
            String contact = scanner.nextLine();

            System.out.print("26711: Enter Product Name: ");
            String productName = scanner.nextLine();

            System.out.print("26711: Enter Unit Price (>0): ");
            double unitPrice = scanner.nextDouble();

            System.out.print("26711: Enter Quantity (≥0): ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            System.out.print("26711: Enter PO Number: ");
            String poNumber = scanner.nextLine();

            System.out.print("26711: Enter Total Amount (>0): ");
            double totalAmount = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("26711: Enter Delivered By: ");
            String deliveredBy = scanner.nextLine();

            System.out.print("26711: Enter Inspector Name: ");
            String inspectorName = scanner.nextLine();

            System.out.print("26711: Enter Status (Passed/Failed): ");
            String status = scanner.nextLine();

            System.out.print("26711: Enter Remarks: ");
            String remarks = scanner.nextLine();

            System.out.print("26711: Enter Invoice Number: ");
            String invoiceNo = scanner.nextLine();

            System.out.print("26711: Enter Invoice Amount (>0): ");
            double invoiceAmount = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("26711: Enter Summary: ");
            String summary = scanner.nextLine();

            ProcurementReport report = new ProcurementReport(id, now, now, orgName, address, contactEmail,
                deptName, deptCode, supplierName, supplierTIN, contact, productName, unitPrice, quantity,
                poNumber, now, totalAmount, now, deliveredBy, inspectorName, status, remarks, invoiceNo,
                invoiceAmount, now, summary);

            System.out.println("26711: \n========== ALL INSERTED DATA ==========");
            System.out.println("26711: ID: " + report.getId());
            System.out.println("26711: Created Date: " + report.getCreatedDate());
            System.out.println("26711: Updated Date: " + report.getUpdatedDate());
            System.out.println("26711: Organization Name: " + report.getOrgName());
            System.out.println("26711: Address: " + report.getAddress());
            System.out.println("26711: Contact Email: " + report.getContactEmail());
            System.out.println("26711: Department Name: " + report.getDeptName());
            System.out.println("26711: Department Code: " + report.getDeptCode());
            System.out.println("26711: Supplier Name: " + report.getSupplierName());
            System.out.println("26711: Supplier TIN: " + report.getSupplierTIN());
            System.out.println("26711: Contact: " + report.getContact());
            System.out.println("26711: Product Name: " + report.getProductName());
            System.out.println("26711: Unit Price: $" + report.getUnitPrice());
            System.out.println("26711: Quantity: " + report.getQuantity());
            System.out.println("26711: PO Number: " + report.getPoNumber());
            System.out.println("26711: Order Date: " + report.getOrderDate());
            System.out.println("26711: Total Amount: $" + report.getTotalAmount());
            System.out.println("26711: Delivery Date: " + report.getDeliveryDate());
            System.out.println("26711: Delivered By: " + report.getDeliveredBy());
            System.out.println("26711: Inspector Name: " + report.getInspectorName());
            System.out.println("26711: Status: " + report.getStatus());
            System.out.println("26711: Remarks: " + report.getRemarks());
            System.out.println("26711: Invoice Number: " + report.getInvoiceNo());
            System.out.println("26711: Invoice Amount: $" + report.getInvoiceAmount());
            System.out.println("26711: Report Date: " + report.getReportDate());
            System.out.println("26711: Summary: " + report.getSummary());
            System.out.println("26711: ========================================\n");

            report.calculateTotal();

        } catch (Exception e) {
            System.out.println("26711: Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

