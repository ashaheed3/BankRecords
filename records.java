
package bank.java;


public class records {
    
    private String firstName, lastName, account;
    private double balance;
    
    
    public records(){
        firstName = null;
        lastName = null;
        balance = 0;
    }
    
    public records(String name, String name1, double num){
       firstName = name+"   ";
       lastName = name1+"   ";
       balance = num;
    }
    
    public String getAccountName(){
         return account;
     }
     
     public String getFirstName(){
         return firstName;
     }
     
     public String getLastName(){
         return lastName;
     }
     
     public double getBalance(){
         return balance;
     }
     
     public void changeFirstName(String name){
         firstName = name;
         
     }
     
     public void changeLastName(String name){
         lastName = name;
     }
      
     public void changeBalance(double num){
         balance += num;
     }
     
     //@Override
     public String toString(){
         return  firstName + "      " + lastName + "      $"+ balance ;
     }
     
}
