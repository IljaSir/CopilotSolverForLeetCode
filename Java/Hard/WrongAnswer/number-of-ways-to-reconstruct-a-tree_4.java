class Solution {
    public int checkWays(int[][] pairs) {
        
        int[] parent = new int[501];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] pair : pairs) {
            int x = pair[0];
            int y = pair[1];
            int px = find(x, parent);
            int py = find(y, parent);
            if (px != py) {
                parent[py] = px;
            }
        }
        int root = find(pairs[0][0], parent);
        int count = 0;
        for (int i = 1; i < parent.length; i++) {
            if (find(i, parent) == root) {
                count++;
            }
        }
        if (count != pairs.length + 1) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int[] pair : pairs) {
            set.add(find(pair[0], parent));
            set.add(find(pair[1], parent));
        }
        return set.size() == pairs.length + 1 ? 1 : 2;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}