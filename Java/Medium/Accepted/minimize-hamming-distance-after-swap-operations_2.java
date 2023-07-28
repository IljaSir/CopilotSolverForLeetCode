class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int n = source.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] swap : allowedSwaps) {
            int rootX = find(parent, swap[0]);
            int rootY = find(parent, swap[1]);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            Map<Integer, Integer> count = map.getOrDefault(root, new HashMap<>());
            count.put(source[i], count.getOrDefault(source[i], 0) + 1);
            map.put(root, count);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            Map<Integer, Integer> count = map.get(root);
            int c = count.getOrDefault(target[i], 0);
            if (c > 0) {
                count.put(target[i], c - 1);
            } else {
                ans++;
            }
        }
        return ans;
    }

    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}