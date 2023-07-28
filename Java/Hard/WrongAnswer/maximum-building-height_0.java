class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        int m = restrictions.length;
        for (int i = 0; i < m; i++) {
            restrictions[i][0]--;
        }
        for (int i = m - 1; i >= 0; i--) {
            int[] r = restrictions[i];
            if (i < m - 1) {
                r[1] = Math.min(r[1], restrictions[i + 1][1] + restrictions[i + 1][0] - r[0]);
            }
            r[1] = Math.min(r[1], r[0] + r[1]);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int[] r = restrictions[i];
            if (i > 0) {
                int[] r2 = restrictions[i - 1];
                ans = Math.max(ans, (r[1] - r2[1] + r[0] - r2[0]) / 2);
            }
            ans = Math.max(ans, r[1]);
        }
        if (m == 0 || restrictions[m - 1][0] < n - 1) {
            int[] r = m == 0 ? new int[] {0, 0} : restrictions[m - 1];
            ans = Math.max(ans, r[1] + n - 1 - r[0]);
        }
        return ans;
    }
}