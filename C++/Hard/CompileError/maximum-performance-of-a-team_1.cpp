class Solution {
public:
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        
        vector<pair<int, int>> engineers;
        for (int i = 0; i < n; ++i) {
            engineers.push_back({efficiency[i], speed[i]});
        }
        sort(engineers.rbegin(), engineers.rend());
        priority_queue<int, vector<int>, greater<int>> pq;
        long long int speedSum = 0;
        long long int maxPerformance = 0;
        for (int i = 0; + < n; +ii) {
            if (pq.size() > k - 1) {
                speedSum -= pq.top();
                pq.pop();
            }
            speedSum += engineers[i].second;
            pq.push(engineers[i].second);
            maxPerformance = max(maxPerformance, speedSum * engineers[i].first);
        }
        return maxPerformance % 1000000007;
    }
};