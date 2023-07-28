class Solution {
    public int removeStones(int[][] stones) {
        
        int n = stones.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> cols = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = stones[i][0], y = stones[i][1];
            rows.computeIfAbsent(x, z -> new ArrayList<>()).add(i);
            cols.computeIfAbsent(y, z -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < n; i++) {
            int x = stones[i][0], y = stones[i][1];
            for (int j : rows.get(x)) {
                union(parent, i, j);
            }
            for (int j : cols.get(y)) {
                union(parent, i, j);
            }
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            seen.add(find(parent, i));
        }
        return n - seen.size();
    }

    public int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    public void union(int[] parent, int i, int j) {
        int pi = find(parent, i);
        int pj = find(parent, j);
        if (pi != pj) {
            parent[pi] = pj;
        }
    }
}