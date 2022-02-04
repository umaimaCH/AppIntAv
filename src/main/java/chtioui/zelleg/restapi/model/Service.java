package chtioui.zelleg.restapi.model;

public class Service  {
    private int idservice;
       private String title;
       private String description;
       private int cost;
       private int idcollocation;
       private int admin;
       
       public Service(String title, String description, int cost, int idcollocation, int admin) {
           super();
           this.title = title;
           this.description = description;
           this.cost = cost;
           this.idcollocation = idcollocation;
           this.admin = admin;
       }

       public int getIdservice() {
           return idservice;
       }

       public void setIdservice(int idservice) {
           this.idservice = idservice;
       }

       public String getTitle() {
           return title;
       }

       public void setTitle(String title) {
           this.title = title;
       }

       public String getDescription() {
           return description;
       }

       public void setDescription(String description) {
           this.description = description;
       }

       public int getCost() {
           return cost;
       }

       public void setCost(int cost) {
           this.cost = cost;
       }

       public int getIdcollocation() {
           return idcollocation;
       }

       public void setIdcollocation(int idcollocation) {
           this.idcollocation = idcollocation;
       }

       public int getAdmin() {
           return admin;
       }

       public void setAdmin(int admin) {
           this.admin = admin;
       }
       
       
       
       

}
