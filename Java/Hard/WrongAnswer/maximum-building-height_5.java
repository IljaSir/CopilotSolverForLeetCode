class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        
        int m = restrictions.length;
        int[][] r = new int[m + 2][2];
        r[0][0] = 1;
        r[0][1] = 0;
        for (int i = 0; i < m; i++) {
            r[i + 1][0] = restrictions[i][0];
            r[i + 1][1] = restrictions[i][1];
        }
        r[m + 1][0] = n;
        r[m + 1][1] = n - 1;
        Arrays.sort(r, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < r.length; i++) {
            r[i][1] = Math.min(r[i][1], r[i - 1][1] + r[i][0] - r[i - 1][0]);
        }
        for (int i = r.length - 2; i >= 0; i--) {
            r[i][1] = Math.min(r[i][1], r[i + 1][1] + r[i + 1][0] - r[i][0]);
        }
        int ans = 0;
        for (int i = 1; i < r.length; i++) {
            ans = Math.max(ans, Math.abs(r[i][0] - r[i - 1][0]) + Math.min(r[i][1], r[i - 1][1]));
        }
        return ans;
    }
}