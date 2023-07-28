class Solution {
public:
    long long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        long long ans = 0;
        for (int i = 0; i <= total / cost1; i++) {
            int left = total - i * cost1;
            if (left % cost2 == 0) {
                ans++;
            }
        }
        return ans;
    }
};