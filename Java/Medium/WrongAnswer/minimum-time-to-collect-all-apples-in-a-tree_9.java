class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        int[] parent = new int[n];
        int[] count = new int[n];
        int[] appleCount = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            count[i] = 1;
            appleCount[i] = hasApple.get(i) ? 1 : 0;
        }
        for (int[] edge : edges) {
            int p1 = findParent(parent, edge[0]);
            int p2 = findParent(parent, edge[1]);
            if (p1 != p2) {
                parent[p2] = p1;
                count[p1] += count[p2];
                appleCount[p1] += appleCount[p2];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (appleCount[i] > 0) {
                res += 2 * (count[i] - 1);
            }
        }
        return res;
    }
    private int findParent(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = findParent(parent, parent[i]);
        }
        return parent[i];
    }
}