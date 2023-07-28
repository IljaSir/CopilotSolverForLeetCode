class Solution {
    public int addRungs(int[] rungs, int dist) {
        
        int result = 0;
        int prev = 0;
        for (int i = 0; i < rungs.length; i++) {
            int diff = rungs[i] - prev;
            if (diff <= dist) {
                prev = rungs[i];
            } else {
                int count = diff / dist;
                if (diff % dist == 0) {
                    count--;
                }
                result += count;
                prev = rungs[i];
            }
        }
        return result;
    }
}