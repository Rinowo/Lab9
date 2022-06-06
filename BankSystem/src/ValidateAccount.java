public class ValidateAccount {
    public final String MOBILE = "0369122828";
    public final String PASSWORD = "Ng Tung Anh";
    public boolean checkAccount(String mobile, String password) {
        if (mobile.equals(MOBILE)) {
            if (password.equals(PASSWORD)) {
                System.out.println("Đăng nhập thành công!");
                return true;
            }
            else {
                System.err.println("\nMật khẩu sai, vui lòng nhập lại");
                return false;
            }
        }
        else {
            System.out.println();
            System.err.println("\nKiểm tra lại số điện thoại");
            return false;
        }
    }
}
