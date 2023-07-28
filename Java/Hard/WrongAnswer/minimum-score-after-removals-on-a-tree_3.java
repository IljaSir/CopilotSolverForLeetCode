class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            int pa = find(p, a);
            int pb = find(p, b);
            if (pa != pb) {
                p[pa] = pb;
            }
        }
        int[] cnt = new int[n];
        int[] xor = new int[n];
        for (int i = 0; i < n; i++) {
            int pi = find(p, i);
            cnt[pi]++;
            xor[pi] ^= nums[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (cnt[i] > 1) {
                min = Math.min(min, xor[i]);
            }
        }
        return min;
    }
    
    int find(int[] p, int i) {
        if (p[i] != i) {
            p[i] = find(p, p[i]);
        }
        return p[i];
    }
}