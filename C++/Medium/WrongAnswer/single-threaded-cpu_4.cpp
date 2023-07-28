class Solution {
public:
    vector<int> getOrder(vector<vector<int>>& tasks) {
        
        int n = tasks.size();
        vector<int> res(n);
        vector<pair<int, int>> task(n);
        for (int i = 0; i < n; ++i) {
            task[i] = {tasks[i][0], i};
        }
        sort(task.begin(), task.end());
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        int i = 0;
        long long cur = 0;
        while (i < n || !pq.empty()) {
            if (pq.empty()) {
                cur = max(cur, (long long)task[i].first);
            }
            while (i < n && task[i].first <= cur) {
                pq.push({tasks[task[i].second][1], task[i].second});
                ++i;
            }
            auto [t, idx] = pq.top();
            pq.pop();
            cur += t;
            res.push_back(idx);
        }
        return res;
    }
};