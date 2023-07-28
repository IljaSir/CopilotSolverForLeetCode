class Solution {
public:
    int maxCandies(vector<int>& status, vector<int>& candies, vector<vector<int>>& keys, vector<vector<int>>& containedBoxes, vector<int>& initialBoxes) {
        
        queue<int> q;
        for (int i = 0; i < initialBoxes.size(); i++) {
            if (status[initialBoxes[i]] == 1) {
                q.push(initialBoxes[i]);
            }
        }
        int res = 0;
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            res += candies[cur];
            for (int i = 0; i < keys[cur].size(); i++) {
                status[keys[cur][i]] = 1;
                if (status[keys[cur][i]] == 1) {
                    q.push(keys[cur][i]);
                }
            }
            for (int i = 0; i < containedBoxes[cur].size(); i++) {
                if (status[containedBoxes[cur][i]] == 1) {
                    q.push(containedBoxes[cur][i]);
                }
            }
        }
        return res;
    }
};