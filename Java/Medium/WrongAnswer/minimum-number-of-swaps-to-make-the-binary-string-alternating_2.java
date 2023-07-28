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
        int res = 0;
        if (c0 == c1) {
            int count0 = 0, count1 = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (s.charAt(i) == '1') {
                        count0++;
                    } else {
                        count1++;
                    }
                } else {
                    if (s.charAt(i) == '0') {
                        count0++;
                    } else {
                        count1++;
                    }
                }
            }
            res = Math.min(count0, count1);
        } else if (c0 > c1) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (s.charAt(i) == '1') {
                        count++;
                    }
                } else {
                    if (s.charAt(i) == '0') {
                        count++;
                    }
                }
            }
            res = count;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (s.charAt(i) == '0') {
                        count++;
                    }
                } else {
                    if (s.charAt(i) == '1') {
                        count++;
                    }
                }
            }
            res = count;
        }
        return res;
    }
}