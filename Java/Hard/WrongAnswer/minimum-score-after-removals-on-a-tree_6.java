class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        for (int[] edge : edges) {
            int root0 = findRoot(roots, edge[0]);
            int root1 = findRoot(roots, edge[1]);
            if (root0 != root1) {
                roots[root0] = root1;
            }
        }
        int[] xor = new int[n];
        for (int i = 0; i < n; i++) {
            xor[findRoot(roots, i)] ^= nums[i];
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (roots[i] == i) {
                min = Math.min(min, xor[i]);
                max = Math.max(max, xor[i]);
            }
        }
        return max - min;
    }
    
    private int findRoot(int[] roots, int i) {
        while (i != roots[i]) {
            roots[i] = roots[roots[i]];
            i = roots[i];
        }
        return i;
    }
}