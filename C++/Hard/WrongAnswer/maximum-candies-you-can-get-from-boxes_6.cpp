class Solution {
public:
    int maxCandies(vector<int>& status, vector<int>& candies, vector<vector<int>>& keys, vector<vector<int>>& containedBoxes, vector<int>& initialBoxes) {
        
        int n = status.size();
        vector<bool> opened(n, false), visited(n, false);
        int res = 0;
        queue<int> q;
        for (int i : initialBoxes) {
            q.push(i);
            opened[i] = true;
        }
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            if (visited[cur]) continue;
            visited[cur] = true;
            if (status[cur]) {
                res += candies[cur];
                for (int i : containedBoxes[cur]) {
                    q.push(i);
                    opened[i] = true;
                }
                for (int i : keys[cur]) {
                    status[i] = 1;
                    if (opened[i]) q.push(i);
                }
            } else {
                q.push(cur);
            }
        }
        return res;
    }
};