class Solution {
    public int addRungs(int[] rungs, int dist) {
        
        int n = rungs.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int height = rungs[i];
            if (i > 0) {
                height -= rungs[i - 1];
            }
            count += (height - 1) / dist;
        }
        return count;
    }
}