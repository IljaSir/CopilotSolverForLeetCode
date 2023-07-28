class Solution {
public:
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        
        vector<pair<int, int>> engineers;
        for (int i = 0; i < n; i++) {
            engineers.push_back({efficiency[i], speed[i]});
        }
        sort(engineers.begin(), engineers.end());
        priority_queue<int, vector<int>, greater<int>> pq;
        long long sum = 0, result = 0;
        for (int i = n - 1; i >= 0; i--) {
            pq.push(engineers[i].second);
            sum += engineers[i].second;
            if (pq.size() > k) {
                sum -= pq.top();
                pq.pop();
            }
            result = max(result, sum * engineers[i].first);
        }
        return result % (long long)(1e9 + 7);
    }
};