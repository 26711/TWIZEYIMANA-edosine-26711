import java.util.Date;

public class Entity {
    private int id;
    private Date createdDate;
    private Date updatedDate;

    public Entity(int id, Date createdDate, Date updatedDate) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
        if (createdDate == null || updatedDate == null) {
            throw new IllegalArgumentException("Dates must not be null");
        }
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        if (createdDate == null) {
            throw new IllegalArgumentException("Created date must not be null");
        }
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        if (updatedDate == null) {
            throw new IllegalArgumentException("Updated date must not be null");
        }
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Entity{id=" + id + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "}";
    }
}

