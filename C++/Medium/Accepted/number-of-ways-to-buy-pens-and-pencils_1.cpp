class Solution {
public:
    long long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        long long ans = 0;
        for (int i = 0; i <= total / cost1; ++i) {
            int j = (total - i * cost1) / cost2;
            ans += j + 1;
        }
        return ans;
    }
};