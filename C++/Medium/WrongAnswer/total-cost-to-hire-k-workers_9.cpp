class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        
        int n = costs.size();
        sort(costs.begin(), costs.end());
        int i = 0, j = n-1;
        long long res = 0;
        while (k--) {
            if (candidates <= j-i) {
                res += costs[i];
                i++;
            } else {
                res += costs[j];
                j--;
            }
        }
        return res;
    }
};