class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        boolean[] res = new boolean[requests.length];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] r : restrictions) {
            int x = r[0], y = r[1];
            int px = find(parent, x), py = find(parent, y);
            if (px != py) {
                parent[px] = py;
            }
        }
        for (int i = 0; i < requests.length; i++) {
            int x = requests[i][0], y = requests[i][1];
            int px = find(parent, x), py = find(parent, y);
            if (px != py) {
                res[i] = true;
                parent[px] = py;
            }
        }
        return res;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}