class Solution {
    public int minOperations(String s) {
        
        int n = s.length();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - '0';
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = i % 2;
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = (i + 1) % 2;
        }
        int res = n;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                cnt++;
            }
        }
        res = Math.min(res, cnt);
        cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != c[i]) {
                cnt++;
            }
        }
        res = Math.min(res, cnt);
        return res;
    }
}