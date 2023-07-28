class Solution {
public:
    long long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        long long ans = 0;
        for (int i = 0; i <= total; ++i) {
            int j = total - i;
            if (i % cost1 == 0 && j % cost2 == 0) {
                ++ans;
            }
        }
        return ans;
    }
};