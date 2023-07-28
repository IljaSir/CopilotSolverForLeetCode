class Solution {
public:
    int minimumCost(vector<int>& cost) {
        
        int n = cost.size();
        if (n == 1) return cost[0];
        if (n == 2) return cost[0] + cost[1];
        int minCost = cost[0] + cost[1];
        int discount = 0;
        for (int i = 2; i < n; ++i) {
            if (cost[i] < minCost) {
                if (cost[i] + discount <= minCost) {
                    discount += cost[i];
                } else {
                    minCost = cost[i] + discount;
                    discount = 0;
                }
            } else {
                minCost += cost[i];
            }
        }
        return minCost;
    }
};