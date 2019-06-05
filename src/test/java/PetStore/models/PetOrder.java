package PetStore.models;

import java.util.Date;

public class PetOrder {
    private Date date = new Date();
    private int id;
    private int petId;
    private int quantity;
    private String status;
    private boolean completeOrder;

//    public PetOrder(Date date, int id, int petId, int quantity, String status, boolean completeOrder) {
//        this.date = date;
//        this.id = id;
//        this.petId = petId;
//        this.quantity = quantity;
//        this.status = status;
//        this.completeOrder = completeOrder;
//    }

    public PetOrder(int i, int i1, int i2, String placed, boolean b) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.status = status;
        this.completeOrder = completeOrder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(boolean completeOrder) {
        this.completeOrder = completeOrder;
    }
}
