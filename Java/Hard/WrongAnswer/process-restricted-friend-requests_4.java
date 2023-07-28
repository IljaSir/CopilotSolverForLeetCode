class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        boolean[] result = new boolean[requests.length];
        boolean[][] friends = new boolean[n][n];
        for (int i = 0; i < restrictions.length; i++) {
            friends[restrictions[i][0]][restrictions[i][1]] = true;
            friends[restrictions[i][1]][restrictions[i][0]] = true;
        }
        for (int i = 0; i < requests.length; i++) {
            int u = requests[i][0];
            int v = requests[i][1];
            if (friends[u][v]) {
                result[i] = false;
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (friends[u][j] && friends[v][j]) {
                    flag = false;
                    break;
                }
            }
            result[i] = flag;
        }
        return result;
    }
}