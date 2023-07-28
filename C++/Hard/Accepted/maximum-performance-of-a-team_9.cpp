class Solution {
public:
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        
        vector<pair<int, int>> eng;
        for (int i = 0; i < n; i++) {
            eng.emplace_back(efficiency[i], speed[i]);
        }
        sort(eng.begin(), eng.end(), greater<pair<int, int>>());
        priority_queue<int, vector<int>, greater<int>> pq;
        long long speed_sum = 0, res = 0;
        for (auto& e : eng) {
            pq.push(e.second);
            speed_sum += e.second;
            if (pq.size() > k) {
                speed_sum -= pq.top();
                pq.pop();
            }
            res = max(res, speed_sum * e.first);
        }
        return res % 1000000007;
    }
};