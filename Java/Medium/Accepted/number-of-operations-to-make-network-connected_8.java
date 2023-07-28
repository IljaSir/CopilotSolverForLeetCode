class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int extra = 0;
        for (int[] connection : connections) {
            int root1 = findRoot(connection[0], parent);
            int root2 = findRoot(connection[1], parent);
            if (root1 == root2) {
                extra++;
            } else {
                parent[root1] = root2;
            }
        }
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[findRoot(i, parent)]++;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > 0) {
                result++;
            }
        }
        return extra >= result - 1 ? result - 1 : -1;
    }
    private int findRoot(int i, int[] parent) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }
}