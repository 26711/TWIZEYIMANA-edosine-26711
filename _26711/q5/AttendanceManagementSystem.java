package _26711.q5;

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

// Institution class
class Institution extends Entity {
    private String institutionName;
    private String code;
    private String address;

    public Institution(int id, Date createdDate, Date updatedDate, String institutionName, String code, String address) {
        super(id, createdDate, updatedDate);
        if (code == null || code.length() < 3) throw new IllegalArgumentException("Code must be ≥ 3 chars");
        this.institutionName = institutionName;
        this.code = code;
        this.address = address;
    }

    public String getInstitutionName() { return institutionName; }
    public void setInstitutionName(String institutionName) { this.institutionName = institutionName; }
    public String getCode() { return code; }
    public void setCode(String code) {
        if (code == null || code.length() < 3) throw new IllegalArgumentException("Code must be ≥ 3 chars");
        this.code = code;
    }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}

// Department class
class Department extends Institution {
    private String departmentName;
    private String departmentHead;

    public Department(int id, Date createdDate, Date updatedDate, String institutionName, String code, String address,
                     String departmentName, String departmentHead) {
        super(id, createdDate, updatedDate, institutionName, code, address);
        if (departmentName == null || departmentName.isEmpty()) throw new IllegalArgumentException("Department name must not be empty");
        if (departmentHead == null || departmentHead.isEmpty()) throw new IllegalArgumentException("Department head must not be empty");
        this.departmentName = departmentName;
        this.departmentHead = departmentHead;
    }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) throw new IllegalArgumentException("Department name must not be empty");
        this.departmentName = departmentName;
    }
    public String getDepartmentHead() { return departmentHead; }
    public void setDepartmentHead(String departmentHead) {
        if (departmentHead == null || departmentHead.isEmpty()) throw new IllegalArgumentException("Department head must not be empty");
        this.departmentHead = departmentHead;
    }
}

// Course class
class Course extends Department {
    private String courseName;
    private String courseCode;
    private int credits;

    public Course(int id, Date createdDate, Date updatedDate, String institutionName, String code, String address,
                 String departmentName, String departmentHead, String courseName, String courseCode, int credits) {
        super(id, createdDate, updatedDate, institutionName, code, address, departmentName, departmentHead);
        if (credits <= 0) throw new IllegalArgumentException("Credits must be > 0");
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public int getCredits() { return credits; }
    public void setCredits(int credits) {
        if (credits <= 0) throw new IllegalArgumentException("Credits must be > 0");
        this.credits = credits;
    }
}

// Instructor class
class Instructor extends Course {
    private String instructorName;
    private String email;
    private String phone;

    public Instructor(int id, Date createdDate, Date updatedDate, String institutionName, String code, String address,
                     String departmentName, String departmentHead, String courseName, String courseCode, int credits,
                     String instructorName, String email, String phone) {
        super(id, createdDate, updatedDate, institutionName, code, address, departmentName, departmentHead,
              courseName, courseCode, credits);
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be 10 digits");
        }
        this.instructorName = instructorName;
        this.email = email;
        this.phone = phone;
    }

    public String getInstructorName() { return instructorName; }
    public void setInstructorName(String instructorName) { this.instructorName = instructorName; }
    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }
    public String getPhone() { return phone; }
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be 10 digits");
        }
        this.phone = phone;
    }
}

// Student class
class Student extends Instructor {
    private String studentName;
    private String studentID;
    private int age;

    public Student(int id, Date createdDate, Date updatedDate, String institutionName, String code, String address,
                  String departmentName, String departmentHead, String courseName, String courseCode, int credits,
                  String instructorName, String email, String phone, String studentName, String studentID, int age) {
        super(id, createdDate, updatedDate, institutionName, code, address, departmentName, departmentHead,
              courseName, courseCode, credits, instructorName, email, phone);
        if (age <= 0) throw new IllegalArgumentException("Age must be > 0");
        this.studentName = studentName;
        this.studentID = studentID;
        this.age = age;
    }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; }
    public int getAge() { return age; }
    public void setAge(int age) {
        if (age <= 0) throw new IllegalArgumentException("Age must be > 0");
        this.age = age;
    }
}

// ClassSession class
class ClassSession extends Student {
    private Date sessionDate;
    private String topic;

    public ClassSession(int id, Date createdDate, Date updatedDate, String institutionName, String code, String address,
                      String departmentName, String departmentHead, String courseName, String courseCode, int credits,
                      String instructorName, String email, String phone, String studentName, String studentID, int age,
                      Date sessionDate, String topic) {
        super(id, createdDate, updatedDate, institutionName, code, address, departmentName, departmentHead,
              courseName, courseCode, credits, instructorName, email, phone, studentName, studentID, age);
        if (sessionDate == null) throw new IllegalArgumentException("Session date must not be null");
        if (topic == null) throw new IllegalArgumentException("Topic must not be null");
        this.sessionDate = sessionDate;
        this.topic = topic;
    }

    public Date getSessionDate() { return sessionDate; }
    public void setSessionDate(Date sessionDate) {
        if (sessionDate == null) throw new IllegalArgumentException("Session date must not be null");
        this.sessionDate = sessionDate;
    }
    public String getTopic() { return topic; }
    public void setTopic(String topic) {
        if (topic == null) throw new IllegalArgumentException("Topic must not be null");
        this.topic = topic;
    }
}

// AttendanceRecord class
class AttendanceRecord extends ClassSession {
    private String studentID2;
    private String sessionID;
    private String status;

    public AttendanceRecord(int id, Date createdDate, Date updatedDate, String institutionName, String code, String address,
                           String departmentName, String departmentHead, String courseName, String courseCode, int credits,
                           String instructorName, String email, String phone, String studentName, String studentID, int age,
                           Date sessionDate, String topic, String studentID2, String sessionID, String status) {
        super(id, createdDate, updatedDate, institutionName, code, address, departmentName, departmentHead,
              courseName, courseCode, credits, instructorName, email, phone, studentName, studentID, age,
              sessionDate, topic);
        if (!status.equals("Present") && !status.equals("Absent")) {
            throw new IllegalArgumentException("Status must be 'Present' or 'Absent'");
        }
        this.studentID2 = studentID2;
        this.sessionID = sessionID;
        this.status = status;
    }

    public String getStudentID2() { return studentID2; }
    public void setStudentID2(String studentID2) { this.studentID2 = studentID2; }
    public String getSessionID() { return sessionID; }
    public void setSessionID(String sessionID) { this.sessionID = sessionID; }
    public String getStatus() { return status; }
    public void setStatus(String status) {
        if (!status.equals("Present") && !status.equals("Absent")) {
            throw new IllegalArgumentException("Status must be 'Present' or 'Absent'");
        }
        this.status = status;
    }
}

// LeaveRequest class
class LeaveRequest extends AttendanceRecord {
    private Date requestDate;
    private String reason;
    private boolean approved;

    public LeaveRequest(int id, Date createdDate, Date updatedDate, String institutionName, String code, String address,
                       String departmentName, String departmentHead, String courseName, String courseCode, int credits,
                       String instructorName, String email, String phone, String studentName, String studentID, int age,
                       Date sessionDate, String topic, String studentID2, String sessionID, String status,
                       Date requestDate, String reason, boolean approved) {
        super(id, createdDate, updatedDate, institutionName, code, address, departmentName, departmentHead,
              courseName, courseCode, credits, instructorName, email, phone, studentName, studentID, age,
              sessionDate, topic, studentID2, sessionID, status);
        if (reason == null || reason.isEmpty()) throw new IllegalArgumentException("Reason must not be empty");
        this.requestDate = requestDate;
        this.reason = reason;
        this.approved = approved;
    }

    public Date getRequestDate() { return requestDate; }
    public void setRequestDate(Date requestDate) { this.requestDate = requestDate; }
    public String getReason() { return reason; }
    public void setReason(String reason) {
        if (reason == null || reason.isEmpty()) throw new IllegalArgumentException("Reason must not be empty");
        this.reason = reason;
    }
    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }
}

// AttendanceSummary class (final)
final class AttendanceSummary extends LeaveRequest {
    private Date reportDate;
    private int totalPresent;
    private int totalAbsent;

    public AttendanceSummary(int id, Date createdDate, Date updatedDate, String institutionName, String code, String address,
                           String departmentName, String departmentHead, String courseName, String courseCode, int credits,
                           String instructorName, String email, String phone, String studentName, String studentID, int age,
                           Date sessionDate, String topic, String studentID2, String sessionID, String status,
                           Date requestDate, String reason, boolean approved, Date reportDate, int totalPresent, int totalAbsent) {
        super(id, createdDate, updatedDate, institutionName, code, address, departmentName, departmentHead,
              courseName, courseCode, credits, instructorName, email, phone, studentName, studentID, age,
              sessionDate, topic, studentID2, sessionID, status, requestDate, reason, approved);
        this.reportDate = reportDate;
        this.totalPresent = totalPresent;
        this.totalAbsent = totalAbsent;
    }

    public Date getReportDate() { return reportDate; }
    public void setReportDate(Date reportDate) { this.reportDate = reportDate; }
    public int getTotalPresent() { return totalPresent; }
    public void setTotalPresent(int totalPresent) { this.totalPresent = totalPresent; }
    public int getTotalAbsent() { return totalAbsent; }
    public void setTotalAbsent(int totalAbsent) { this.totalAbsent = totalAbsent; }

    public void generateSummary() {
        int totalSessions = totalPresent + totalAbsent;
        double attendanceRate = totalSessions > 0 ? (totalPresent * 100.0 / totalSessions) : 0;
        
        System.out.println("26711: \n========== ATTENDANCE SUMMARY ==========");
        System.out.println("26711: Report Date: " + reportDate);
        System.out.println("26711: \n--- Attendance Statistics ---");
        System.out.println("26711: Total Present: " + totalPresent);
        System.out.println("26711: Total Absent: " + totalAbsent);
        System.out.println("26711: Total Sessions: " + totalSessions);
        System.out.println("26711: Attendance Rate: " + String.format("%.2f", attendanceRate) + "%");
        System.out.println("26711: ========================================\n");
    }
}

// Main class
public class AttendanceManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date now = new Date();

        System.out.println("26711: ========== ATTENDANCE MANAGEMENT SYSTEM ==========");
        
        try {
            System.out.print("26711: Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("26711: Enter Institution Name: ");
            String institutionName = scanner.nextLine();

            System.out.print("26711: Enter Code (≥3 chars): ");
            String code = scanner.nextLine();

            System.out.print("26711: Enter Address: ");
            String address = scanner.nextLine();

            System.out.print("26711: Enter Department Name: ");
            String departmentName = scanner.nextLine();

            System.out.print("26711: Enter Department Head: ");
            String departmentHead = scanner.nextLine();

            System.out.print("26711: Enter Course Name: ");
            String courseName = scanner.nextLine();

            System.out.print("26711: Enter Course Code: ");
            String courseCode = scanner.nextLine();

            System.out.print("26711: Enter Credits (>0): ");
            int credits = scanner.nextInt();
            scanner.nextLine();

            System.out.print("26711: Enter Instructor Name: ");
            String instructorName = scanner.nextLine();

            System.out.print("26711: Enter Email: ");
            String email = scanner.nextLine();

            System.out.print("26711: Enter Phone (10 digits): ");
            String phone = scanner.nextLine();

            System.out.print("26711: Enter Student Name: ");
            String studentName = scanner.nextLine();

            System.out.print("26711: Enter Student ID: ");
            String studentID = scanner.nextLine();

            System.out.print("26711: Enter Age (>0): ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("26711: Enter Topic: ");
            String topic = scanner.nextLine();

            System.out.print("26711: Enter Student ID (for record): ");
            String studentID2 = scanner.nextLine();

            System.out.print("26711: Enter Session ID: ");
            String sessionID = scanner.nextLine();

            System.out.print("26711: Enter Status (Present/Absent): ");
            String status = scanner.nextLine();

            System.out.print("26711: Enter Reason: ");
            String reason = scanner.nextLine();

            System.out.print("26711: Enter Approved (true/false): ");
            boolean approved = scanner.nextBoolean();
            scanner.nextLine();

            System.out.print("26711: Enter Total Present: ");
            int totalPresent = scanner.nextInt();

            System.out.print("26711: Enter Total Absent: ");
            int totalAbsent = scanner.nextInt();
            scanner.nextLine();

            AttendanceSummary summary = new AttendanceSummary(id, now, now, institutionName, code, address,
                departmentName, departmentHead, courseName, courseCode, credits, instructorName, email, phone,
                studentName, studentID, age, now, topic, studentID2, sessionID, status, now, reason, approved,
                now, totalPresent, totalAbsent);

            System.out.println("26711: \n========== ALL INSERTED DATA ==========");
            System.out.println("26711: ID: " + summary.getId());
            System.out.println("26711: Created Date: " + summary.getCreatedDate());
            System.out.println("26711: Updated Date: " + summary.getUpdatedDate());
            System.out.println("26711: Institution Name: " + summary.getInstitutionName());
            System.out.println("26711: Code: " + summary.getCode());
            System.out.println("26711: Address: " + summary.getAddress());
            System.out.println("26711: Department Name: " + summary.getDepartmentName());
            System.out.println("26711: Department Head: " + summary.getDepartmentHead());
            System.out.println("26711: Course Name: " + summary.getCourseName());
            System.out.println("26711: Course Code: " + summary.getCourseCode());
            System.out.println("26711: Credits: " + summary.getCredits());
            System.out.println("26711: Instructor Name: " + summary.getInstructorName());
            System.out.println("26711: Email: " + summary.getEmail());
            System.out.println("26711: Phone: " + summary.getPhone());
            System.out.println("26711: Student Name: " + summary.getStudentName());
            System.out.println("26711: Student ID: " + summary.getStudentID());
            System.out.println("26711: Age: " + summary.getAge());
            System.out.println("26711: Session Date: " + summary.getSessionDate());
            System.out.println("26711: Topic: " + summary.getTopic());
            System.out.println("26711: Student ID (Record): " + summary.getStudentID2());
            System.out.println("26711: Session ID: " + summary.getSessionID());
            System.out.println("26711: Status: " + summary.getStatus());
            System.out.println("26711: Request Date: " + summary.getRequestDate());
            System.out.println("26711: Reason: " + summary.getReason());
            System.out.println("26711: Approved: " + summary.isApproved());
            System.out.println("26711: Report Date: " + summary.getReportDate());
            System.out.println("26711: Total Present: " + summary.getTotalPresent());
            System.out.println("26711: Total Absent: " + summary.getTotalAbsent());
            System.out.println("26711: ========================================\n");

            summary.generateSummary();

        } catch (Exception e) {
            System.out.println("26711: Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

