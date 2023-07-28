class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        
        int[] min = new int[n];
        int[] max = new int[n];
        int[] count = new int[n];
        int[] parent = new int[n];
        long res = 0;
        Arrays.fill(count, 1);
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            min[i] = max[i] = price[i];
        }
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            if (count[a] > count[b]) {
                parent[b] = a;
                count[a] += count[b];
                min[a] = Math.min(min[a], min[b]);
                max[a] = Math.max(max[a], max[b]);
            } else {
                parent[a] = b;
                count[b] += count[a];
                min[b] = Math.min(min[a], min[b]);
                max[b] = Math.max(max[a], max[b]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                res = Math.max(res, (long) max[i] - min[i]);
            }
        }
        return res;
    }
}