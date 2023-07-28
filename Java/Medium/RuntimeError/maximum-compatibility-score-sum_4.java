class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        
        int m = students.length;
        int n = students[0].length;
        int[][] compat = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int c = 0;
                for (int k = 0; k < n; k++) {
                    if (students[i][k] == mentors[j][k]) {
                        c++;
                    }
                }
                compat[i][j] = c;
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            int[] visited = new int[m];
            visited[i] = 1;
            int sum = compat[i][i];
            for (int j = 0; j < m; j++) {
                if (j != i) {
                    int maxCompat = 0;
                    int maxCompatIndex = -1;
                    for (int k = 0; k < m; k++) {
                        if (k != i && visited[k] == 0 && compat[j][k] > maxCompat) {
                            maxCompat = compat[j][k];
                            maxCompatIndex = k;
                        }
                    }
                    sum += maxCompat;
                    visited[maxCompatIndex] = 1;
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}