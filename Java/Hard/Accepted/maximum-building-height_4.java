class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        
        int m = restrictions.length;
        int[][] rs = new int[m+2][2];
        for (int i = 0; i < m; i++) {
            rs[i] = restrictions[i];
        }
        rs[m][0] = 1;
        rs[m][1] = 0;
        rs[m+1][0] = n;
        rs[m+1][1] = n - 1;
        Arrays.sort(rs, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < m+2; i++) {
            rs[i][1] = Math.min(rs[i][1], rs[i-1][1] + (rs[i][0] - rs[i-1][0]));
        }
        for (int i = m+1; i > 0; i--) {
            rs[i-1][1] = Math.min(rs[i-1][1], rs[i][1] + (rs[i][0] - rs[i-1][0]));
        }
        int res = 0;
        for (int i = 1; i < m+2; i++) {
            res = Math.max(res, (rs[i][1] + rs[i][0] + rs[i-1][1] - rs[i-1][0]) / 2);
        }
        return res;
    }
}