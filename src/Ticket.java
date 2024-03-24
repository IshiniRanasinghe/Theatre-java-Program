public class Ticket {
    int row;
    int seat;
    double price;
    Person person1 = new Person();
    public Ticket(int row, int seat, double price, Person person1) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person1 = person1;
    }
    public Ticket(){
        this.row = 0;
        this.seat = 0;
        this.price = 0.0;
        this.person1 = new Person();
    }
    public void  print(){
        System.out.println(
                "\n"+"your name : "+person1.name+"  "+person1.surname
                +"\n" +"Your email :  "+person1.email
                +"\n"+"The number of row : "+row
                +"\n"+"The number of seat : "+seat
                +"\n"+"Price :  "+price+"\n");
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }
}
