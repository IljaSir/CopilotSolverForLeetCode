class Solution {
    public int minSwaps(String s) {
        
        int n = s.length();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - '0';
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i] ^ (i & 1);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] != i) {
                    cnt++;
                }
                if (b[j] != i) {
                    cnt--;
                }
                if (j >= n - 1) {
                    break;
                }
                if (cnt < 0) {
                    cnt = 0;
                }
            }
            if (cnt == 0) {
                res = Math.min(res, cnt);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}