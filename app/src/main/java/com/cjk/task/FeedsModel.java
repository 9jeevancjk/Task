package com.cjk.task;

public class FeedsModel {
    private String  CampusName;
    private String ProfileName;
    private  String ActivityType;
    private String Postdate;
    private  String Paragraph;
    private  int ProfilePicture;
    private int PostImage;

    public String getCampusName() {
        return CampusName;
    }

    public void setCampusName(String campusName) {
        CampusName = campusName;
    }

    public String getProfileName() {
        return ProfileName;
    }

    public void setProfileName(String profileName) {
        ProfileName = profileName;
    }

    public String getActivityType() {
        return ActivityType;
    }

    public void setActivityType(String activityType) {
        ActivityType = activityType;
    }

    public String getPostdate() {
        return Postdate;
    }

    public void setPostdate(String postdate) {
        Postdate = postdate;
    }

    public String getParagraph() {
        return Paragraph;
    }

    public void setParagraph(String paragraph) {
        Paragraph = paragraph;
    }

    public int getProfilePicture() {
        return ProfilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        ProfilePicture = profilePicture;
    }

    public int getPostImage() {
        return PostImage;
    }

    public void setPostImage(int postImage) {
        PostImage = postImage;
    }

    public FeedsModel(int ProfilePicture, String ProfileName, String CampusName, String ActivityType, String Postdate,
                      String Paragraph, int PostImage){
        this.ProfilePicture = ProfilePicture;
        this.CampusName = CampusName;
        this.ProfileName = ProfileName;
        this.ActivityType = ActivityType;
        this.Postdate = Postdate;
        this.Paragraph = Paragraph;
        this.PostImage = PostImage;

    }


}
