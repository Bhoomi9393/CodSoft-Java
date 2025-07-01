import java.util.Scanner;

class codsoft
{
    public static void main(String[]args)
    {
        Scanner Sc = new Scanner(System.in);
        int score = 0;
        int maxAttempts = 5;
        boolean playagain;

        System.out.println(".....Welcome to number guessing game.....");

        do
        {
            int attemptsLeft = maxAttempts;
            boolean correct = false;
            int randomN = (int)(Math.random() * (100 - 1 + 1) + 1);

            System.out.println("I've selected a number between 1 to 100");
            System.out.println("You have 5 attempts to guess the number");

            while (attemptsLeft > 0) 
            {
                System.out.println("Enter your Guess:");
                int guess;

                try
                {
                    guess = Integer.parseInt(Sc.nextLine());
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Please Enter a Valid Number!");
                    continue;
                }

                if(guess == randomN)
                {
                    System.out.println("Congratulations! You guessed the correct number");
                    correct = true;
                    score++;
                    break;
                }
                else if(guess < randomN)
                {
                    System.out.println("Too Low!");
                }
                else
                {
                    System.out.println("Too High!");
                }
                attemptsLeft--;
                System.out.println("Attempts Left " + attemptsLeft);
            }
            if(!correct)
            {
                System.out.println("You have no attempts left. the number was " + randomN);
            }
            System.out.println("Do you want to play another round? (Yes/No)");
            String response = Sc.nextLine().toLowerCase();
            if (!(response.equals("yes") || response.equals("y") || response.equals("no") || response.equals("n"))) 
            {
                System.out.println("Invalid response. Exiting the game.");
                break;
            }
            else
            {
            playagain = response.equals("yes")||response.equals("y");
            }
        }
        while(playagain);
        System.out.println("Game Over! Your Score: " + score);
        System.out.println("...Thanks For Playing...");
        Sc.close();
        
    }
}