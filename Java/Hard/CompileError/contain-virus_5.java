class Solution {
    public int containVirus(int[][] isInfected) {
        
        int m = isInfected.length;
        int n = isInfected[0].length;
        int total = 0;
        while (true) {
            boolean[][] visited = new boolean[m][n];
            int[] max = new int[3];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1 && !visited[i][j]) {
                        int[] temp = new int[3];
                        dfs(isInfected, visited, i, j, temp);
                        if (temp[2] > max[2]) {
                            max = temp;
                        }
                    }
                }
            }
            if (max[2] == 0) {
                break;
            }
            total += max[2];
            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1 && !visited[i][j]) {
                        int[] temp = new int[3];
                        dfs(isInfected, visited, i, j, temp);
                        if (temp[0] == max[0] && temp[1] == max[1]) {
                            infect(isInfected, i, j);
                        }
                    }
                }
            }
        }
        return total;
    }
    
    private void dfs(int[][] isInfected, boolean[][] visited, int i, int j, int[] temp) {
        int m = isInfected.length;
        int n = isInfected[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (isInfected[i][j] == 0) {
            temp[2]++;
            return;
        }
        temp[0] += i;
        temp[1] += j;
        temp[2]++;
        dfs(isInfected, visited, i + 1, j, temp);
        dfs(isInfected, visited, i - 1, j, temp);
        dfs(isInfected, visited, i, j + 1
    }
}