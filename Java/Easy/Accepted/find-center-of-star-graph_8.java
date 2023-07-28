class Solution {
    public int findCenter(int[][] edges) {
        
        int n = edges.length;
        int[] degrees = new int[n+2];
        for (int[] edge: edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == n) {
                return i;
            }
        }
        return -1;
    }
}