class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        
        int[] res = new int[n - 1];
        for (int i = 1; i < (1 << n); i++) {
            int[] count = new int[n];
            int max = 0;
            int min = n;
            for (int j = 0; j < edges.length; j++) {
                if (((i >> (edges[j][0] - 1)) & 1) == 1 && ((i >> (edges[j][1] - 1)) & 1) == 1) {
                    count[edges[j][0] - 1]++;
                    count[edges[j][1] - 1]++;
                }
            }
            for (int j = 0; j < n; j++) {
                if (count[j] > max) {
                    max = count[j];
                }
                if (count[j] > 0 && count[j] < min) {
                    min = count[j];
                }
            }
            if (max == 2 && min == 1) {
                res[max - min]++;
            }
        }
        return res;
    }
}