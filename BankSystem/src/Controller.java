import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    Scanner sc = new Scanner(System.in);
    private static long balanceNumber = 1000000;
    ArrayList<TransactionHistory> listHistory = new ArrayList<>();

    ArrayList<Account> list = new ArrayList<>();

    public Controller() {
        list.add(new Account(200599, 5000000));
    }

    public long getBalanceNumber() {
        return balanceNumber;
    }

    public static long transfer(long money) {
        if (money < 50000){
            System.err.println("Số tiền tối tiểu phải là 50000");

        }
        else if (money > balanceNumber) {
            System.err.println("Số dư không đủ");
        }
        else {
            System.out.println("Chuyển thành công");
            System.out.println("Số dư: " + (balanceNumber - money));
            balanceNumber = (balanceNumber - money);
        }
        return balanceNumber;
    }

    public boolean actionTransfer() {
        boolean found = false;
        System.out.print("Nhập số tài khoản hưởng thụ:  ");
        long id = sc.nextLong();
        for (Account account :
                list) {
            if (id == account.getId()) {
                System.out.print("Nhập số tiển chuyển: "); long money = sc.nextLong();
                transfer(money);
                listHistory.add(new TransactionHistory("Chuyển khoản",("" + id),money));
                return found = true;
            }
            else if (id != account.getId()) {
                System.err.println("Không tìm được số tài khoản: " + id);
                return found = false;
            }
        }
        return found;
    }

    public void getHistory() {
            System.out.println(listHistory);
    }

    public static String formatMoney(long money) {
        DecimalFormat formatter= new DecimalFormat("###,###,##0");

        return formatter.format(money);
    }


}
