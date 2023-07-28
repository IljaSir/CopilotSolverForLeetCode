class Solution {
public:
    int maxCandies(vector<int>& status, vector<int>& candies, vector<vector<int>>& keys, vector<vector<int>>& containedBoxes, vector<int>& initialBoxes) {
        
        int n = status.size();
        vector<int> visited(n, 0);
        queue<int> q;
        int ans = 0;
        for (int i = 0; i < initialBoxes.size(); i++) {
            q.push(initialBoxes[i]);
        }
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            if (visited[cur]) continue;
            visited[cur] = 1;
            if (status[cur]) {
                ans += candies[cur];
                for (int i = 0; i < keys[cur].size(); i++) {
                    status[keys[cur][i]] = 1;
                    if (visited[keys[cur][i]]) {
                        q.push(keys[cur][i]);
                    }
                }
                for (int i = 0; i < containedBoxes[cur].size(); i++) {
                    q.push(containedBoxes[cur][i]);
                }
            } else {
                q.push(cur);
            }
        }
        return ans;
    }
};