class Solution {
public:
    int countArrangement(int n) {
        
        int res = 0;
        vector<bool> visited(n+1, false);
        dfs(n, 1, visited, res);
        return res;
    }
    void dfs(int n, int pos, vector<bool>& visited, int& res) {
        if (pos > n) {
            res++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                dfs(n, pos+1, visited, res);
                visited[i] = false;
            }
        }
    }
};