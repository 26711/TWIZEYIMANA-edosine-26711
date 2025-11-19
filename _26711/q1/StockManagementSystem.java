package _26711.q1;

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

// Warehouse class
class Warehouse extends Entity {
    private String warehouseName;
    private String location;
    private String contactNumber;

    public Warehouse(int id, Date createdDate, Date updatedDate, String warehouseName, String location, String contactNumber) {
        super(id, createdDate, updatedDate);
        if (contactNumber == null || !contactNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be 10 digits");
        }
        this.warehouseName = warehouseName;
        this.location = location;
        this.contactNumber = contactNumber;
    }

    public String getWarehouseName() { return warehouseName; }
    public void setWarehouseName(String warehouseName) { this.warehouseName = warehouseName; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) {
        if (contactNumber == null || !contactNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be 10 digits");
        }
        this.contactNumber = contactNumber;
    }
}

// Category class
class Category extends Warehouse {
    private String categoryName;
    private String categoryCode;

    public Category(int id, Date createdDate, Date updatedDate, String warehouseName, String location, 
                   String contactNumber, String categoryName, String categoryCode) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber);
        if (categoryCode == null || categoryCode.length() < 3 || !categoryCode.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException("Category code must be alphanumeric and ≥ 3 chars");
        }
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getCategoryCode() { return categoryCode; }
    public void setCategoryCode(String categoryCode) {
        if (categoryCode == null || categoryCode.length() < 3 || !categoryCode.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException("Category code must be alphanumeric and ≥ 3 chars");
        }
        this.categoryCode = categoryCode;
    }
}

// Supplier class
class Supplier extends Category {
    private String supplierName;
    private String supplierEmail;
    private String supplierPhone;

    public Supplier(int id, Date createdDate, Date updatedDate, String warehouseName, String location,
                   String contactNumber, String categoryName, String categoryCode, String supplierName,
                   String supplierEmail, String supplierPhone) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber, categoryName, categoryCode);
        if (supplierEmail == null || !supplierEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (supplierPhone == null || !supplierPhone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be 10 digits");
        }
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }
    public String getSupplierEmail() { return supplierEmail; }
    public void setSupplierEmail(String supplierEmail) {
        if (supplierEmail == null || !supplierEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.supplierEmail = supplierEmail;
    }
    public String getSupplierPhone() { return supplierPhone; }
    public void setSupplierPhone(String supplierPhone) {
        if (supplierPhone == null || !supplierPhone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be 10 digits");
        }
        this.supplierPhone = supplierPhone;
    }
}

// Product class
class Product extends Supplier {
    private String productName;
    private double unitPrice;
    private int stockLimit;

    public Product(int id, Date createdDate, Date updatedDate, String warehouseName, String location,
                  String contactNumber, String categoryName, String categoryCode, String supplierName,
                  String supplierEmail, String supplierPhone, String productName, double unitPrice, int stockLimit) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber, categoryName, categoryCode,
              supplierName, supplierEmail, supplierPhone);
        if (unitPrice <= 0) throw new IllegalArgumentException("Unit price must be > 0");
        if (stockLimit < 0) throw new IllegalArgumentException("Stock limit must be ≥ 0");
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.stockLimit = stockLimit;
    }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) {
        if (unitPrice <= 0) throw new IllegalArgumentException("Unit price must be > 0");
        this.unitPrice = unitPrice;
    }
    public int getStockLimit() { return stockLimit; }
    public void setStockLimit(int stockLimit) {
        if (stockLimit < 0) throw new IllegalArgumentException("Stock limit must be ≥ 0");
        this.stockLimit = stockLimit;
    }
}

// StockItem class
class StockItem extends Product {
    private int quantityAvailable;
    private int reorderLevel;

    public StockItem(int id, Date createdDate, Date updatedDate, String warehouseName, String location,
                    String contactNumber, String categoryName, String categoryCode, String supplierName,
                    String supplierEmail, String supplierPhone, String productName, double unitPrice, int stockLimit,
                    int quantityAvailable, int reorderLevel) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber, categoryName, categoryCode,
              supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit);
        if (quantityAvailable < 0) throw new IllegalArgumentException("Quantity available must be ≥ 0");
        if (reorderLevel < 0) throw new IllegalArgumentException("Reorder level must be ≥ 0");
        this.quantityAvailable = quantityAvailable;
        this.reorderLevel = reorderLevel;
    }

    public int getQuantityAvailable() { return quantityAvailable; }
    public void setQuantityAvailable(int quantityAvailable) {
        if (quantityAvailable < 0) throw new IllegalArgumentException("Quantity available must be ≥ 0");
        this.quantityAvailable = quantityAvailable;
    }
    public int getReorderLevel() { return reorderLevel; }
    public void setReorderLevel(int reorderLevel) {
        if (reorderLevel < 0) throw new IllegalArgumentException("Reorder level must be ≥ 0");
        this.reorderLevel = reorderLevel;
    }
}

// Purchase class
class Purchase extends StockItem {
    private Date purchaseDate;
    private int purchasedQuantity;
    private String supplierName;

    public Purchase(int id, Date createdDate, Date updatedDate, String warehouseName, String location,
                   String contactNumber, String categoryName, String categoryCode, String supplierName,
                   String supplierEmail, String supplierPhone, String productName, double unitPrice, int stockLimit,
                   int quantityAvailable, int reorderLevel, Date purchaseDate, int purchasedQuantity, String supplierName2) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber, categoryName, categoryCode,
              supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit, quantityAvailable, reorderLevel);
        if (purchaseDate == null) throw new IllegalArgumentException("Purchase date must not be null");
        if (purchasedQuantity <= 0) throw new IllegalArgumentException("Purchased quantity must be > 0");
        this.purchaseDate = purchaseDate;
        this.purchasedQuantity = purchasedQuantity;
        this.supplierName = supplierName2;
    }

    public Date getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(Date purchaseDate) {
        if (purchaseDate == null) throw new IllegalArgumentException("Purchase date must not be null");
        this.purchaseDate = purchaseDate;
    }
    public int getPurchasedQuantity() { return purchasedQuantity; }
    public void setPurchasedQuantity(int purchasedQuantity) {
        if (purchasedQuantity <= 0) throw new IllegalArgumentException("Purchased quantity must be > 0");
        this.purchasedQuantity = purchasedQuantity;
    }
    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }
}

// Sale class
class Sale extends Purchase {
    private Date saleDate;
    private int soldQuantity;
    private String customerName;

    public Sale(int id, Date createdDate, Date updatedDate, String warehouseName, String location,
               String contactNumber, String categoryName, String categoryCode, String supplierName,
               String supplierEmail, String supplierPhone, String productName, double unitPrice, int stockLimit,
               int quantityAvailable, int reorderLevel, Date purchaseDate, int purchasedQuantity, String supplierName2,
               Date saleDate, int soldQuantity, String customerName) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber, categoryName, categoryCode,
              supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit, quantityAvailable,
              reorderLevel, purchaseDate, purchasedQuantity, supplierName2);
        if (saleDate == null) throw new IllegalArgumentException("Sale date must not be null");
        if (soldQuantity <= 0) throw new IllegalArgumentException("Sold quantity must be > 0");
        this.saleDate = saleDate;
        this.soldQuantity = soldQuantity;
        this.customerName = customerName;
    }

    public Date getSaleDate() { return saleDate; }
    public void setSaleDate(Date saleDate) {
        if (saleDate == null) throw new IllegalArgumentException("Sale date must not be null");
        this.saleDate = saleDate;
    }
    public int getSoldQuantity() { return soldQuantity; }
    public void setSoldQuantity(int soldQuantity) {
        if (soldQuantity <= 0) throw new IllegalArgumentException("Sold quantity must be > 0");
        this.soldQuantity = soldQuantity;
    }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
}

// Inventory class
class Inventory extends Sale {
    private int totalItems;
    private double stockValue;

    public Inventory(int id, Date createdDate, Date updatedDate, String warehouseName, String location,
                    String contactNumber, String categoryName, String categoryCode, String supplierName,
                    String supplierEmail, String supplierPhone, String productName, double unitPrice, int stockLimit,
                    int quantityAvailable, int reorderLevel, Date purchaseDate, int purchasedQuantity, String supplierName2,
                    Date saleDate, int soldQuantity, String customerName, int totalItems, double stockValue) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber, categoryName, categoryCode,
              supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit, quantityAvailable,
              reorderLevel, purchaseDate, purchasedQuantity, supplierName2, saleDate, soldQuantity, customerName);
        if (totalItems < 0) throw new IllegalArgumentException("Total items must be ≥ 0");
        if (stockValue < 0) throw new IllegalArgumentException("Stock value must be ≥ 0");
        this.totalItems = totalItems;
        this.stockValue = stockValue;
    }

    public int getTotalItems() { return totalItems; }
    public void setTotalItems(int totalItems) {
        if (totalItems < 0) throw new IllegalArgumentException("Total items must be ≥ 0");
        this.totalItems = totalItems;
    }
    public double getStockValue() { return stockValue; }
    public void setStockValue(double stockValue) {
        if (stockValue < 0) throw new IllegalArgumentException("Stock value must be ≥ 0");
        this.stockValue = stockValue;
    }
}

// StockReport class (final)
final class StockReport extends Inventory {
    private Date reportDate;
    private String remarks;

    public StockReport(int id, Date createdDate, Date updatedDate, String warehouseName, String location,
                      String contactNumber, String categoryName, String categoryCode, String supplierName,
                      String supplierEmail, String supplierPhone, String productName, double unitPrice, int stockLimit,
                      int quantityAvailable, int reorderLevel, Date purchaseDate, int purchasedQuantity, String supplierName2,
                      Date saleDate, int soldQuantity, String customerName, int totalItems, double stockValue,
                      Date reportDate, String remarks) {
        super(id, createdDate, updatedDate, warehouseName, location, contactNumber, categoryName, categoryCode,
              supplierName, supplierEmail, supplierPhone, productName, unitPrice, stockLimit, quantityAvailable,
              reorderLevel, purchaseDate, purchasedQuantity, supplierName2, saleDate, soldQuantity, customerName,
              totalItems, stockValue);
        this.reportDate = reportDate;
        this.remarks = remarks;
    }

    public Date getReportDate() { return reportDate; }
    public void setReportDate(Date reportDate) { this.reportDate = reportDate; }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public void generateReport() {
        System.out.println("26711: \n========== STOCK REPORT ==========");
        System.out.println("26711: Report Date: " + reportDate);
        System.out.println("26711: Remarks: " + remarks);
        System.out.println("26711: \n--- Summary ---");
        System.out.println("26711: Total Stock Items: " + getTotalItems());
        System.out.println("26711: Total Stock Value: $" + String.format("%.2f", getStockValue()));
        System.out.println("26711: Total Sales Quantity: " + getSoldQuantity());
        System.out.println("26711: Sales Revenue: $" + String.format("%.2f", getSoldQuantity() * getUnitPrice()));
        System.out.println("26711: ===================================\n");
    }
}

// Main class
public class StockManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date now = new Date();

        System.out.println("26711: ========== STOCK MANAGEMENT SYSTEM ==========");
        
        try {
            System.out.print("26711: Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("26711: Enter Warehouse Name: ");
            String warehouseName = scanner.nextLine();

            System.out.print("26711: Enter Location: ");
            String location = scanner.nextLine();

            System.out.print("26711: Enter Contact Number (10 digits): ");
            String contactNumber = scanner.nextLine();

            System.out.print("26711: Enter Category Name: ");
            String categoryName = scanner.nextLine();

            System.out.print("26711: Enter Category Code (≥3 alphanumeric): ");
            String categoryCode = scanner.nextLine();

            System.out.print("26711: Enter Supplier Name: ");
            String supplierName = scanner.nextLine();

            System.out.print("26711: Enter Supplier Email: ");
            String supplierEmail = scanner.nextLine();

            System.out.print("26711: Enter Supplier Phone (10 digits): ");
            String supplierPhone = scanner.nextLine();

            System.out.print("26711: Enter Product Name: ");
            String productName = scanner.nextLine();

            System.out.print("26711: Enter Unit Price (>0): ");
            double unitPrice = scanner.nextDouble();

            System.out.print("26711: Enter Stock Limit (≥0): ");
            int stockLimit = scanner.nextInt();

            System.out.print("26711: Enter Quantity Available (≥0): ");
            int quantityAvailable = scanner.nextInt();

            System.out.print("26711: Enter Reorder Level (≥0): ");
            int reorderLevel = scanner.nextInt();
            scanner.nextLine();

            System.out.print("26711: Enter Purchase Date Supplier Name: ");
            String purchaseSupplierName = scanner.nextLine();

            System.out.print("26711: Enter Purchased Quantity (>0): ");
            int purchasedQuantity = scanner.nextInt();
            scanner.nextLine();

            System.out.print("26711: Enter Customer Name: ");
            String customerName = scanner.nextLine();

            System.out.print("26711: Enter Sold Quantity (>0): ");
            int soldQuantity = scanner.nextInt();

            System.out.print("26711: Enter Total Items (≥0): ");
            int totalItems = scanner.nextInt();

            System.out.print("26711: Enter Stock Value (≥0): ");
            double stockValue = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("26711: Enter Remarks: ");
            String remarks = scanner.nextLine();

            StockReport report = new StockReport(id, now, now, warehouseName, location, contactNumber,
                categoryName, categoryCode, supplierName, supplierEmail, supplierPhone, productName, unitPrice,
                stockLimit, quantityAvailable, reorderLevel, now, purchasedQuantity, purchaseSupplierName,
                now, soldQuantity, customerName, totalItems, stockValue, now, remarks);

            System.out.println("26711: \n========== ALL INSERTED DATA ==========");
            System.out.println("26711: ID: " + report.getId());
            System.out.println("26711: Created Date: " + report.getCreatedDate());
            System.out.println("26711: Updated Date: " + report.getUpdatedDate());
            System.out.println("26711: Warehouse Name: " + report.getWarehouseName());
            System.out.println("26711: Location: " + report.getLocation());
            System.out.println("26711: Contact Number: " + report.getContactNumber());
            System.out.println("26711: Category Name: " + report.getCategoryName());
            System.out.println("26711: Category Code: " + report.getCategoryCode());
            System.out.println("26711: Supplier Name: " + report.getSupplierName());
            System.out.println("26711: Supplier Email: " + report.getSupplierEmail());
            System.out.println("26711: Supplier Phone: " + report.getSupplierPhone());
            System.out.println("26711: Product Name: " + report.getProductName());
            System.out.println("26711: Unit Price: $" + report.getUnitPrice());
            System.out.println("26711: Stock Limit: " + report.getStockLimit());
            System.out.println("26711: Quantity Available: " + report.getQuantityAvailable());
            System.out.println("26711: Reorder Level: " + report.getReorderLevel());
            System.out.println("26711: Purchase Date: " + report.getPurchaseDate());
            System.out.println("26711: Purchased Quantity: " + report.getPurchasedQuantity());
            System.out.println("26711: Sale Date: " + report.getSaleDate());
            System.out.println("26711: Sold Quantity: " + report.getSoldQuantity());
            System.out.println("26711: Customer Name: " + report.getCustomerName());
            System.out.println("26711: Total Items: " + report.getTotalItems());
            System.out.println("26711: Stock Value: $" + report.getStockValue());
            System.out.println("26711: Report Date: " + report.getReportDate());
            System.out.println("26711: Remarks: " + report.getRemarks());
            System.out.println("26711: ========================================\n");

            report.generateReport();

        } catch (Exception e) {
            System.out.println("26711: Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

