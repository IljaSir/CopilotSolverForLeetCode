class Solution {
public:
    vector<int> getOrder(vector<vector<int>>& tasks) {
        
        int n = tasks.size();
        vector<int> res(n);
        for (int i = 0; i < n; i++)
            tasks[i].push_back(i);
        sort(tasks.begin(), tasks.end());
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        long long time = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (pq.empty()) {
                time = max(time, (long long)tasks[i][0]);
            }
            while (i < n && time >= tasks[i][0]) {
                pq.push({tasks[i][1], tasks[i][2]});
                i++;
            }
            res[j] = pq.top().second;
            time += pq.top().first;
            pq.pop();
        }
        return res;
    }
};