package bms;

public class Teller {

    private int id;
    private String name;
    private int age;
    private String address;
    private String email;
    private int salary;

    public Teller() {
    }

    public Teller(int id, String name, int age, String address, String email, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" + "Name: " + name + "\n" + "Age: " + age + "\n" + 
                "Address: " + address + "\n"+ "Email: " + email + "\n" + "Salary: " + salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Teller)) {
            return false;
        }
        Teller t = (Teller) obj;
        return t.id == id;
    }

}
