package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Transaction {

    private StringProperty Date;
    private StringProperty Name;
    private StringProperty Category;
    private SimpleStringProperty IncomeOrExpense;
	private SimpleStringProperty Balance;
	private SimpleStringProperty Amount;

    public Transaction() {
        this(null, null, null, null, null, null);
    }

    public Transaction(String Date, String Name, String Category, String IncomeOrExpense, String Balance, String Amount) {
        this.Date = new SimpleStringProperty(Date);
        this.Name = new SimpleStringProperty(Name);
        this.Category = new SimpleStringProperty(Category);
        this.IncomeOrExpense = new SimpleStringProperty(IncomeOrExpense);
		this.Balance = new SimpleStringProperty(Balance);
		this.Amount = new SimpleStringProperty(Amount);
    }

    public String getDate() {
        return Date.get();
    }

    public void setDate(String Date) {
        this.Date.set(Date);
    }

    public StringProperty DateProperty() {
        return Date;
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String Name) {
        this.Name.set(Name);
    }
    
	public StringProperty NameProperty() {
	        return Name;
	}
	
    public StringProperty CategoryProperty() {
        return Category;
    }
    
    public String getCategory() {
        return Category.get();
    }

    public void setCategory(String Category) {
        this.Category.set(Category);
    }

    public StringProperty IncomeOrExpenseProperty() {
        return IncomeOrExpense;
    }
    
    public String getIncomeOrExpense() {
        return IncomeOrExpense.get();
    }

    public void setIncomeOrExpense(String IncomeOrExpense) {
        this.IncomeOrExpense.set(IncomeOrExpense);
    }
    
    public StringProperty BalanceProperty() {
        return Balance;
    }
    
    public String getBalance() {
        return Balance.get();
    }

    public void setBalance(String Balance) {
        this.Balance.set(Balance);
    }
    
    public StringProperty AmountProperty() {
        return Amount;
    }
    
    public String getAmount() {
        return Amount.get();
    }

    public void setAmount(String Amount) {
        this.Amount.set(Amount);
    }
}