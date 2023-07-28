class Solution {
public:
    int minimumCost(vector<int>& cost) {
        
        int n = cost.size();
        if (n == 0) return 0;
        if (n == 1) return cost[0];
        if (n == 2) return cost[0] + cost[1];
        int a = cost[0], b = cost[1], c = cost[2], d = 0;
        for (int i = 3; i < n; i++) {
            d = min(a, min(b, c)) + cost[i];
            a = b;
            b = c;
            c = d;
        }
        return min(a, min(b, c));
    }
};