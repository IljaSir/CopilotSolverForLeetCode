class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        
        Arrays.sort(restrictions, (a, b) -> Integer.compare(a[0], b[0]));
        int m = restrictions.length;
        if (m == 0 || restrictions[m - 1][0] != n) {
            restrictions = Arrays.copyOf(restrictions, m + 1);
            restrictions[m++] = new int[] {n, n - 1};
        }
        if (restrictions[0][0] != 1) {
            restrictions = Arrays.copyOf(restrictions, m + 1);
            restrictions[m++] = new int[] {1, 0};
            for (int i = m - 1; i > 0; i--) {
                restrictions[i] = restrictions[i - 1];
            }
            restrictions[0] = new int[] {1, 0};
        }
        for (int i = 1; i < m; i++) {
            restrictions[i][1] = Math.min(restrictions[i][1], restrictions[i - 1][1] + restrictions[i][0] - restrictions[i - 1][0]);
        }
        for (int i = m - 2; i >= 0; i--) {
            restrictions[i][1] = Math.min(restrictions[i][1], restrictions[i + 1][1] + restrictions[i + 1][0] - restrictions[i][0]);
        }
        int ans = 0;
        for (int i = 1; i < m; i++) {
            int h = restrictions[i][1];
            int d = restrictions[i][0] - restrictions[i - 1][0];
            int h0 = restrictions[i - 1][1];
            ans = Math.max(ans, Math.max(h0 + d, h + d / 2));
        }
        return ans;
    }
}