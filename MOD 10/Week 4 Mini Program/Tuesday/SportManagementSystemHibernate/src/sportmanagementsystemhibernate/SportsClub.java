package sportmanagementsystemhibernate;
// Generated Jul 21, 2020 12:10:09 PM by Hibernate Tools 4.3.1



/**
 * SportsClub generated by hbm2java
 */
public class SportsClub  implements java.io.Serializable {


     private String sportType;
     private int age;
     private int wins;

    public SportsClub() {
    }

    public SportsClub(String sportType, int age, int wins) {
       this.sportType = sportType;
       this.age = age;
       this.wins = wins;
    }
   
    public String getSportType() {
        return this.sportType;
    }
    
    public void setSportType(String sportType) {
        this.sportType = sportType;
    }
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    public int getWins() {
        return this.wins;
    }
    
    public void setWins(int wins) {
        this.wins = wins;
    }




}


