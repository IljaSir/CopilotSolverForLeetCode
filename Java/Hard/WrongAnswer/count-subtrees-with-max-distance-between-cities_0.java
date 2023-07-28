class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        
        int[] result = new int[n - 1];
        int[][] matrix = new int[n][n];
        for (int[] edge : edges) {
            matrix[edge[0] - 1][edge[1] - 1] = 1;
            matrix[edge[1] - 1][edge[0] - 1] = 1;
        }
        for (int i = 1; i < (1 << n); i++) {
            if (Integer.bitCount(i) <= 1) {
                continue;
            }
            int[] d = new int[n];
            int max = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) != 0) {
                    if (count == 0) {
                        d[j] = 0;
                    } else {
                        boolean found = false;
                        for (int k = 0; k < n; k++) {
                            if (((1 << k) & i) != 0 && matrix[j][k] == 1 && d[k] != 0) {
                                d[j] = d[k] + 1;
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            max = Integer.MAX_VALUE;
                            break;
                        }
                    }
                    count++;
                    max = Math.max(max, d[j]);
                }
            }
            if (max < Integer.MAX_VALUE) {
                result[max - 1]++;
            }
        }
        return result;
    }
}