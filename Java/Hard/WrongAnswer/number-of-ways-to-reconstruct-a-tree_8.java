class Solution {
    public int checkWays(int[][] pairs) {
        
        int N = 500;
        int[] parent = new int[N + 1];
        Arrays.fill(parent, -1);
        for (int[] pair: pairs) {
            int x = find(parent, pair[0]);
            int y = find(parent, pair[1]);
            if (x != y) {
                parent[x] = y;
            }
        }
        int[] count = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            if (parent[i] == -1) {
                continue;
            }
            int root = find(parent, i);
            count[root]++;
        }
        int ans = 1;
        for (int i = 1; i <= N; ++i) {
            if (parent[i] == -1) {
                continue;
            }
            int root = find(parent, i);
            if (count[root] > 1) {
                ans = 2;
                break;
            }
        }
        return ans;
    }

    public int find(int[] parent, int x) {
        if (parent[x] == -1) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }
}