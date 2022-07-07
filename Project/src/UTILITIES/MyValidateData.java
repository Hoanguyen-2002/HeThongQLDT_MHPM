
package UTILITIES;

import java.util.regex.Pattern;

public class MyValidateData {

    public static boolean isNull(String st)
    {
        st = st.trim();
        return (st=="");
    }
    public static boolean isNull(Object obj)
    {
        return (obj==null);
    }

    public static boolean checkPhone(String phone) {
        if (!Pattern.matches("^0[0-9]+", phone)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkNumber(String number){
        if(!Pattern.matches("[0-9]+", number)){
            return false;
        }else{
            return true;
        }
    }
    
    public static boolean checkEmail(String email) {
        if (!Pattern.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", email)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkDatetime(String date) {
        if (Pattern.matches("\\d{0,2}/\\d{0,2}/\\d{4}", date)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkString(String s) {
        if (Pattern.matches("\\p{Punct}", "" + s) || Pattern.matches("\\p{Digit}", "" + s)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkIdentityCard(String identCard) {
        if (!Pattern.matches("[0-9]+", identCard)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkNational(String national) {
        boolean check = true;
        for (int i = 0; i < national.length(); i++) {
            if (Pattern.matches("\\p{Punct}", "" + national.charAt(i)) || Pattern.matches("\\p{Digit}", "" + national.charAt(i))) {
                check = false;
                break;
            }
        }
        return check;
    }
    
    public static boolean checkFloat(String sFloat){
        boolean check = true;
        float x = 0;
        try{
            x = Float.parseFloat(sFloat);
            
            if(x <= 0){
                check = false;
            }
                
        }catch(NumberFormatException e){
            check = false;
        }
        
        return check;
    }
}
