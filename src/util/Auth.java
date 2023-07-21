package util;

import entity.TaiKhoan;

public class Auth {
  
    public static TaiKhoan user = null;
   
    public static void clear() {
        Auth.user = null;
    }
   
    public static boolean isLogin() {
        return Auth.user != null;
    }
  
    public static boolean isManager() {
        return Auth.isLogin() && user.getVaiTro();
    }
}
