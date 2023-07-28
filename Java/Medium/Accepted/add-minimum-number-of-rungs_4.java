class Solution {
    public int addRungs(int[] rungs, int dist) {
        
        int count = 0;
        int prev = 0;
        for (int rung : rungs) {
            int diff = rung - prev;
            if (diff > dist) {
                count += (diff - 1) / dist;
            }
            prev = rung;
        }
        return count;
    }
}