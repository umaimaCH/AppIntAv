package chtioui.zelleg.restapi.model;

import java.awt.Image;
import java.sql.Timestamp;

public class AchievedService {
    
    private int idachievedservice;
       private int from;
       private int to;
       private Timestamp date;
       private Image picture;
       private int valid;
       private int idservice;
      
       
       public AchievedService(int from, int to, Timestamp date, Image picture, int valid, int idservice) {
           super();
           this.from = from;
           this.to = to;
           this.date = date;
           this.picture = picture;
           this.valid = valid;
           this.idservice = idservice;
       }
       public int getIdachievedservice() {
           return idachievedservice;
       }
       public void setIdachievedservice(int idachievedservice) {
           this.idachievedservice = idachievedservice;
       }
       public int getFrom() {
           return from;
       }
       public void setFrom(int from) {
           this.from = from;
       }
       public int getTo() {
           return to;
       }
       public void setTo(int to) {
           this.to = to;
       }
       public Timestamp getDate() {
           return date;
       }
       public void setDate(Timestamp date) {
           this.date = date;
       }
       public Image getPicture() {
           return picture;
       }
       public void setPicture(Image picture) {
           this.picture = picture;
       }
       public int getValid() {
           return valid;
       }
       public void setValid(int valid) {
           this.valid = valid;
       }
       public int getIdservice() {
           return idservice;
       }
       public void setIdservice(int idservice) {
           this.idservice = idservice;
       }
       
       
       

}
