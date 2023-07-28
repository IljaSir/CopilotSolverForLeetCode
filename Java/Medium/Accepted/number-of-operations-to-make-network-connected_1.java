class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        if (connections.length < n - 1) {
            return -1;
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int count = 0;
        for (int[] c : connections) {
            int x = find(parent, c[0]);
            int y = find(parent, c[1]);
            if (x != y) {
                parent[x] = y;
            }
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count - 1;
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}