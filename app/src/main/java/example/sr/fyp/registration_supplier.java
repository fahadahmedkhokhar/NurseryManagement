package example.sr.fyp;

public class registration_supplier {
    String uname;
    String email;
    String password;
    String cpassword;
    public registration_supplier(){
    }

    public registration_supplier(String uname, String email, String password, String cpassword){
        uname=uname;
        email=email;
        password=password;
        cpassword=cpassword;
    }

    public String getUname() {
        return uname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCpassword() {
        return cpassword;
    }
}


