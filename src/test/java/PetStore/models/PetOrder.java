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

    public PetOrder() {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.status = status;
        this.completeOrder = completeOrder;
    }


}
