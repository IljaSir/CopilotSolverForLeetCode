class Solution {
    public int minSwaps(String s) {
        
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        if (Math.abs(count - (n - count)) > 1) {
            return -1;
        }
        int zero = 0, one = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) != '0') {
                    zero++;
                }
                if (s.charAt(i) != '1') {
                    one++;
                }
            } else {
                if (s.charAt(i) != '1') {
                    zero++;
                }
                if (s.charAt(i) != '0') {
                    one++;
                }
            }
        }
        if (count > n - count) {
            return zero / 2;
        } else {
            return one / 2;
        }
    }
}