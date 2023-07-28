class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        if (cost1 > cost2) {
            int tmp = cost1;
            cost1 = cost2;
            cost2 = tmp;
        }
        int max = total / cost1;
        long res = 0;
        for (int i = 0; i <= max; i++) {
            int left = total - cost1 * i;
            if (left % cost2 == 0) {
                res++;
            }
        }
        return res;
    }
}