class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        long res = 0;
        for (int i = 0; i <= total; i++) {
            int j = total - i * cost1;
            if (j >= 0 && j % cost2 == 0) {
                res++;
            }
        }
        return res;
    }
}