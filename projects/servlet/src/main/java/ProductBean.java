public class ProductBean {
    public ProductBean() {
    }

    public ProductBean(int id, String name, String quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    private int id;
    private String name;
    private String quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
