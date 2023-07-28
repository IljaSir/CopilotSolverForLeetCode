class Solution {
    public int[] beautifulArray(int n) {
        
        int[] ans = new int[n];
        ans[0] = 1;
        int m = 1;
        while (m < n) {
            int t = 0;
            for (int i = 0; i < m; i++) {
                if (2 * ans[i] - 1 <= n) {
                    ans[t++] = 2 * ans[i] - 1;
                }
            }
            for (int i = 0; i < m; i++) {
                if (2 * ans[i] <= n) {
                    ans[t++] = 2 * ans[i];
                }
            }
            m = t;
        }
        return ans;
    }
}