class Solution {
public:
    long long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        if (total < cost1 && total < cost2) return 0;
        if (cost1 > cost2) swap(cost1, cost2);
        int n = total / cost1;
        long long ans = 0;
        for (int i = 0; i <= n; ++i) {
            int rest = total - i * cost1;
            ans += (rest / cost2) + 1;
        }
        return ans;
    }
};