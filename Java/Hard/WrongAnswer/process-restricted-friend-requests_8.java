class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        boolean[] result = new boolean[requests.length];
        int[][] friends = new int[n][n];
        int[] degree = new int[n];
        for (int[] r : restrictions) {
            friends[r[0]][r[1]] = 1;
            friends[r[1]][r[0]] = 1;
            degree[r[0]] += 1;
            degree[r[1]] += 1;
        }
        for (int i = 0; i < requests.length; i++) {
            int[] request = requests[i];
            int u = request[0];
            int v = request[1];
            if (friends[u][v] == 1) {
                result[i] = false;
                continue;
            }
            if (degree[u] == 0 && degree[v] == 0) {
                result[i] = true;
                friends[u][v] = 1;
                friends[v][u] = 1;
                degree[u] += 1;
                degree[v] += 1;
                continue;
            }
            boolean uHasFriend = false;
            boolean vHasFriend = false;
            for (int j = 0; j < n; j++) {
                if (friends[u][j] == 1) {
                    uHasFriend = true;
                    if (friends[v][j] == 1) {
                        vHasFriend = true;
                        break;
                    }
                }
            }
            if (uHasFriend && vHasFriend) {
                result[i] = false;
            } else {
                result[i] = true;
                friends[u][v] = 1;
                friends[v][u] = 1;
                degree[u] += 1;
                degree[v] += 1;
            }
        }
        return result;
    }
}