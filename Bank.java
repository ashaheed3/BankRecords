
/* Ayanna Shaheed
 *Purpose: The purpose of the program is to create an Array List data structure
 *         for use that operates like the Array List data structure in the java 
 *         library. 
 *______________________________________________________________________________
 *Solution:     The program defines 9 methods; add(Object x), 
 *           add(int index, Object x),get(int index), size(), Empty(), isIn(Object ob), 
 *           find (Object n),and remove(Object n); to mimic the functions of array
 *           list in the java library. Four additional methods;expandCapacity(), 
 *           expandCapacity(int x), getLength(), isEmpty(int x), and isFull();  
 *           were created to simplify the problem of designing an ADT to imitate
 *           the array list in the java library.
 *                Add(Object x) appends an object to the end of the array list. In 
 *           order to add a new element to the end of the array, add(Object x) 
 *           needs to know if there is a space for the new object. So,
 *           Add(Object x)calls the method isFull() to check if the array is 
 *           full. If the array is full, Add(Object x) calls expandCapacity()
 *           to extend the size of the array to 2x list.length. Once it is established that
 *           there is a spot for Object x, a while loop checks each position
 *           in the array until it encounters a position that has a null value.
 *           The while loop calls the method isEmpty(int x), to see if a position
 *           contains an element. Object x is assigned to the first available spot
 *           add(Object x) encounters.
 *              Add(int index, Object x) inserts an object anywhere in the array.
 *           First, add(int index, Object x) uses the method isEmpty(int x) to
 *           check if the desired spot is available. If the space is empty, x is  
 *           stored in list[index]. If not, add(int index, Object x) calls the 
 *           method expandCapacity(int x) to increase the lenght of the array by one.
 *           Then using a for loop, the method shifts all the elements after 
 *           index one position to the right. Lastly, object x is assigned to list[index].
 *              Get(int index) simply returns the object that is stored in list[index].
 *              Size() returns how many elements are stored in the array. Size()
 *           starts from position 0 of the array and then calls isEmpty(int x) to 
 *           determine if the position stores an element. If is empty returns false,
 *           the size counter is incremented. Size() repeats this process until it 
 *           reaches the end of the array. Then it returns the size count.
 *              IsEmpty() determines if the array contains any elements. The method
 *           first assumes that the array is empty. IsEmpty() then calls isEmpty(int x)
 *           to check each spot in the array to see if it contains an element. If
 *           isEmpty(int x) encounters a slot that contains an element, isEmpty()
 *           returns false.
 *              IsIn(Object ob) checks if Object ob is in the array. The method
 *           compares each object in the array to object ob. If the equals
 *           method returns true, isIn()sets isIn to true and breaks out of the
 *           for loop designed to move through the array.
 *              Find(Object ob) returns position of object n. Find(Object ob)
 *           searches the array in the same manner as isIn(Object ob), except when the
 *           equals method returns true, Find(Object) returns position i.
 *              Remove(Object ob) removes Object n from array. First the method 
 *           calls isIn(Object ob) to see if the object is in the array in the 
 *           first place. If so, the method calls find(Object b) to locate the 
 *           position of the object then sets that position equal to null. Finally
 *           a for loops shifts all the elements after the position, in which the
 *           object was found, one space to the left.
 *              ExpandCapacity() doubles the length of the array. The method
 *           calls the copyOf method to copy the elements in the original array            
 *           into a temp array twice the length of the original array. ExpandCapacity();
 *           then, sets the original array equal to the temp array.
 *               ExpandCapacity(int x) ncreases length of array by x. The method
 *           works in the same way expandCapacity() does, except, expandCapacity(int x)
 *           creates a temp array of length list.length + x ExpandCapacity(int x)
 *           can also be used to decrease the length of the array if x<0.
 *           GetLength simply returns the length of the array.
 *              IsEmpty(int x) checks if a specific position in the array contains 
 *           an element by comparing the value in that position to null.
 *              IsFull() checks to see if the array is full by using size() to compare 
 *           how many elements are in the array to the length of the array. 
 *           PrintArray() uses a for loop and get() to print out all the elements
 *           in the array.
 *______________________________________________________________________________
 *Data Structures: One-Deimentional Arrays
 *______________________________________________________________________________
 *Use:  To use the program, the user must first initialize an instance of the class
 *      in a main method, then use one of the constuctors to create an array 
 *      of the default length of 10 or an array of a length of their choosing.
 *      Once that has been done the user can fill the array with elements of any type. 
 *      The user will also have access all the methods deffined in this class.
 *______________________________________________________________________________
 * Classses: The arrayList class is an ADT that mimics the behavior of the array     
 *           list in the java library. testArray.java tests all the methods of   
 *           arrayList.java for correctness, then prints out a shuffled deck of
 *           cards.
 */






package bank.java;

import java.util.*;


public class Bank {
    
    private LinkedList<records> bankRecord; 
    private records currentRecord = new records();
    
    //Initializes a linked list of record objects
    public Bank(){
        bankRecord = new LinkedList<records>(); 
    }
    
    /*Precondition: Calling code accepts a records account as an argument. Method
     *              assumes record to be added is unique
     *Postcondition: Adds record to bank record linked list and sets current record
     *               equal to new record
     */
    public void addNewRecord(records account){
        sortRecords(account);
        Bank.this.setCurrentRecord(account);
    }
    
    
    /*Precondition: Calling code accepts a records account as an argument. Method
     *              assumes record to be added is unique
     *Postcondition: Adds record to bank record linked list according to first
     *               name
     */
    public void sortRecords(records account){
        for(int i = 0; i < bankRecord.size(); i++){
          if  (account.getLastName().compareToIgnoreCase(bankRecord.get(i).getLastName()) < 0){
              bankRecord.add(i, account);
              break;
          }
        }
        if(!bankRecord.contains(account)){
           bankRecord.add(account);
        }
    }
    
    
    /*Precondition: Calling code has no parameters 
     *Postcondition: Prints out all records objects in linked list
     */
    public void printAllRecords(){
        System.out.println("First name      Last name      Balance");
        for(int i = 0; i < bankRecord.size(); i++)
            System.out.println(bankRecord.get(i));   
    }
    
    
    /*Precondition: Calling code has no parameters
      Postcondition: Method returns the linked list of records
    */
    public LinkedList<records> getRecords(){
        return bankRecord;
    }
    
    
    /*Precondition: Calling code accepts an record account as an argument 
     *Postcondition: Sets currentRecord equal to account
     */
    public void setCurrentRecord(records account){
        currentRecord = account;
    }
    
    
    /*Precondition: Calling code accepts a String name of an account already in 
     *              in the record. The mathod assumes that the string is the first
     *              name of a record object already in the record.
     *Postcondition: Selects a record object from the linked list to become current 
     *               record.
     */
    public void setCurrentRecord(String firstName, String lastName){
        removeCurrentRecord();
        for(int i = 0; i < bankRecord.size(); i++){
            if ((firstName.compareTo(bankRecord.get(i).getFirstName()) == 0) && (lastName.compareTo(bankRecord.get(i).getLastName()) == 0) ){
                currentRecord = bankRecord.get(i);
                break;
            
            }
        }
        if(currentRecord == null)
            System.out.println("No matching record exists");
    }
    
    
    /*Precondition: Calling code has no parameters 
     * Postcondition: Sets current record equal to null
     */
    public void removeCurrentRecord(){
        currentRecord = null;
    }
    
    
    /*Precondition: Calling code accepts a String as an argument to be the new 
     *              first name of current record 
     *Postcondition: Changes first name of the current record and corresponding 
     *               bank record
     */
    public void changeCRFirstName(String newName){
        for(int i = 0; i < bankRecord.size(); i++){
            if(currentRecord.getFirstName().compareToIgnoreCase(bankRecord.get(i).getFirstName()) == 0 && currentRecord.getLastName().compareToIgnoreCase(bankRecord.get(i).getLastName()) == 0){
              bankRecord.get(i).changeFirstName(newName);   
              currentRecord.changeFirstName(newName);
            }
        }        
    }
    
    
    /*Precondition: Calling code accepts a String as an argument to be the new 
     *              last name of current record 
     *Postcondition: Changes last name of the current record and corresponding 
     *               bank record.
     */
    public void changeCRLastName(String newName){
        for(int i = 0; i < bankRecord.size(); i++){
            if(currentRecord.getFirstName().compareToIgnoreCase(bankRecord.get(i).getFirstName()) == 0 && currentRecord.getLastName().compareToIgnoreCase(bankRecord.get(i).getLastName()) == 0){
              bankRecord.get(i).changeLastName(newName);   
              currentRecord.changeLastName(newName);
              sortRecords(currentRecord);
              bankRecord.removeLastOccurrence(currentRecord);
            }
        }      
    }   
    
    
    /*Precondition: Calling code accepts a double, where x >= 0.0, as an argument 
     *              to add to the balance of the current record and corresponding bank record.
     *             
     *Postcondition: Changes balance of the current record and corresponding 
     *               bank record.
     */
    public void addDepositCR(double num){
        for(int i = 0; i < bankRecord.size(); i++){
            if(currentRecord.getFirstName().compareToIgnoreCase(bankRecord.get(i).getFirstName()) == 0 && currentRecord.getLastName().compareToIgnoreCase(bankRecord.get(i).getLastName()) == 0){
              bankRecord.get(i).changeBalance(num);   
              currentRecord.changeBalance(num);
            }
        }      
    }
    
    
    /*Precondition: Calling code accepts a double, where x >= 0.0, as an argument 
     *              to subtract from the balance of the current record and 
     *              the corresponding bank record.            
     *Postcondition: Changes balance of the current record and corresponding 
     *               bank record.
     */
    public void makeWithdrawalCR(double num){
        for(int i = 0; i < bankRecord.size(); i++){
            if(currentRecord.getFirstName().compareToIgnoreCase(bankRecord.get(i).getFirstName()) == 0 && currentRecord.getLastName().compareToIgnoreCase(bankRecord.get(i).getLastName()) == 0){
              bankRecord.get(i).changeBalance(-num);   
              currentRecord.changeBalance(-num);
            }
        } 
    }
    
    
    /*Precondition: Calling code has no parameters
      Postcondition: Method returns the current record
    */
    public records getcurrentRecord(){
        return currentRecord;
    }
    
    
    /*Precondition: Calling code has no parameters 
     *Postcondition: Prints out bank menu.
     */
    public void displayMenu(){
        System.out.println("a Show all records\n" +
                           "r Remove the current record\n" +
                           "f Change the first name in the current record\n" +
                           "l Change the last name in the current record\n" +
                           "n Add a new record\n" +
                           "d Add a deposit to the current record\n" +
                           "w Make a withdrawal from the current record\n" +
                           "q Quit\n" +
                           "s Select a record from the record list to become the current record\n");   
    }    
    
     
    public static void main(String[] args) {
        
        boolean run = true;
        Scanner in = new Scanner(System.in);
        String response, response1;
        double num;
       
        //initialize linked list of records        
        Bank bankrecords = new Bank();
        
       
        //while true run program
        while(run){
        
            //Dispaly menu
            bankrecords.displayMenu();
        
            //Prompt user for command
            System.out.println("Enter a command from the list above (q to quit): ");
            response = in.nextLine();
                
        
            //switch statement for all bank menu options
           switch(response.trim().toLowerCase()) {
                case "a":
                    //Shows all records
                    if(bankrecords.getRecords().isEmpty()){
                    System.out.println("No records exist!!!");
                        }else{
                            bankrecords.printAllRecords();
                    }
                    break;
                case "r":
                    //Removes current record
                    bankrecords.removeCurrentRecord();
                    break;
                case "f":
                    //Changes first name of current record
                    System.out.println("Enter new first name: ");
                    response = in.nextLine();
                    bankrecords.changeCRFirstName(response);
                    break;
                case "l":
                    //Changes last name of current record
                    System.out.println("Enter new last name: ");
                    response = in.nextLine();
                    bankrecords.changeCRLastName(response); 
                    break;
                case "n":
                    //Creates new record
                    System.out.println("Enter First name: ");
                    response = in.nextLine();
                    System.out.println("Enter Last name: ");
                    response1 = in.nextLine();
                    System.out.println("Enter the balance amount: ");
                    num = in.nextDouble();
                    bankrecords.addNewRecord(new records(response,response1,num));
                    System.out.println("Current record is: " + bankrecords.getcurrentRecord());
                    break;
                case "d":
                    //Adds deposit to current record
                    System.out.println("Enter Deposit: ");
                    num = in.nextDouble();
                    bankrecords.addDepositCR(num);
                    break;
                case "w":
                    //Makes withdrawal from current record
                    System.out.println("Enter Withdrawal: ");
                    num = in.nextDouble();
                    bankrecords.makeWithdrawalCR(num);
                    break;
                case "q":
                    //Quits program
                    run = false;
                    break;
                case "s":
                    //Selects new record to be current record
                    System.out.println("Enter first name: ");
                    response = in.nextLine();
                    System.out.println("Enter last name: ");
                    response1 = in.nextLine();
                    bankrecords.setCurrentRecord(response, response1);
                    break;
                default:
                    break;
            } 
        }
    }
}
         
    