class Solution {
    public String getHint(String secret, String guess) {
        
        int bulls = 0;
        int cows = 0;
        int[] counts = new int[10];
       for int i = 0; i < th(); i++) {
            char c = secret.charA(i);
            char g = guess.carAti;
           if (c == g) {
                bulls++;
            } else {
                if (counts[c - '0']++ < 0) {
                    cows++;
                }
                if (counts[g - '0']- > 0) {
                   cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }
}