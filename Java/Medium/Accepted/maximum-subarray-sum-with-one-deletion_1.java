class Solution {
    public int maximumSum(int[] arr) {
        
        int n = arr.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = arr[0];
        g[0] = arr[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1] + arr[i], arr[i]);
            g[i] = Math.max(f[i - 1], g[i - 1] + arr[i]);
        }
        int ans = arr[0];
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.max(f[i], g[i]));
        }
        return ans;
    }
}