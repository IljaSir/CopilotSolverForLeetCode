class Solution {
public:
    vector<int> assignTasks(vector<int>& servers, vector<int>& tasks) {
        
        int n = servers.size();
        int m = tasks.size();
        vector<int> ans(m);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> free;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> busy;
        for (int i = 0; i < n; ++i) {
            free.push({servers[i], i});
        }
        int t = 0;
        for (int i = 0; i < m; ++i) {
            while (!busy.empty() && busy.top().first <= t) {
                free.push({busy.top().second, busy.top().first});
                busy.pop();
            }
            if (free.empty()) {
                t = busy.top().first;
                while (!busy.empty() && busy.top().first <= t) {
                    free.push({busy.top().second, busy.top().first});
                    busy.pop();
                }
            }
            ans[i] = free.top().second;
            busy.push({t + tasks[i], free.top().first});
            free.pop();
            t = max(t, i + 1);
        }
        return ans;
    }
};