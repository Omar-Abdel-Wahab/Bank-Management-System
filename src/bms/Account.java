package bms;

public class Account {

    private int id;
    private Client client;
    private double balance;
    private String password;
    private boolean open;

    public Account() {
    }

    public Account(int id, Client client, double balance, String password, boolean open) {
        this.id = id;
        this.client = client;
        this.balance = balance;
        this.password = password;
        this.open = open;
    }
    
    public Account(int id, Client client, double balance, String password) {
        this.id = id;
        this.client = client;
        this.balance = balance;
        this.password = password;
        this.open = true;
    }
    
    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public boolean isOpen() {
        return open;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" + "Client: " + client + "\n" + "Balance: " + "\n" + 
                "Open: " + open + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Account)) {
            return false;
        }
        Account a = (Account) obj;
        return a.id == id;
    }
}
