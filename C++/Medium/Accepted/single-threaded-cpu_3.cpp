class Solution {
public:
    vector<int> getOrder(vector<vector<int>>& tasks) {
        
        int n = tasks.size();
        vector<int> ans(n);
        vector<vector<int>> t(n, vector<int>(3));
        for (int i = 0; i < n; ++i) {
            t[i][0] = tasks[i][0];
            t[i][1] = tasks[i][1];
            t[i][2] = i;
        }
        sort(t.begin(), t.end());
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        long long time = t[0][0];
        int i = 0;
        int j = 0;
        while (i < n) {
            if (pq.empty()) {
                time = max(time, (long long)t[i][0]);
            }
            while (i < n && t[i][0] <= time) {
                pq.push({t[i][1], t[i][2]});
                ++i;
            }
            auto p = pq.top();
            pq.pop();
            ans[j] = p[1];
            time += p[0];
            ++j;
        }
        while (!pq.empty()) {
            auto p = pq.top();
            pq.pop();
            ans[j] = p[1];
            ++j;
        }
        return ans;
    }
};