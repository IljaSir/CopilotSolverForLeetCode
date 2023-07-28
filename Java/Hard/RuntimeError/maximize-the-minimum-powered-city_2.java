class Solution {
    public long maxPower(int[] stations, int r, int k) {
        
        int n = stations.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = stations[i];
        }
        long l = 0, h = 1_000_000_000_000_000_000L;
        while (l < h) {
            long m = (l + h + 1) / 2;
            if (possible(a, r, k, m)) {
                l = m;
            } else {
                h = m - 1;
            }
        }
        return l;
    }
    
    private boolean possible(long[] a, int r, int k, long m) {
        int n = a.length;
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i] + r * m;
        }
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (b[i] < a[i]) {
                return false;
            }
            while (j < n && b[j] < a[i]) {
                j++;
            }
            k -= j - i;
        }
        return k >= 0;
    }
}