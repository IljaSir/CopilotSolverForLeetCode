class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(matrix[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        int[] row = new int[m];
        int[] col = new int[n];
        int[][] ans = new int[m][n];
        for (int key : map.keySet()) {
            List<int[]> list = map.get(key);
            UnionFind uf = new UnionFind(m + n);
            for (int[] point : list) {
                uf.union(point[0], point[1] + m);
            }
            Map<Integer, List<Integer>> groups = new HashMap<>();
            for (int i = 0; i < m + n; i++) {
                groups.computeIfAbsent(uf.find(i), k -> new ArrayList<>()).add(i);
            }
            for (List<Integer> group : groups.values()) {
                int max = 0;
                for (int i : group) {
                    if (i < m) {
                        max = Math.max(max, row[i]);
                    } else {
                        max = Math.max(max, col[i - m]);
                    }
                }
                for (int i : group) {
                    if (i < m) {
                        row[i] = max + 1;
                    } else {
                        col[i - m] = max + 1;
                    }
                }
            }
            for (int[] point : list) {
                ans[point[0]][point[1]] = row[point[0]];
            }
        }
        return ans;
    }
}
    }
}