class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        if (total < cost1 && total < cost2) {
            return 0;
        }
        if (cost1 > cost2) {
            int tmp = cost1;
            cost1 = cost2;
            cost2 = tmp;
        }
        long ans = 0;
        for (int i = 0; i <= total / cost1; i++) {
            int tmp = total - i * cost1;
            if (tmp % cost2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}