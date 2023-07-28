class Solution {
    public long kMirror(int k, int n) {
        
        long s = 0;
        for (int i = 1; i <= n; i++) {
            s += mirror(i, k);
        }
        return s;
    }
    public long mirror(long n, int k) {
        long r = 0;
        while (n > 0) {
            r = r * k + n % k;
            n /= k;
        }
        return r;
    }
}