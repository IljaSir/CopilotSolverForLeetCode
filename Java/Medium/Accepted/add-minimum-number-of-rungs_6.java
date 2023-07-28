class Solution {
    public int addRungs(int[] rungs, int dist) {
        
        int i = 0;
        int count = 0;
        while (i < rungs.length) {
            if (i == 0) {
                if (rungs[i] > dist) {
                    count += (rungs[i] - 1) / dist;
                }
            } else {
                if (rungs[i] - rungs[i - 1] > dist) {
                    count += (rungs[i] - rungs[i - 1] - 1) / dist;
                }
            }
            i++;
        }
        return count;
    }
}