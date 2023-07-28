class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        
        int[] ans = new int[queries.length];
        Map<Integer, Integer> row = new HashMap();
        Map<Integer, Integer> col = new HashMap();
        Map<Integer, Integer> diag1 = new HashMap();
        Map<Integer, Integer> diag2 = new HashMap();
        Set<Integer> lamp = new HashSet();

        for (int[] l: lamps) {
            int r = l[0], c = l[1];
            row.put(r, row.getOrDefault(r, 0) + 1);
            col.put(c, col.getOrDefault(c, 0) + 1);
            diag1.put(r - c, diag1.getOrDefault(r - c, 0) + 1);
            diag2.put(r + c, diag2.getOrDefault(r + c, 0) + 1);
            lamp.add(r * n + c);
        }

        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0], c = queries[i][1];
            if (row.containsKey(r) || col.containsKey(c) ||
                    diag1.containsKey(r - c) || diag2.containsKey(r + c))
                ans[i] = 1;
            for (int j = r - 1; j <= r + 1; j++) {
                for (int k = c - 1; k <= c + 1; k++) {
                    if (lamp.remove(j * n + k)) {
                        row.put(j, row.get(j) - 1);
                        col.put(k, col.get(k) - 1);
                        diag1.put(j - k, diag1.get(j - k) - 1);
                        diag2.put(j + k, diag2.get(j + k) - 1);
                        if (row.get(j) == 0) row.remove(j);
                        if (col.get(k) == 0) col.remove(k);
                        if (diag1.get(j - k) == 0) diag1.remove(j - k);
                        if (diag2.get(j + k) == 0) diag2.remove(j + k);
                    }
                }
            }
        }
        return ans;
    }
}