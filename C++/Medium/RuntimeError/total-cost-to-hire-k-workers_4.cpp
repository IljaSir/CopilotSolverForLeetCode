class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        
        sort(costs.begin(), costs.end());
        long long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += costs[i];
        }
        long long sum = ans;
        for (int i = 1; i <= k; i++) {
            sum += costs[i + candidates - 1] - costs[i - 1];
            ans = min(ans, sum);
        }
        return ans;
    }
};