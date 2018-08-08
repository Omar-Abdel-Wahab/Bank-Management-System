package bms;

public class Payment {
    
    private int amount;
    private Date date;
    private Account account;
    private boolean received;
    
    public Payment() {
    }
    
    public Payment(int amount, Date date, Account account, boolean received) {
        this.amount = amount;
        this.date = date;
        this.account = account;
        this.received = received;
    }
    
    public Payment(int amount, Date date, String type, Account account) {
        this.amount = amount;
        this.date = date;
        this.account = account;
        this.received = false;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public Date getDate() {
        return date;
    }
    
    public Account getAccount() {
        return account;
    }
    
    public boolean isReceived() {
        return received;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }
    
    public void setReceived(boolean received) {
        this.received = received;
    }
    
    @Override
    public String toString() {
        return "Amount: " + amount + "\n" + "Date: " + date + "\n" + "Account: " + account
                + "\n" + "Received: " + received + "\n";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Payment)) {
            return false;
        }
        Payment p = (Payment) obj;
        return p.account.equals(account) && p.amount == amount && p.date.equals(date);
    }
    
}
