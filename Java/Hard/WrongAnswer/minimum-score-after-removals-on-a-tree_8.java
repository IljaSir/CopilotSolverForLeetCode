class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        for (int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if (root1 != root2) {
                roots[root1] = root2;
            }
        }
        int[] xor = new int[n];
        for (int i = 0; i < n; i++) {
            xor[find(roots, i)] ^= nums[i];
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (roots[i] == i) {
                min = Math.min(min, xor[i]);
                max = Math.max(max, xor[i]);
            }
        }
        return max - min;
    }
    private int find(int[] roots, int i) {
        while (roots[i] != i) {
            roots[i] = roots[roots[i]];
            i = roots[i];
        }
        return i;
    }
}