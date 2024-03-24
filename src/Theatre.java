import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Theatre {
    public static ArrayList<Ticket>ticket_details = new ArrayList<>();
    public static double total;
    public static void main (String[] args) {
        //welcome massage
        System.out.println("Welcome to the Theatre ");
        //setting up the rows as arrays
        int[] row1 = new int[12];
        int[] row2 = new int[16];
        int[] row3 = new int[20];
        //assigning all the seats as 0
        for (int i = 0; i < row1.length; i++) {
            row1[i] = 0;
        }
        for (int i = 0; i < row2.length; i++) {
            row2[i] = 0;
        }
        for (int i = 0; i < row3.length; i++) {
            row3[i] = 0;
        }
        //printing the options

        while (true) {
            try {
                //Taking the option as input
                Scanner Option = new Scanner(System.in);

                System.out.println("---------------------------------------------------------");
                System.out.println("Please select an option:\n"
                        + "1) Buy a ticket\n"
                        + "2) Printing seating\n"
                        + "3) Cancel ticket\n"
                        + "4) List available seats\n"
                        + "5) Save to file\n"
                        + "6) Load from file\n"
                        + "7) Print ticket information and total price\n"
                        + "8) Sort ticket by price");
                System.out.println("---------------------------------------------------------\n");
                System.out.print("\nEnter option : ");
                int option = Option.nextInt();
                if (option < 0 || option > 8) {
                    System.out.println("invalid input. Try again!!");
                }
                switch (option) {
                    case 0:
                        System.out.println("Thank you!\nHave a nice day ! ");
                        return;
                    case 1:
                        buy_ticket(row1, row2, row3);
                        break;
                    case 2:
                        print_seating_area(row1, row2, row3);
                        break;
                    case 3:
                        cancel_ticket(row1, row2, row3);
                        break;
                    case 4:
                        show_available(row1, row2, row3);
                        break;
                    case 5:
                        save(row1, row2, row3);
                        break;
                    case 6:
                        load(row1,row2,row3);
                        break;
                    case 7:
                        show_ticket_info();
                        break;
                    case 8:
                        sort_ticket();
                        break;
                }
            }catch (Exception e){
                System.out.println("Invalid input!");
            }
        }
    }
    public static void buy_ticket(int[] row1,int[] row2,int[] row3) {
        while (true){
            try {
                while (true) {
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter the row number: "); //getting the row number input
                    int rowno = input.nextInt();
                    if (rowno<1 || rowno>3){
                        System.out.println("Enter a valid row number!");
                        continue;
                    }
                    System.out.print("Enter seat number: "); //getting the seat number input
                    int seat_no = input.nextInt();
                    if (rowno ==1 && seat_no > row1.length || (seat_no<1)){ //checking the seat number is in the range
                        System.out.println("Enter a valid seat number!");
                        continue;
                    }if (rowno ==2 && seat_no > row2.length || (seat_no<1)){
                        System.out.println("Enter a valid seat number!");
                        continue;
                    }if (rowno ==3 && seat_no > row3.length || (seat_no<1)){
                        System.out.println("Enter a valid seat number!");
                        continue;
                    }
                    switch (rowno){
                        case 1:
                            while (true){
                                try {
                                    Scanner price_in = new Scanner(System.in);
                                    System.out.println("Enter the price: "); //getting the price input
                                    double Price = price_in.nextDouble();
                                    Ticket_info_method(row1,seat_no,rowno,Price); //condition checking and booking the seat
                                }catch (Exception e){
                                    System.out.println("Enter a valid price!");
                                    continue;}
                                break;
                            }
                            break;
                        case 2:
                            while (true){
                                try {
                                    Scanner price_in = new Scanner(System.in);
                                    System.out.println("Enter the price: "); //getting the price input
                                    double Price = price_in.nextDouble();
                                    Ticket_info_method(row2,seat_no,rowno,Price); //condition checking and booking the seat
                                }catch (Exception e){
                                    System.out.println("Enter a valid price!");
                                    continue;}
                                break;
                            }
                            break;
                        case 3:
                            while (true){
                                try {
                                    Scanner price_in = new Scanner(System.in);
                                    System.out.println("Enter the price: "); //getting the price input
                                    double Price = price_in.nextDouble();
                                    Ticket_info_method(row3,seat_no,rowno,Price); //condition checking and booking the seat
                                }catch (Exception e){
                                    System.out.println("Enter a valid price!");
                                    continue;}
                                break;
                            }break;
                    }break;
                }
            } catch (Exception e) {
                System.out.println("Enter a valid number!");
                continue;}
            break;
        }
    }
    public static void Ticket_info_method(int[]Row,int seat,int row,double Price){
        if(Row[seat-1]==1){
            System.out.println("Sorry,this seat is already booked ");
        }else{
            Row[seat-1]=1;
            Scanner name =new Scanner(System.in);
            System.out.println("Enter your name: ");
            String Name = name.next();
            System.out.println("Enter your Surname: ");
            String Surname = name.next();
            System.out.println("Enter your email: ");
            String email = name.next();
            Person person1 = new Person(Name,Surname,email);
            Ticket ticket1 = new Ticket(row,seat,Price,person1);
            ticket_details.add(ticket1);
            total+=Price;
            System.out.println("You booked successfully ");
        }
    }
    public static void print_seats_method(int[] row){
        for (int i=0;i<row.length;i++) {
            if (row[i] == 0) {
                System.out.print("O");
            }if (row[i] == 1) {
                System.out.print("X");
            }if (i==(row.length/2)-1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    public static void print_seating_area(int[] row1,int[] row2,int[] row3){
        System.out.println("     ***********");
        System.out.println("     *  STAGE  *");
        System.out.println("     ***********");
        System.out.print("    ");
        print_seats_method(row1);
        System.out.print("  ");
        print_seats_method(row2);
        print_seats_method(row3);
    }
    public static void cancel_ticket(int[] row1,int[] row2,int[] row3){
        while (true){
            try {
                Scanner input2 = new Scanner(System.in);
                System.out.println("Enter the row number that you want to cancel : ");
                int  row_number = input2.nextInt();
                if (row_number<1 || row_number>3){
                    System.out.println("Enter a valid row number !");
                    continue;}
                System.out.println("Enter seat number you want to cancel : ");
                int seat_number = input2.nextInt();
                switch(row_number){
                    case 1:
                        cancel_seat_info_method(row1,seat_number,1);
                        break;
                    case 2:
                        cancel_seat_info_method(row2,seat_number,2);
                        break;
                    case 3:
                        cancel_seat_info_method(row3,seat_number,3);
                }break;
            }catch (Exception e){
                System.out.println("Enter a valid number!");
            }
        }
    }
    public static void cancel_seat_info_method(int []row_number,int seat_number,int row){
        if( row_number[seat_number-1]==1){
            row_number[seat_number-1]=0;
            for (int i =0;i<ticket_details.size();i++){
                if((ticket_details.get(i).getRow()== row )&&(ticket_details.get(i).getSeat()== seat_number)){
                    total-= ticket_details.get(i).getPrice();
                    ticket_details.remove(i);
                }
            }
            System.out.println("Successfully updated");
        }else{
            System.out.println("The seat is available!");
        }
    }
    public static void show_available(int[] row1,int[] row2,int[] row3) {
        available_seats(row1,"row1");
        available_seats(row2,"row2");
        available_seats(row3,"row1");
    }
    public static void available_seats(int[]row,String row_name){
        System.out.print("Seats available in "+row_name+ ": ");
        int i = 0;
        int j = 1;
        while (i<row.length){
            if (row[i]==0){
                System.out.print(j+",");
            }
            j++;
            i++;
        }
        System.out.print("\b.");
        System.out.println();
    }
    // text_file saving
    public static void save (int[] row1,int[] row2,int[] row3){
        try{
            FileWriter file = new FileWriter("Available seats.txt");
            text_file_save_method(file,row1);
            text_file_save_method(file,row2);
            text_file_save_method(file,row3);
            file.close();
        }catch (IOException ex){
            System.out.println(ex);
        }
        System.out.println("You Successfully saved file");
    }
    public static void text_file_save_method(FileWriter file, int[] rowNumber) throws IOException {
        for (int i = 0; i <= (rowNumber.length - 1); i++){
            file.write(rowNumber[i] + " ");
        }
        file.write("\n");
    }
    //loading file saved
    public static void load (int[] row1,int[]row2,int[]row3){
        try{
            System.out.println("Loaded from the file!");
            File textfile = new File("Available seats.txt");
            Scanner fileReader = new Scanner(textfile);
            load_file_method(row1, fileReader);
            load_file_method(row2, fileReader);
            load_file_method(row3, fileReader);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    public static void load_file_method (int[]row_num, Scanner fileReader){
        for (int i = 0; i <row_num.length; i++){
            row_num[i] = fileReader.nextInt();
        }
        fileReader.nextLine();
    }
    public static void show_ticket_info (){
        for (int i = 0; i <ticket_details.size(); i++){
            ticket_details.get(i).print();
        }
        System.out.println("total price is "+total);
    }
    private static void sort_ticket() {
        int range = ticket_details.size() - 2;
        Ticket temp;
        boolean loop = true;
        while (loop) {
            loop = false;
            for (int i = 0; i <= range; i++) {
                if (ticket_details.get(i).getPrice() > ticket_details.get(i+1).getPrice() ) {
                    temp = ticket_details.get(i);
                    ticket_details.set(i,ticket_details.get(i+1));
                    ticket_details.set(i+1,temp);
                    loop = true;
                }
            }range--;
        }
        for (int i=0;i< ticket_details.size();i++){
            ticket_details.get(i).print();
        }
        System.out.println("tital price is "+total);
    }
}


