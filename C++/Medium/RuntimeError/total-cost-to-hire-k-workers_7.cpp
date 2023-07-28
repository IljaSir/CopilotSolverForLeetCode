class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        
        int n = costs.size();
        sort(costs.begin(), costs.end());
        long long ans = 0;
        for (int i = 0; i < k; i++) {
            int x = i * (candidates - 1) + n - k * candidates;
            ans += costs[x];
        }
        return ans;
    }
};