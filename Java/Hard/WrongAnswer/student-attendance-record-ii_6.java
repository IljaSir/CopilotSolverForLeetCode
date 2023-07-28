class Solution {
    public int checkRecord(int n) {
        
        int mod = 1000000007;
        long[] A = new long[n];
        long[] P = new long[n];
        long[] L = new long[n];
        P[0] = 1;
        L[0] = 1;
        A[0] = 1;
        A[1] = 2;
        P[1] = 2;
        L[1] = 3;
        for (int i = 2; i < n; i++) {
            P[i] = ((P[i - 1] + L[i - 1]) % mod + A[i - 1]) % mod;
            L[i] = ((P[i - 1] + P[i - 2]) % mod + A[i - 1]) % mod;
            A[i] = ((P[i - 1] + L[i - 1]) % mod + A[i - 1]) % mod;
        }
        return (int) ((P[n - 1] + L[n - 1]) % mod + A[n - 1]) % mod;
    }
}