class Solution {
    public int minFlips(String s) {
        
        int n = s.length();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - '0';
        }
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                b[i] = 0;
                c[i] = 1;
                d[i] = 1;
            } else {
                b[i] = 1;
                c[i] = 0;
                d[i] = 1;
            }
        }
        int[] e = new int[n];
        int[] f = new int[n];
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                e[i] = 1;
                f[i] = 1;
                g[i] = 0;
            } else {
                e[i] = 0;
                f[i] = 1;
                g[i] = 1;
            }
        }
        return Math.min(Math.min(minFlips(a, b), minFlips(a, c)), Math.min(minFlips(a, d), Math.min(minFlips(a, e), Math.min(minFlips(a, f), minFlips(a, g)))));
    }
    private int minFlips(int[] a, int[] b) {
        int n = a.length;
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = a[i] == b[i] ? 0 : 1;
        }
        int[] d = new int[n];
        d[0] = c[0];
        for (int i = 1; i < n; i++) {
            d[i] = d[i - 1] + c[i];
        }
        int[] e = new int[n];
        e[0] = 0;
        for (int i = 1; i < n; i++) {
            e[i] = e[i - 1] + d[i - 1];
        }
    }
}