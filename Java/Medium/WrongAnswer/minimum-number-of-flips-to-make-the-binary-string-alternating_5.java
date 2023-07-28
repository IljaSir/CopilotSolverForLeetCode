class Solution {
    public int minFlips(String s) {
        
        int n = s.length();
        int[] a = new int[n*2];
        for (int i = 0; i < n; i++) {
            a[i] = a[i+n] = s.charAt(i) - '0';
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (a[i+j] != cur) {
                    cur ^= 1;
                    res = Math.min(res, j+1);
                }
            }
            if (res == 1) return 1;
        }
        return res;
    }
}