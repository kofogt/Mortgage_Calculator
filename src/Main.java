public class Main {
    public static void main(String[] args) {
        statusCheck () ;
        hotel(101);
        rollDice();//6);
        System.out.println(keepRolling());
        warningMessage(1);
    }
    public  static void statusCheck(){
        System.out.println("It works");
    }
    public static void hotel(int roomNumber) {
        String  availableRoom= "status";
        switch (roomNumber) {
            case 100:
                availableRoom = "status:";
                System.out.println(availableRoom + "the room is Not available");
                break;
            case 101:
                availableRoom = "Available";
                System.out.println("Book now");
                break;
            default:
                availableRoom = "Status";
                System.out.println(availableRoom + "the room is Not available");
                break;
        }
    }
    public static int rollDice (){//int sides){
        double randomRoll = Math.random();
        double stakes = randomRoll *6;//sides;
        int roll = (int)stakes +1;
        return roll;
    }
    public static  int keepRolling(){
        int diceOne =rollDice();
        int diceTwo =rollDice();
        int rollCount = 1;
        while (!(diceOne == diceTwo)){
            diceOne =rollDice();
            diceTwo =rollDice();
            rollCount = rollCount+1;
        }
        return rollCount;
    }
    public static void warningMessage (int i){
        while (i <= 5){
            System.out.println("Be careful");
            i++;
        }
    }
}


