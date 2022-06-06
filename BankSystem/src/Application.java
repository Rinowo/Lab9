import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ValidateAccount validate = new ValidateAccount();
        Controller controller = new Controller();


        boolean isCheck = false;
        while (!isCheck) {
            System.out.print("Nhập số điện thoại: "); String mobile = sc.nextLine();
            System.out.print("Nhập mật khẩu: "); String password = sc.nextLine();

            isCheck = validate.checkAccount(mobile, password);
        }


        while (true) {
            menu();
            int choose = sc.nextInt();
            System.out.println();
            switch (choose) {
                case 1 -> {
                    System.out.print("Số dư: ");
                    long balance = controller.getBalanceNumber();
                    System.out.println(Controller.formatMoney(balance));
                }
                case 2 -> controller.actionTransfer();
                case 3 -> {
                    System.out.println("Lịch sử giao dịch: ");
                    controller.getHistory();
                }
                case 0 -> {
                    sc.close();
                    System.exit(0);
                }
                default -> System.err.println("Không có sự lựa chọn này");
            }
        }
    }
    public static void menu() {
        System.out.println("Lựa chọn của bạn: ");
        System.out.println("1: Xem số dư tài khoản");
        System.out.println("2: Chuyển khoản");
        System.out.println("3: Xem lịch sử giao dịch");
        System.out.println("0: ");
    }
}
