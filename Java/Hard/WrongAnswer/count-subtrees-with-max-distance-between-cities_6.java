class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        
        int[] result = new int[n - 1];
        for (int i = 0; i < (1 << n); i++) {
            int[] count = new int[n];
            int max = 0;
            for (int[] edge : edges) {
                int x = edge[0] - 1;
                int y = edge[1] - 1;
                if (((i >> x) & 1) == 1 && ((i >> y) & 1) == 1) {
                    count[x]++;
                    count[y]++;
                    max = Math.max(max, Math.max(count[x], count[y]));
                }
            }
            if (max > 0) {
                result[max - 1]++;
            }
        }
        return result;
    }
}