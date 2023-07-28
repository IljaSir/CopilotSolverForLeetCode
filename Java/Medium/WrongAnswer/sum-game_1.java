class Solution {
    public boolean sumGame(String num) {
        
        int n = num.length();
        int q = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < n / 2; ++i) {
            if (num.charAt(i) == '?') ++q;
            else a += num.charAt(i) - '0';
        }
        for (int i = n / 2; i < n; ++i) {
            if (num.charAt(i) == '?') ++q;
            else b += num.charAt(i) - '0';
        }
        if ((q & 1) == 1) return true;
        if (a == b) return false;
        if (a > b) {
            return (a - b) > q / 2 * 9;
        } else {
            return (b - a) > q / 2 * 9;
        }
    }
}