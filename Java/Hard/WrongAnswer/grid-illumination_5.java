class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diag = new HashMap<>();
        Map<Integer, Integer> anti = new HashMap<>();
        Set<Long> lampSet = new HashSet<>();
        for (int[] lamp : lamps) {
            int x = lamp[0];
            int y = lamp[1];
            row.put(x, row.getOrDefault(x, 0) + 1);
            col.put(y, col.getOrDefault(y, 0) + 1);
            diag.put(x - y, diag.getOrDefault(x - y, 0) + 1);
            anti.put(x + y, anti.getOrDefault(x + y, 0) + 1);
            lampSet.add(((long) x << 32) | y);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (row.getOrDefault(x, 0) > 0
                    || col.getOrDefault(y, 0) > 0
                    || diag.getOrDefault(x - y, 0) > 0
                    || anti.getOrDefault(x + y, 0) > 0) {
                ans[i] = 1;
            }
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    int nx = x + dx;
                    int ny = y + dy;
                    long code = ((long) nx << 32) | ny;
                    if (lampSet.contains(code)) {
                        row.put(nx, row.get(nx) - 1);
                        col.put(ny, col.get(ny) - 1);
                        diag.put(nx - ny, diag.get(nx - ny) - 1);
                        anti.put(nx + ny, anti.get(nx + ny) - 1);
                        lampSet.remove(code);
                    }
                }
            }
        }
        return ans;
    }
}