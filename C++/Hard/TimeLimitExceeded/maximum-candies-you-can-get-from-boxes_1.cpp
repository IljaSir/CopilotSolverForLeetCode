class Solution {
public:
    int maxCandies(vector<int>& status, vector<int>& candies, vector<vector<int>>& keys, vector<vector<int>>& containedBoxes, vector<int>& initialBoxes) {
        
        int n = status.size();
        vector<int> visited(n, 0);
        queue<int> q;
        for (int b : initialBoxes) {
            q.push(b);
            visited[b] = 1;
        }
        int res = 0;
        while (!q.empty()) {
            int b = q.front();
            q.pop();
            if (status[b] == 0) {
                q.push(b);
                continue;
            }
            res += candies[b];
            for (int k : keys[b]) {
                status[k] = 1;
                if (visited[k] == 0) {
                    q.push(k);
                    visited[k] = 1;
                }
            }
            for (int cb : containedBoxes[b]) {
                if (visited[cb] == 0) {
                    q.push(cb);
                    visited[cb] = 1;
                }
            }
        }
        return res;
    }
};