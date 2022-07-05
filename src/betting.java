public class betting {
   
        martingale();
    }
        public static int martingale ()
        {
            int money = 1000;
            int target = 1200;
            int bet = 10;
            while (money > bet && money > 0) {
                boolean win = false;
                if (win) {
                    money += bet;
                    bet = 10;
                } else {
                    money -= bet;
                    bet *= 2;
                }

            }
            System.out.println("You have $" + money + " because you lost $" + bet);
            return money;
        }
    }

