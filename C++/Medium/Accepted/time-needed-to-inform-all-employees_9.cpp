class Solution {
public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        
        unordered_map<int, vector<int>> m;
        for(int i = 0; i < manager.size(); i++) {
            m[manager[i]].push_back(i);
        }
        int t = 0;
        queue<pair<int, int>> q;
        q.push({headID, informTime[headID]});
        while(!q.empty()) {
            auto p = q.front();
            q.pop();
            t = max(t, p.second);
            for(auto i : m[p.first]) {
                q.push({i, informTime[i] + p.second});
            }
        }
        return t;
    }
};