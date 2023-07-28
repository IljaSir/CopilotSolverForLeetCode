class Solution {
    public int[] constructDistancedSequence(int n) {
        
        int[] res = new int[n * 2 - 1];
        boolean[] visited = new boolean[n + 1];
        dfs(res, visited, 0);
        return res;
    }
    
    private boolean dfs(int[] res, boolean[] visited, int index) {
        if (index == res.length) {
            return true;
        }
        if (res[index] != 0) {
            return dfs(res, visited, index + 1);
        }
        for (int i = visited.length - 1; i > 0; i--) {
            if (visited[i]) {
                continue;
            }
            if (i == 1) {
                res[index] = 1;
                visited[i] = true;
                if (dfs(res, visited, index + 1)) {
                    return true;
                }
                res[index] = 0;
                visited[i] = false;
            } else if (index + i < res.length && res[index + i] == 0) {
                res[index] = i;
                res[index + i] = i;
                visited[i] = true;
                if (dfs(res, visited, index + 1)) {
                    return true;
                }
                res[index] = 0;
                res[index + i] = 0;
                visited[i] = false;
            }
        }
        return false;
    }
}