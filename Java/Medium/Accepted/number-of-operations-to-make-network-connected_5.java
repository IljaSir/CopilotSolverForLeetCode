class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        if (connections.length < n - 1) {
            return -1;
        }
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] connection : connections) {
            int root1 = find(connection[0], parents);
            int root2 = find(connection[1], parents);
            if (root1 != root2) {
                parents[root1] = root2;
                n--;
            }
        }
        return n - 1;
    }
    
    private int find(int i, int[] parents) {
        if (parents[i] == i) {
            return i;
        }
        return parents[i] = find(parents[i], parents);
    }
}