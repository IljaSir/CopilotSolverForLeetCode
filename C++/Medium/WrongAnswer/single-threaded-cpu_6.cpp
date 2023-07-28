class Solution {
public:
    vector<int> getOrder(vector<vector<int>>& tasks) {
        
        vector<int> ret;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        int time = 0;
        int index = 0;
        int n = tasks.size();
        while (index < n || !pq.empty()) {
            if (pq.empty()) {
                time = max(time, tasks[index][0]);
            }
            while (index < n && tasks[index][0] <= time) {
                pq.push({tasks[index][1], tasks[index][0]});
                index++;
            }
            auto p = pq.top();
            pq.pop();
            time += p.first;
            ret.push_back(p.second);
        }
        return ret;
    }
};