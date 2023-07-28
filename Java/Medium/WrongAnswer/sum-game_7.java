class Solution {
    public boolean sumGame(String num) {
        
        int n = num.length();
        int half = n / 2;
        int q = 0;
        int sum = 0;
        for (int i = 0; i < half; i++) {
            if (num.charAt(i) == '?') {
                q++;
            } else {
                sum += num.charAt(i) - '0';
            }
        }
        int sum2 = 0;
        for (int i = half; i < n; i++) {
            if (num.charAt(i) == '?') {
                q--;
            } else {
                sum2 += num.charAt(i) - '0';
            }
        }
        if (q == 0) {
            return sum != sum2;
        }
        return (q & 1) == 1 || sum != sum2;
    }
}