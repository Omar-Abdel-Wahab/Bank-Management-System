package bms;

public class Transaction {

    Account defaultAccount;
    Account transferredFrom;
    Account transferredTo;
    String type;

    public Transaction() {
    }

    public Transaction(Account defaultAccount, String type) {
        this.defaultAccount = defaultAccount;
        this.type = type;
    }

    public Transaction(Account transferredFrom, Account transferredTo) {
        this.transferredFrom = transferredFrom;
        this.transferredTo = transferredTo;
        this.type = "Money Transfer";
    }

    public Account getDefaultAccount() {
        return defaultAccount;
    }

    public Account getTransferredFrom() {
        return transferredFrom;
    }

    public Account getTransferredTo() {
        return transferredTo;
    }

    public String getType() {
        return type;
    }

    public void setDefaultAccount(Account defaultAccount) {
        this.defaultAccount = defaultAccount;
    }

    public void setTransferredFrom(Account transferredFrom) {
        this.transferredFrom = transferredFrom;
    }

    public void setTransferredTo(Account transferredTo) {
        this.transferredTo = transferredTo;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        if (!(type.equals("Money Transfer"))) {
            return "Default: " + defaultAccount + "\n" + "Type: " + type + "\n";
        } else {
            return "Transferred From: " + transferredFrom + "\n" + "Transferred To: "
                    + transferredTo + "\nType: Money Transfer\n";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Transaction)) {
            return false;
        }
        Transaction t = (Transaction) obj;
        return t.defaultAccount.equals(defaultAccount)
                && t.transferredFrom.equals(transferredFrom)
                && t.transferredTo.equals(transferredTo) && t.type.equals(type);
    }

    public void withdraw(int amount) {
        if (defaultAccount.isOpen()) {
            double balance = defaultAccount.getBalance();
            defaultAccount.setBalance(balance - amount);
            //System.out.println("Done. Please receive your money through the ATM slot.");
        } else {
            //System.out.println("Sorry, your operation can't be executed. Account is 
            //closed.");
        }
    }

    public void deposit(int amount) {
        if (defaultAccount.isOpen()) {
            double balance = defaultAccount.getBalance();
            defaultAccount.setBalance(balance + amount);
            //System.out.println("Done. Entered money is added to your account.");
        } else {
            //System.out.println("Sorry, your operation can't be executed. Account is 
            //closed.");
        }
    }

    public double inquiry() {
        return defaultAccount.getBalance();
    }

    public void moneyTransfer(int amount) {
        double balance1 = transferredFrom.getBalance();
        if (transferredFrom.isOpen() && transferredTo.isOpen() && amount <= balance1) {
            double balance2 = transferredTo.getBalance();
            transferredFrom.setBalance(balance1 - amount);
            transferredTo.setBalance(balance2 + amount);
            //System.out.println("Done. Money transferred to the desired account.");
        } else {
            //System.out.println("Sorry, your operation can't be executed. Account is 
            //closed.");
        }
    }

}
