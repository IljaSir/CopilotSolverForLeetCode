class Solution {
    public boolean sumGame(String num) {
        
        int n = num.length();
        int left = 0, right = 0, q = 0;
        for (int i = 0; i < n / 2; ++i) {
            if (num.charAt(i) == '?') {
                q++;
            } else {
                left += num.charAt(i) - '0';
            }
        }
        for (int i = n / 2; i < n; ++i) {
            if (num.charAt(i) == '?') {
                q++;
            } else {
                right += num.charAt(i) - '0';
            }
        }
        if (q % 2 == 1) {
            return true;
        }
        int diff = left - right;
        return diff != 0 && diff != q / 2 * 9;
    }
}