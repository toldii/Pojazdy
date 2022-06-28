public class Vechicle {
   private String type;
   private String brand;
   private String model;
   private int mileage;
   private int manufactureYear;
   private String color;

    public Vechicle(String type, String brand, String model, int mileage, int manufactureYear, String color) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
        this.manufactureYear = manufactureYear;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public static Vechicle Parse(String str) {
        String[] data = str.split(",");
        if(data.length != 6)
            return null;
        return new Vechicle(data[0],data[1],data[2],Integer.parseInt(data[3]),Integer.parseInt(data[4]),data[5]);
    }

    @Override
    public String toString() {
        return type+","+brand+","+model+","+mileage+","+manufactureYear+","+color;

    }
}
