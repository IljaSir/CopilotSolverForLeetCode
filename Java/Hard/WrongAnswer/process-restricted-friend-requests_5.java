class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        boolean[] res = new boolean[requests.length];
        for (int[] r : restrictions) {
            int x = find(parent, r[0]);
            int y = find(parent, r[1]);
            if (x != y) {
                parent[x] = y;
            }
        }
        for (int i = 0; i < requests.length; i++) {
            int x = find(parent, requests[i][0]);
            int y = find(parent, requests[i][1]);
            if (x != y) {
                res[i] = true;
                parent[x] = y;
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