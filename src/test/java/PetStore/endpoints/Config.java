package PetStore.endpoints;

public class Config {
    final static String BASE_URI = "https://petstore.swagger.io/v2";
    final  static String GET_PET_BY_ID = "pet/{petId}";
    final  static String GET_PET_BY_STATUS = "pet/findByStatus";
    final  static String DELETE_PET_BY_ID = "pet/{petId}";
    final  static String UPDATE_PET_BY_ID = "pet/";
    final static String CREATE_PET = "pet";

    final static String CREATE_ORDER = "store/order";
    final static String GET_ORDER_BY_ID ="store/order{orderId}";
    final static String GET_ORDER_INVENTORY = "/store/inventory";
    final static String GET_DELETE_ORDER_BY_ID = "/store/order/{orderId}";

}
