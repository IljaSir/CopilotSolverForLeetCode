class Solution {
    public String getHint(String secret, String guess) {
        
        int[] secretDigits = new int[10];
        int[] guessDigits = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            int secretDigit = secret.charAt(i) - '0';
            int guessDigit = guess.charAt(i) - '0';
            if (secretDigit == guessDigit) {
                bulls++;
            } else {
                secretDigits[secretDigit]++;
                guessDigits[guessDigit]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretDigits[i], guessDigits[i]);
        }
        }
        return bulls + "A" + (secret.length() - bulls - cows) + "B";
    }
}