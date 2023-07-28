class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        
        int[] ans = new int[queries.length];
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diag = new HashMap<>();
        Map<Integer, Integer> antiDiag = new HashMap<>();
        Set<Integer> lampsSet = new HashSet<>();
        for (int[] lamp : lamps) {
            int x = lamp[0], y = lamp[1];
            row.put(x, row.getOrDefault(x, 0) + 1);
            col.put(y, col.getOrDefault(y, 0) + 1);
            diag.put(x - y, diag.getOrDefault(x - y, 0) + 1);
            antiDiag.put(x + y, antiDiag.getOrDefault(x + y, 0) + 1);
            lampsSet.add(x * n + y);
        }
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            if (row.getOrDefault(x, 0) > 0 || col.getOrDefault(y, 0) > 0 || diag.getOrDefault(x - y, 0) > 0 || antiDiag.getOrDefault(x + y, 0) > 0) {
                ans[i] = 1;
            }
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    int xx = x + dx, yy = y + dy;
                    int code = xx * n + yy;
                    if (lampsSet.contains(code)) {
                        row.put(xx, row.get(xx) - 1);
                        col.put(yy, col.get(yy) - 1);
                        diag.put(xx - yy, diag.get(xx - yy) - 1);
                        antiDiag.put(xx + yy, antiDiag.get(xx + yy) - 1);
                        lampsSet.remove(code);
                    }
                }
            }
        }
        return ans;
    }
}