class Solution {
    public String getHint(String secret, String guess) {
        
        int[] num = new int[10];
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                bull++;
            } else {
                if (num[c1 - '0'] < 0) {
                    cow++;
                }
                if (num[c2 - '0'] > 0) {
                    cow++;
                }
                num[c1 - '0']++;
                num[c2 - '0']--;
            }
        }
        return bull + "A" + cow + "B";
    }
}