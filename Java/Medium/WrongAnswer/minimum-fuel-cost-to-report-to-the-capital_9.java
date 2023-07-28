class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        
        int n = roads.length + 1;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int[] road : roads) {
            int p1 = find(parent, road[0]);
            int p2 = find(parent, road[1]);
            if (p1 != p2) {
                parent[p1] = p2;
            }
        }
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[find(parent, i)]++;
        }
        long ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > 0) {
                ans += count[i] - 1;
            }
        }
        return ans;
    }
    private int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }
}