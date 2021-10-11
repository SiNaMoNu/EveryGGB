package application;

import javafx.beans.property.SimpleStringProperty;

public class TableViewModel {
	private SimpleStringProperty Date;
	private SimpleStringProperty Name;
	private SimpleStringProperty Category;
	private SimpleStringProperty IncomeOrExpense;
	private SimpleStringProperty Balance;
	private SimpleStringProperty Amount;
	
	// 디폴트 생성자
	public TableViewModel() {
		this(null, null, null, null, null, null);
	}
	
	// 데이터를 초기화하는 생성자
	public TableViewModel(String Date, String Name, String Category, String IncomeOrExpense, String Balance, String Amount) {
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
	public SimpleStringProperty DateProperty() {
		return Date;
	}
	
	public String getName() {
		return Name.get();
	}
	public void setName(String Name) {
		this.Name.set(Name);
	}
	public SimpleStringProperty NameProperty() {
		return Name;
	}
	
	public String getCategory() {
		return Category.get();
	}
	public void setCategory(String Category) {
		this.Category.set(Category);
	}
	public SimpleStringProperty CategoryProperty() {
		return Category;
	}
	
	public String getIncomeOrExpense() {
		return IncomeOrExpense.get();
	}
	public void setIncomeOrExpense(String IncomeOrExpense) {
		this.IncomeOrExpense.set(IncomeOrExpense);
	}
	public SimpleStringProperty IncomeOrExpenseProperty() {
		return IncomeOrExpense;
	}
	
	public String getBalance() {
		return Balance.get();
	}
	public void setBalance(String Balance) {
		this.Balance.set(Balance);
	}
	public SimpleStringProperty BalanceProperty() {
		return Balance;
	}
	
	public String getAmount() {
		return Amount.get();
	}
	public void setAmount(String Amount) {
		this.Amount.set(Amount);
	}
	public SimpleStringProperty AmountProperty() {
		return Amount;
	}
}
