class Solution {
    public int checkRecord(int n) {
        
        int mod = 1000000007;
        long[] a = new long[n+1];
        long[] p = new long[n+1];
        long[] l = new long[n+1];
        a[0] = 1;
        p[0] = 1;
        l[0] = 1;
        for (int i = 1; i <= n; i++) {
            a[i] = (a[i-1] + p[i-1] + l[i-1]) % mod;
            p[i] = (a[i-1] + p[i-1] + l[i-1]) % mod;
            l[i] = (p[i-1] + a[i-1]) % mod;
        }
        long res = (a[n] + p[n] + l[n]) % mod;
        for (int i = 1; i <= n; i++) {
            long tmp = (a[i-1] * a[n-i]) % mod;
            tmp = (tmp * p[n-i]) % mod;
            res = (res + tmp) % mod;
        }
        return (int)res;
    }
}