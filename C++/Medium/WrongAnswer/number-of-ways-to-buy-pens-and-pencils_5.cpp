class Solution {
public:
    long long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        long long ret = 0;
        for (int i = 0; i <= total / cost1; i++) {
            int j = (total - i * cost1) / cost2;
            if (i * cost1 + j * cost2 == total) {
                ret += (i + 1) * (j + 1);
            }
        }
        return ret;
    }
};