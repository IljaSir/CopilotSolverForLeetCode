class Solution {
public:
    long long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        if (cost1 > cost2) {
            swap(cost1, cost2);
        }
        long long ans = 0;
        for (int i = 0; i <= total / cost1; i++) {
            int remain = total - i * cost1;
            if (remain % cost2 == 0) {
                ans++;
            }
        }
        return ans;
    }
};