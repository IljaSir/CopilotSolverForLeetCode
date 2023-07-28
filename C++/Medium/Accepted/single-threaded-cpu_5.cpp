class Solution {
public:
    vector<int> getOrder(vector<vector<int>>& tasks) {
        
        vector<int> res;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        int i = 0, t = 0, n = tasks.size();
        vector<int> idx(n);
        for (int i = 0; i < n; ++i) idx[i] = i;
        sort(idx.begin(), idx.end(), [&](int a, int b) { return tasks[a][0] < tasks[b][0]; });
        while (i < n) {
            if (pq.empty()) t = max(t, tasks[idx[i]][0]);
            while (i < n && tasks[idx[i]][0] <= t) {
                pq.push({tasks[idx[i]][1], idx[i]});
                ++i;
            }
            auto p = pq.top(); pq.pop();
            res.push_back(p.second);
            t += p.first;
        }
        while (!pq.empty()) {
            auto p = pq.top(); pq.pop();
            res.push_back(p.second);
        }
        return res;
    }
};