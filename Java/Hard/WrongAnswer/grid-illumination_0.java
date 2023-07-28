class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        
        int[] ans = new int[queries.length];
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diag1 = new HashMap<>();
        Map<Integer, Integer> diag2 = new HashMap<>();
        Set<Long> lampSet = new HashSet<>();
        for (int[] lamp : lamps) {
            int r = lamp[0], c = lamp[1];
            row.put(r, row.getOrDefault(r, 0) + 1);
            col.put(c, col.getOrDefault(c, 0) + 1);
            diag1.put(r - c, diag1.getOrDefault(r - c, 0) + 1);
            diag2.put(r + c, diag2.getOrDefault(r + c, 0) + 1);
            lampSet.add(((long) r << 32) | c);
        }
        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0], c = queries[i][1];
            if (row.getOrDefault(r, 0) > 0 || col.getOrDefault(c, 0) > 0 ||
                diag1.getOrDefault(r - c, 0) > 0 || diag2.getOrDefault(r + c, 0) > 0) {
                ans[i] = 1;
            }
            for (int nr = r - 1; nr <= r + 1; nr++) {
                for (int nc = c - 1; nc <= c + 1; nc++) {
                    if (lampSet.remove(((long) nr << 32) | nc)) {
                        row.put(nr, row.get(nr) - 1);
                        col.put(nc, col.get(nc) - 1);
                        diag1.put(nr - nc, diag1.get(nr - nc) - 1);
                        diag2.put(nr + nc, diag2.get(nr + nc) - 1);
                    }
                }
            }
        }
        return ans;
    }
}