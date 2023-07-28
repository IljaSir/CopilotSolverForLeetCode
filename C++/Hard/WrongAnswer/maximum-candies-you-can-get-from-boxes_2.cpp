class Solution {
public:
    int maxCandies(vector<int>& status, vector<int>& candies, vector<vector<int>>& keys, vector<vector<int>>& containedBoxes, vector<int>& initialBoxes) {
        
        int n = status.size();
        vector<bool> visited(n, false);
        vector<bool> opened(n, false);
        queue<int> q;
        for (int i = 0; i < initialBoxes.size(); i++) {
            q.push(initialBoxes[i]);
        }
        int ans = 0;
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            if (status[cur] == 0 && !opened[cur]) {
                q.push(cur);
                continue;
            }
            ans += candies[cur];
            opened[cur] = true;
            for (int i = 0; i < keys[cur].size(); i++) {
                status[keys[cur][i]] = 1;
            }
            for (int i = 0; i < containedBoxes[cur].size(); i++) {
                q.push(containedBoxes[cur][i]);
            }
        }
        return ans;
    }
};