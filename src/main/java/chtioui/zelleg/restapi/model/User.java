package chtioui.zelleg.restapi.model;

public class User  {
    
    private int iduser;
       private String email;
       private String password;
       private String lastname;
       private String firstname;
       private int score;
       
       
       public User(String email, String password, String lastname, String firstname, int score) {

           this.setEmail(email);
           this.setPassword(password);
           this.setLastname(lastname);
           this.setFirstname(firstname);
           this.setScore(score);
       }

       public User() {
           
       }
       

       public int getIduser() {
           return iduser;
       }

       public void setIduser(int iduser) {
           this.iduser = iduser;
       }

       public String getEmail() {
           return email;
       }

       public void setEmail(String email) {
           this.email = email;
       }

       public String getPassword() {
           return password;
       }

       public void setPassword(String password) {
           this.password = password;
       }

       public String getLastname() {
           return lastname;
       }

       public void setLastname(String lastname) {
           this.lastname = lastname;
       }

       public String getFirstname() {
           return firstname;
       }

       public void setFirstname(String firstname) {
           this.firstname = firstname;
       }

       public int getScore() {
           return score;
       }

       public void setScore(int score) {
           this.score = score;
       }

}