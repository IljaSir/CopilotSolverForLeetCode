class Solution {
    public int minSwaps(String s) {
        
        int n = s.length();
        int one = 0, zero = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') one++;
            else zero++;
        }
        if (Math.abs(one - zero) > 1) return -1;
        if (one == zero) {
            int res1 = 0, res2 = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (s.charAt(i) == '1') res1++;
                    else res2++;
                } else {
                    if (s.charAt(i) == '0') res1++;
                    else res2++;
                }
            }
            return Math.min(res1, res2);
        } else {
            int res = 0;
            char c = one > zero ? '1' : '0';
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (s.charAt(i) != c) res++;
                } else {
                    if (s.charAt(i) == c) res++;
                }
            }
            return res / 2;
        }
    }
}