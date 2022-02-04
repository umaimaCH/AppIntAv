package chtioui.zelleg.restapi.model;

public class Collocation   {
    
    private int idcollocation;
       private String name;
       private int iduser;
       
       public Collocation(String name, int iduser) {
           super();
           this.name = name;
           this.iduser = iduser;
       }
       public int getIdcollocation() {
           return idcollocation;
       }
       public void setIdcollocation(int idcollocation) {
           this.idcollocation = idcollocation;
       }
       public String getName() {
           return name;
       }
       public void setName(String name) {
           this.name = name;
       }
       public int getIduser() {
           return iduser;
       }
       public void setIduser(int iduser) {
           this.iduser = iduser;
       }

}
