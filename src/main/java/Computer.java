

public class Computer {

    private int id;
    private String compMark;
    private String compModel;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompMark() {
        return compMark;
    }

    public void setCompMark(String compMark) {
        this.compMark = compMark;
    }

    public String getCompModel() {
        return compModel;
    }

    public void setCompModel(String compModel) {
        this.compModel = compModel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", compMark='" + compMark + '\'' +
                ", compModel='" + compModel + '\'' +
                ", price=" + price +
                '}';
    }
}
