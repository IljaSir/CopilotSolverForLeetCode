class Solution {
public:
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        
        vector<pair<int, int>> engineers;
        for (int i = 0; i < n; ++i) {
            engineers.push_back({efficiency[i], speed[i]});
        }
        sort(engineers.begin(), engineers.end(), greater<pair<int, int>>());
        
        priority_queue<int, vector<int>, greater<int>> pq;
        long long res = 0, sum = 0;
        for (auto& e : engineers) {
            if (pq.size() == k) {
                sum -= pq.top();
                pq.pop();
            }
            
            pq.push(e.second);
            sum += e.second;
            res = max(res, sum * e.first);
        }
        
        return res % (int)(1e9 + 7);
    }
};