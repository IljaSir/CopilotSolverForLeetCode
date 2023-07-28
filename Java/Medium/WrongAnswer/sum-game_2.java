class Solution {
    public boolean sumGame(String num) {
        
        int n = num.length();
        int q = 0;
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '?') {
                q++;
            } else if (i < n / 2) {
                a += num.charAt(i) - '0';
            } else {
                b += num.charAt(i) - '0';
            }
        }
        int c = q / 2;
        int d = q - c;
        if (q % 2 == 1) {
            return true;
        }
        return a + c * 9 != b + d * 9;
    }
}