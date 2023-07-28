class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        
        int n = costs.size();
        long long res = 0;
        sort(costs.begin(), costs.end());
        for (int i = 0; i < k; i++) {
            res += costs[i];
        }
        long long tmp = res;
        for (int i = 0; i < k; i++) {
            tmp -= costs[i];
            tmp += costs[n - k + i];
            res = min(res, tmp + costs[i] * (candidates - 1));
        }
        return res;
    }
};