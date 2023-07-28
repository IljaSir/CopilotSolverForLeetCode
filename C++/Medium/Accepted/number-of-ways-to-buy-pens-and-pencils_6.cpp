class Solution {
public:
    long long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        if (cost1 > cost2) swap(cost1, cost2);
        long long res = 0;
        for (int pen = 0; pen * cost1 <= total; ++pen) {
            int pencil = (total - pen * cost1) / cost2;
            res += pencil + 1;
        }
        return res;
    }
};