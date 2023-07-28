class Solution {
    public int componentValue(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        for (int[] e : edges) {
            int a = find(p, e[0]);
            int b = find(p, e[1]);
            if (a != b) p[a] = b;
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i++) c[find(p, i)] += nums[i];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) d[c[i]]++;
        for (int i = 0; i < n; i++) if (d[i] > 1) return n - d[i];
        return n - 1;
    }
}