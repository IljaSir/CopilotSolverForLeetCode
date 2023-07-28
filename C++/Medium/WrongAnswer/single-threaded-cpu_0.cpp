class Solution {
public:
    vector<int> getOrder(vector<vector<int>>& tasks) {
        
        int n = tasks.size();
        for (int i = 0; i < n; ++i) {
            tasks[i].push_back(i);
        }
        sort(tasks.begin(), tasks.end());
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        vector<int> ans;
        long long curTime = 0;
        int i = 0;
        while (i < n || !pq.empty()) {
            if (pq.empty()) {
                curTime = tasks[i][0];
            }
            while (i < n && tasks[i][0] <= curTime) {
                pq.emplace(tasks[i][1], tasks[i][2]);
                ++i;
            }
            auto [len, idx] = pq.top();
            pq.pop();
            curTime += len;
            ans.push_back(idx);
        }
        return ans;
    }
};