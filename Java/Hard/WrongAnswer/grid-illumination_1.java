class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        
        int[] ans = new int[queries.length];
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diag1 = new HashMap<>();
        Map<Integer, Integer> diag2 = new HashMap<>();
        Set<Integer> lampSet = new HashSet<>();
        for (int[] lamp : lamps) {
            int x = lamp[0];
            int y = lamp[1];
            row.put(x, row.getOrDefault(x, 0) + 1);
            col.put(y, col.getOrDefault(y, 0) + 1);
            diag1.put(x + y, diag1.getOrDefault(x + y, 0) + 1);
            diag2.put(x - y, diag2.getOrDefault(x - y, 0) + 1);
            lampSet.add(x * n + y);
        }
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (row.getOrDefault(x, 0) > 0 || col.getOrDefault(y, 0) > 0 || diag1.getOrDefault(x + y, 0) > 0 || diag2.getOrDefault(x - y, 0) > 0) {
                ans[i] = 1;
            }
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    int nx = x + dx;
                    int ny = y + dy;
                    if (lampSet.contains(nx * n + ny)) {
                        row.put(nx, row.getOrDefault(nx, 0) - 1);
                        col.put(ny, col.getOrDefault(ny, 0) - 1);
                        diag1.put(nx + ny, diag1.getOrDefault(nx + ny, 0) - 1);
                        diag2.put(nx - ny, diag2.getOrDefault(nx - ny, 0) - 1);
                        lampSet.remove(nx * n + ny);
                    }
                }
            }
        }
        return ans;
    }
}