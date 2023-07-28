class Solution {
    public int minSwaps(String s) {
        
        int n = s.length();
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') cnt1++;
            } else {
                if (s.charAt(i) == '0') cnt1++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') cnt2++;
            } else {
                if (s.charAt(i) == '1') cnt2++;
            }
        }
        if (n % 2 == 0) {
            if (cnt1 == cnt2) {
                return cnt1 / 2;
            } else {
                return -1;
            }
        } else {
            if (cnt1 == cnt2 + 1) {
                return cnt1 / 2;
            } else if (cnt1 + 1 == cnt2) {
                return cnt2 / 2;
            } else {
                return -1;
            }
        }
    }
}