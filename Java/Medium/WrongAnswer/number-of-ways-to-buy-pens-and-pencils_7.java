class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        long res = 0;
        for (int i = 0; i <= total; i++) {
            int pen = i;
            int pencil = total - pen;
            if (pencil >= 0 && pencil % cost2 == 0) {
                res++;
            }
        }
        return res;
    }
}