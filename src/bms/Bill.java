package bms;

public class Bill {

    private int amount;
    private Date date;
    private String type;
    private Account account;
    private boolean paid;

    public Bill() {
    }

    public Bill(int amount, Date date, String type, Account account, boolean paid) {
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.account = account;
        this.paid = paid;
    }

    public Bill(int amount, Date date, String type, Account account) {
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.account = account;
        this.paid = false;
    }

    public int getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public Account getAccount() {
        return account;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Amount: " + amount + "\n" + "Date: " + date + "\n" + "Type: " + type + "\n"
                + "Account: " + account + "\n" + "Paid: " + paid + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Bill)) {
            return false;
        }
        Bill b = (Bill) obj;
        return b.amount == amount && b.account.equals(account) && b.date.equals(date)
                && b.type.equals(type);
    }

}
