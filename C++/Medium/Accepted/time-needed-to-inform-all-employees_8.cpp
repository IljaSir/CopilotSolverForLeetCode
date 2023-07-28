class Solution {
public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        
        unordered_map<int, vector<int>> children;
        for (int i = 0; i < manager.size(); i++) {
            if (manager[i] != -1) {
                children[manager[i]].push_back(i);
            }
        }
        int ans = 0;
        queue<pair<int, int>> q;
        q.push(make_pair(headID, 0));
        while (!q.empty()) {
            auto p = q.front();
            q.pop();
            ans = max(ans, p.second);
            for (auto c : children[p.first]) {
                q.push(make_pair(c, p.second + informTime[p.first]));
            }
        }
        return ans;
    }
};