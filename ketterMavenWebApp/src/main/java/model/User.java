package model;

public class User {

    private String name;
    private int nrPosts;
    private int status;

    public User(String name) {
        this.name = name;
        nrPosts = 0;
        status = 0;
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrPosts() {
        return nrPosts;
    }

    public void setNrPosts(int nrPosts) {
        this.nrPosts = nrPosts;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
        
    public void increaseNrPosts(){
        nrPosts++;
    }

}
