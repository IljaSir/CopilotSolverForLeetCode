class Solution {
public:
    vector<int> assignTasks(vector<int>& servers, vector<int>& tasks) {
        
        int n = servers.size(), m = tasks.size();
        vector<int> ans(m);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> free;
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> busy;
        for (int i = 0; i < n; i++) free.push({servers[i], i});
        for (int i = 0; i < m; i++) {
            while (!busy.empty() && busy.top().first <= i) {
                free.push({busy.top().second.first, busy.top().second.second});
                busy.pop();
            }
            if (free.empty()) {
                int time = busy.top().first;
                while (!busy.empty() && busy.top().first == time) {
                    free.push({busy.top().second.first, busy.top().second.second});
                    busy.pop();
                }
            }
            ans[i] = free.top().second;
            busy.push({i + tasks[i], {free.top().first, free.top().second}});
            free.pop();
        }
        return ans;
    }
};