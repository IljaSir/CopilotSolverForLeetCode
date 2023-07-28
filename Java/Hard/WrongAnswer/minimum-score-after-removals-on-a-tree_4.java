class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            int pa = find(parents, edge[0]);
            int pb = find(parents, edge[1]);
            if (pa != pb) {
                parents[pa] = pb;
            }
        }
        int[] xor = new int[n];
        for (int i = 0; i < n; i++) {
            xor[find(parents, i)] ^= nums[i];
        }
        int[] min = new int[n];
        int[] max = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            if (xor[i] == 0) {
                continue;
            }
            int p = find(parents, i);
            min[p] = Math.min(min[p], xor[i]);
            max[p] = Math.max(max[p], xor[i]);
        }
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (min[i] == Integer.MAX_VALUE) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (min[j] == Integer.MAX_VALUE || i == j) {
                    continue;
                }
                best = Math.min(best, max[i] + max[j] - min[i] - min[j]);
            }
        }
        return best;
    }
    
    private int find(int[] parents, int i) {
        if (parents[i] != i) {
            parents[i] = find(parents, parents[i]);
        }
        return parents[i];
    }
}