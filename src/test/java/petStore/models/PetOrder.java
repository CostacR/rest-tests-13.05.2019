package PetStore.models;

public class PetOrder {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean completeOrder;

    public PetOrder(int id, int petId, int quantity, String shipDate, String status, boolean completeOrder) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.completeOrder = completeOrder;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
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
