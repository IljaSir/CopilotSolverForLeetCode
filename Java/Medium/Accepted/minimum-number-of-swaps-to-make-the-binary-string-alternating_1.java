class Solution {
    public int minSwaps(String s) {
        
        int n = s.length();
        int c0 = 0, c1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                c0++;
            } else {
                c1++;
            }
        }
        if (Math.abs(c0 - c1) > 1) {
            return -1;
        }
        if (c0 > c1) {
            return minSwaps(s, '0');
        } else if (c0 < c1) {
            return minSwaps(s, '1');
        } else {
            return Math.min(minSwaps(s, '0'), minSwaps(s, '1'));
        }
    }

    private int minSwaps(String s, char c) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != c) {
                ans++;
            }
            c = c == '0' ? '1' : '0';
        }
        return ans / 2;
    }
}