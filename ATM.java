import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    static int userId = 9876;
    static int userPin = 9632;
    static int noTrial = 3;
    static int TotalBalance=100000;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> arr=new ArrayList<String>();
    static String Str;
    static SimpleDateFormat formatter = new 
    SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Date date = new Date();

    public static void History(String str){                                       //Add transaction history to arrayList

        arr.add(str);
    }

public static void TransactionHistory(){                       //Show transaction history from arrayList by foreach loop
        //System.out.println(arr);
        for(String his:arr){
            System.out.println(his);
        }
    System.out.println();
    }

    public static void checkUserPinAndId() {                           //check user details and give them maximum trials
        if (noTrial >= 0) {

            System.out.print("Give your user id");
            int cUserId = sc.nextInt();


            if (userId == cUserId) {
                System.out.print("Give your user pin");
                int cUserPin = sc.nextInt();
                if (userPin == cUserPin) {
                    Main();
                } else {
                    System.out.println("You have entered wrong pin");
                    noTrial--;
                    checkUserPinAndId();
                }
            }
            else {
                System.out.println("you have entered wrong userid");
                noTrial--;
                checkUserPinAndId();
            }

        }
        else{
            System.out.println("you are block please visit your nearest bank");
        }
    }
    public static void  Withdraw(){                                                                     //For Withdrawal
        System.out.print("Enter amount of withdrawal: ");
        int withdrawAmount=sc.nextInt();
        System.out.print("Give your user pin");
        int cUserPin = sc.nextInt();
        if(cUserPin==userPin){
            if(withdrawAmount<TotalBalance-2000){
                TotalBalance=TotalBalance-withdrawAmount;
                System.out.println("--------------WITHDRAWAL SUCCESSFUL-------------");
                System.out.println("------------Remaining balance: "+"'"+TotalBalance+"' " +"-------------");
                Str= formatter.format(date)+"  WITHDRAW             "+ "'-"+withdrawAmount+"'  '"+TotalBalance+"'";

                History(Str);                                                                // save transaction history
            }
                else{
                    System.out.println("oho not enough balance");
                }
        }
                else  {
                System.out.println("wrong pin" );
            }
        System.out.println("-------------------------------------------");

    }
public static void Deposit(){                                                                             //For Deposit
    System.out.println("Enter amount you want to deposit");
    int depositAmount=sc.nextInt();
    TotalBalance=TotalBalance+depositAmount;
    System.out.println("-----------DEPOSITED SUCCESSFUL-----------");
    System.out.println("-------Total Balance "+"'"+TotalBalance+"' "+"--------");
    System.out.println("--------------------------------------------");
    Str= formatter.format(date)+"  DEPOSIT             "+ "'+"+depositAmount+"'  '"+TotalBalance+"'";

     History(Str);                                                                          // save transaction history
}

    public static void Transfer() {                                                                //For money Transfer

        System.out.print("enter userid to whom you want to transfer : ");
        int transferUserId= sc.nextInt();
        System.out.println("ENTER AMOUNT");
        int transferAmount=sc.nextInt();
        TotalBalance=TotalBalance-transferAmount;
        System.out.println("-------TRANSFER SUCCESSFUL-------");
        System.out.println("             Money transfer to user-id : "+transferUserId);
        System.out.println("             Transfer Amount was: "+transferAmount);
        System.out.println("             Total remaining Amount="+TotalBalance);
        System.out.println("-------------------------------------------------------------------------");
        Str= formatter.format(date)+"  TRANSFER TO id: "+transferUserId+ " '-"+transferAmount+"'  '"+TotalBalance+"'";

        History(Str);                                                                        // save transaction history
    }

    public static void Main(){
        boolean run=true;
        while(run){
            int event;
            System.out.println("Enter 1 for WITHDRAWAL ");
            System.out.println("Enter 2 for DEPOSIT ");
            System.out.println("Enter 3 for  TRANSFER ");
            System.out.println("Enter 4 for  TRANSACTION HISTORY");
            System.out.println("Enter 5 for  QUIT");
            event=sc.nextInt();
            switch (event){
                case 1:{
                    Withdraw();
                    break;
                }
                case 2:{
                    Deposit();
                    break;
                }
                case 3 :{
                    Transfer();
                    break;
                }
                case 4:{
                   TransactionHistory();
                    break;
                }
                case 5:{
                    run=false;
                    break;
                }
                default:{
                    System.out.println(" Invalid option");
                }
            }

        }
    }



    public static void main(String[] args) {
        System.out.println("--------------------------------- WELCOME TO ATM ---------------------------------");
        checkUserPinAndId();

    }

}
