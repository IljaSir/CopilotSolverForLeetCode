class Solution {
    public int minOperations(String s) {
        
        int n = s.length();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = s.charAt(i) - '0';
            b[i] = 1 - a[i];
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                if (a[i] != 0) {
                    ++res;
                }
                if (b[i] != 1) {
                    ++res;
                }
            } else {
                if (a[i] != 1) {
                    ++res;
                }
                if (b[i] != 0) {
                    ++res;
                }
            }
        }
        return Math.min(res, n - res);
    }
}