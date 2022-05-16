package net.seehope.pojo.vo;

public class StudentChatVo {
    private String userName;
    private String sno;
    private String userState;
    private String headerPhoto;
    private String intention;
    private Short  graduate;

    public Short getGraduate() {
        return graduate;
    }

    public void setGraduate(Short graduate) {
        this.graduate = graduate;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public String getHeaderPhoto() {
        return headerPhoto;
    }

    public void setHeaderPhoto(String headerPhoto) {
        this.headerPhoto = headerPhoto;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }


}
