package com.mysite.shoppingMall.Ut;

import javax.servlet.http.HttpSession;

public class Ut {
    
    // 로그인 정보
    public static IsLogined isLogined(HttpSession session) {
        IsLogined result = new IsLogined();
        // 관리자 0 유저 1 => 권한
        // 로그인이 이루어졌다면
        if (session.getAttribute("UserId") != null){
            result.setLogin(1);
            result.setUserId((int)session.getAttribute("UserId"));
            result.setAuthority((int)session.getAttribute("authority"));
            return result;
        }
        
        // 로그인이 되지 않았다면
        result.setLogin(0);
        result.setUserId(0);
        result.setAuthority(null);
        return result;
    }

    // 이메일을 @ 기준으로 나눠준다.
    public static String[] splitEmail(String email){
        if(email.indexOf("@") == -1){
            return null;
        }

        String[] EmailTemp = email.split("\\@");

        return EmailTemp;
    }

    // 전화번호를 - 기준으로 나눠준다.
    public static String[] splitCellPhone(String phone){
        if(phone.indexOf("-") == -1){
            return null;
        }

        String[] phoneTemp = phone.split("\\-");

        return phoneTemp;
    }

    // ** 을 구분자로 하는 문자열을 ** 기준으로 나눠준다.
    public static String[] splitStar(String str) {
        String[] AddressTemp = str.split("\\*\\*");

        return AddressTemp;
    }

    // 관리자인지를 확인한다.
    public static String isAdmin(HttpSession session) {
        IsLogined islogined = Ut.isLogined(session);
        if(islogined.getAuthority() == null){
            return "notAdmin";
        }
        return "admin";
    }
}
