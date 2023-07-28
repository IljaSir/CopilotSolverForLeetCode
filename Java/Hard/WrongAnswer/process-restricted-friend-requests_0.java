class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        boolean[] result = new boolean[requests.length];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] restriction : restrictions) {
            int x = restriction[0];
            int y = restriction[1];
            union(parent, x, y);
        }
        for (int i = 0; i < requests.length; i++) {
            int x = requests[i][0];
            int y = requests[i][1];
            if (find(parent, x) == find(parent, y)) {
                result[i] = false;
            } else {
                union(parent, x, y);
                result[i] = true;
            }
        }
        return result;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
        }
    }
}