class Solution {
    public String getHint(String secret, String guess) {
        
        int bulls = 0;
        int cows = 0;
        int[] cnt = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                cnt[secret.charAt(i) - '0']++;
                cnt[guess.charAt(i) - '0']--;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (cnt[i] > 0) {
                cows += cnt[i];
            }
        }
        return bulls + "A" + (secret.length() - bulls - cows) + "B";
    }
}