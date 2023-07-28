class Solution {
    public boolean sumGame(String num) {
        
        int len = num.length();
        int half = len / 2;
        int sum = 0;
        int q = 0;
        for (int i = 0; i < half; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                q++;
            } else {
                sum += c - '0';
            }
        }
        for (int i = half; i < len; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                q--;
            } else {
                sum -= c - '0';
            }
        }
        if (q == 0) {
            return sum != 0;
        }
        if (q % 2 == 0) {
            return false;
        }
        int halfQ = q / 2;
        return sum + 9 * halfQ != 9 * halfQ;
    }
}