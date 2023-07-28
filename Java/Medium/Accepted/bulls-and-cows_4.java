class Solution {
    public String getHint(String secret, String guess) {
        
        int[] count = new int[10];
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                if (count[secret.charAt(i) - '0']++ < 0) {
                    cow++;
                }
                if (count[guess.charAt(i) - '0']-- > 0) {
                    cow++;
                }
            }
        }
        return bull + "A" + cow + "B";
    }
}