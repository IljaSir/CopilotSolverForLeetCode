class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        
        int n = isConnected.size();
        vector<int> visited(n, 0);
        queue<int> q;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                q.push(i);
                while (!q.empty()) {
                    int cur = q.front();
                    q.pop();
                    visited[cur] = 1;
                    for (int j = 0; j < n; j++) {
                        if (isConnected[cur][j] && !visited[j]) {
                            q.push(j);
                        }
                    }
                }
                ans++;
            }
        }
        return ans;
    }
};