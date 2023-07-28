class Solution {
public:
    vector<int> getOrder(vector<vector<int>>& tasks) {
        
        int n = tasks.size();
        vector<int> result;
        vector<int> index(n);
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        sort(index.begin(), index.end(), [&](int i, int j) {
            return tasks[i][0] < tasks[j][0];
        });
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        int i = 0;
        long long time = 0;
        while (i < n || !pq.empty()) {
            if (pq.empty()) {
                time = tasks[index[i]][0];
            }
            while (i < n && tasks[index[i]][0] <= time) {
                pq.emplace(tasks[index[i]][1], index[i]);
                i++;
            }
            auto [processingTime, taskIndex] = pq.top();
            pq.pop();
            time += processingTime;
            result.push_back(taskIndex);
        }
        return result;
    }
};