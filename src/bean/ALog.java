package bean;

/**
 * Alog for Admin
 */
public class ALog  extends Admin{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int aId;
    private String aUsername;
    private String aPassword;
    private String aNmae;
    private String aSex;
    private String aAge;


    @Override
    public int getaId() {
        return aId;
    }

    @Override
    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaUsername() {
        return aUsername;
    }

    public void setaUsername(String aUsername) {
        this.aUsername = aUsername;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    public String getaNmae() {
        return aNmae;
    }

    public void setaNmae(String aNmae) {
        this.aNmae = aNmae;
    }

    public String getaSex() {
        return aSex;
    }

    public void setaSex(String aSex) {
        this.aSex = aSex;
    }

    public String getaAge() {
        return aAge;
    }

    public void setaAge(String aAge) {
        this.aAge = aAge;
    }


}
