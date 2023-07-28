class Solution {
    public String getHint(String secret, String guess) {
        
        int a = 0, b = 0;
        int[] s = new int[10];
        int[] g = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                a++;
            } else {
                s[c1 - '0']++;
                g[c2 - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            b += Math.min(s[i], g[i]);
        }
        return a + "A" + b + "B";
    }
}