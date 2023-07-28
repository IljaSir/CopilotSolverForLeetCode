class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        int m = restrictions.length;
        if (restrictions.length == 0 || restrictions[m - 1][0] != n) {
            restrictions = Arrays.copyOf(restrictions, m + 1);
            restrictions[m] = new int[] {n, n - 1};
        }
        if (restrictions[0][0] != 1) {
            restrictions = Arrays.copyOf(restrictions, m + 1);
            for (int i = m; i > 0; i--) {
                restrictions[i] = restrictions[i - 1];
            }
            restrictions[0] = new int[] {1, 0};
        }
        for (int i = 1; i < restrictions.length; i++) {
            restrictions[i][1] = Math.min(restrictions[i][1], restrictions[i - 1][1] + restrictions[i][0] - restrictions[i - 1][0]);
        }
        for (int i = restrictions.length - 2; i >= 0; i--) {
            restrictions[i][1] = Math.min(restrictions[i][1], restrictions[i + 1][1] + restrictions[i + 1][0] - restrictions[i][0]);
        }
        int res = 0;
        for (int i = 1; i < restrictions.length; i++) {
            int d = restrictions[i][0] - restrictions[i - 1][0];
            int h = Math.abs(restrictions[i][1] - restrictions[i - 1][1]);
            res = Math.max(res, Math.min(restrictions[i][1], restrictions[i - 1][1]) + (d - h) / 2);
        }
        return res;
    }
}