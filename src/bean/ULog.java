package bean;

/**
 * Ulog for user login
 */
public class ULog extends User {
    private  int id;
    private int uId;
    private  String uUsername;
    private String uPassword;
    private String uName;
    private String uSex;
    private String uAge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getuId() {
        return uId;
    }

    @Override
    public void setuId(int uId) {
        this.uId = uId;
    }

    @Override
    public String getuUsername() {
        return uUsername;
    }

    @Override
    public void setuUsername(String uUsername) {
        this.uUsername = uUsername;
    }

    @Override
    public String getuPassword() {
        return uPassword;
    }

    @Override
    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Override
    public String getuName() {
        return uName;
    }

    @Override
    public void setuName(String uName) {
        this.uName = uName;
    }

    @Override
    public String getuSex() {
        return uSex;
    }

    @Override
    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    @Override
    public String getuAge() {
        return uAge;
    }

    @Override
    public void setuAge(String uAge) {
        this.uAge = uAge;
    }
}
