class Solution {
    public boolean sumGame(String num) {
        
        int n = num.length();
        int left = 0, right = 0, q = 0;
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '?') {
                if (i < n / 2) {
                    left++;
                } else {
                    right++;
                }
                q++;
            } else {
                if (i < n / 2) {
                    left += num.charAt(i) - '0';
                } else {
                    right += num.charAt(i) - '0';
                }
            }
        }
        if (q % 2 == 1) {
            return true;
        }
        return left != right;
    }
}