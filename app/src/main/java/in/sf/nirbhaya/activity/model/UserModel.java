package in.sf.nirbhaya.activity.model;

/**
 * Created by raji on 5/31/16.
 */
public class UserModel {

    private String username;
    private String phNum1;
    private String phNum2;
    private String phNum3;
    private String emailId;

    public UserModel(String username, String emailId, String phNum1, String phNum2, String phNum3) {

        this.username = username;
        this.phNum2 = phNum2;
        this.phNum1 = phNum1;
        this.emailId = emailId;
        this.phNum3 = phNum3;
    }

    public UserModel() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhNum1() {
        return phNum1;
    }

    public void setPhNum1(String phNum1) {
        this.phNum1 = phNum1;
    }

    public String getPhNum2() {
        return phNum2;
    }

    public void setPhNum2(String phNum2) {
        this.phNum2 = phNum2;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhNum3() {
        return phNum3;
    }

    public void setPhNum3(String phNum3) {
        this.phNum3 = phNum3;
    }
}
