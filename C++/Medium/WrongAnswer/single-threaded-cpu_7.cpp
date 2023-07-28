class Solution {
public:
    vector<int> getOrder(vector<vector<int>>& tasks) {
        
        vector<int> ans;
        int n = tasks.size();
        vector<pair<int, int>> task;
        for (int i = 0; i < n; ++i) {
            task.push_back(make_pair(tasks[i][0], tasks[i][1]));
        }
        sort(task.begin(), task.end());
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        int i = 0;
        long long time = 0;
        while (i < n || !pq.empty()) {
            if (pq.empty()) {
                time = max(time, (long long)task[i].first);
            }
            while (i < n && task[i].first <= time) {
                pq.push(make_pair(task[i].second, task[i].first));
                ++i;
            }
            auto p = pq.top();
            pq.pop();
            ans.push_back(p.second);
            time += p.first;
        }
        return ans;
    }
};