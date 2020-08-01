package edu.lin.emp.entity;

/**
 * @description:
 * @author: lin
 * @time: 2020/7/31 18:37
 */
public class Bird {

    private int birdId;

    private String birdName;

    private String birdAccount;

    private String birdPwd;

    public Bird(int birdId, String birdName, String birdAccount, String birdPwd) {
        this.birdId = birdId;
        this.birdName = birdName;
        this.birdAccount = birdAccount;
        this.birdPwd = birdPwd;
    }

    public Bird() {
    }

    public Bird(String birdAccount, String birdPwd) {
        this.birdAccount = birdAccount;
        this.birdPwd = birdPwd;
    }

    public int getBirdId() {
        return birdId;
    }

    public void setBirdId(int birdId) {
        this.birdId = birdId;
    }

    public String getBirdName() {
        return birdName;
    }

    public void setBirdName(String birdName) {
        this.birdName = birdName;
    }

    public String getBirdAccount() {
        return birdAccount;
    }

    public void setBirdAccount(String birdAccount) {
        this.birdAccount = birdAccount;
    }

    public String getBirdPwd() {
        return birdPwd;
    }

    public void setBirdPwd(String birdPwd) {
        this.birdPwd = birdPwd;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "birdId=" + birdId +
                ", birdName='" + birdName + '\'' +
                ", birdAccount='" + birdAccount + '\'' +
                ", birdPwd='" + birdPwd + '\'' +
                '}';
    }
}
