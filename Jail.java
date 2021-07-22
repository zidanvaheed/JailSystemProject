package crud;

public class Jail {
    protected int id;
    protected String name;
    protected String sex;
    protected int age;
    protected String address;
    protected String country;
    protected String offense;
    protected String description;


    //All functions get and set methods

    public Jail() {
    }

    public Jail(int id) {
        this.id = id;
    }

    public Jail(int id, String name, String sex, int age, String address, String country, String offense, String description) {
        this(name, sex, age, address, country, offense, description);
        this.id = id;
    }

    public Jail(String name, String sex, int age, String address, String country, String offense, String description) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.country = country;
        this.offense = offense;
        this.description = description;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getOffense() {
        return offense;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}