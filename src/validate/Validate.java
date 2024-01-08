package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	
	public static Validate getInstance() {
		return new Validate();
	}
	
	public void checkEmail(String emailValue)  {
		Pattern p = Pattern.compile("^[a-z[_]](\\w*[.]?[_]?\\w*)*[@]\\w{3,}[.]\\w{3,}([.]?\\w{2,})?$");
		String email = emailValue;
		Matcher m = p.matcher(email);
		if (m.find()) {
			System.out.println("Email hop le");
		} else {
			System.out.println("Email khong hop le");
		}
	}
	
	public void checkName(String nameValue) {
		Pattern p = Pattern.compile("^[a-zA-Z0-9_-]{3,100}$");
		String name = nameValue;
		Matcher m = p.matcher(name);
		if(m.find()) {
			System.out.println("name hợp lệ !");
		}else {
			System.out.println("Tối thiểu 3 kí tự, tối đa 100 kí tự");
		}
	}
	
	public void checkPhoneNumber(String phoneValue) {
		Pattern p = Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})");
		String phone = phoneValue;
		Matcher m = p.matcher(phone);
		if(m.find()) {
			System.out.println("sdt hợp lệ !");
		}else {
			System.out.println("sdt KHÔNG hợp lệ !");
		}
	}

}
