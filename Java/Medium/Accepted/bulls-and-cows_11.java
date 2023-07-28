class Solution {
    public String getHint(String secret, String guess) {
        
        int bulls = 0;
        int cows = 0;
        int[] counts = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            char g = guess.charAt(i);
            if (c == g) {
                bulls++;
            } else {
                if (counts[c - '0']++ < 0) {
                    cows++;
                }
                if (counts[g - '0']-- > 0) {
                    cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }
}