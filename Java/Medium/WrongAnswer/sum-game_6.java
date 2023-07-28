class Solution {
    public boolean sumGame(String num) {
        
        int n = num.length();
        int half = n / 2;
        int q = 0;
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                q++;
            } else {
                int d = c - '0';
                if (i < half) {
                    s1 += d;
                } else {
                    s2 += d;
                }
            }
        }
        if (q % 2 == 1) {
            return true;
        }
        int halfQ = q / 2;
        int halfQ1 = halfQ * 9;
        int halfQ2 = halfQ * 0;
        return s1 + halfQ1 != s2 + halfQ2;
    }
}