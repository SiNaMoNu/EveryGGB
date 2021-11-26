package application.model;

public class TokenInput {
	public static String ACCESS_TOKEN;
	public static String USER_SQUENCE_NUMBER;
	
	public static String ACCOUNT_HOLDER_NAME;	// 계좌실명조회api -> account_holder_name
	public static String BANK_NAME;				// 잔액조회api -> bank_name
	public static int ACCOUNT_NUM;				// 계좌실명조회api -> account_num
	public static int BALANCE_AMT;				// 잔액조회api -> balance_amt
	
	public static String TRAN_DATE;				// 거래내역조회api -> tran_date
	public static String PRINTED_CONTENT;		// 거래내역조회api -> printed_content
	public static String INOUT_TYPE;			// 거래내역조회api -> inout_type
	public static int AFTER_BALANCE_AMT;		// 거래내역조회api -> after_balance_amt
	public static int TRAN_AMT;					// 거래내역조회api -> tran_amt
}
