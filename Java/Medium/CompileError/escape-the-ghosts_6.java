class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        
        int[] start = {0, 0};
        int d = distance(start, target);
        for (int[] g : ghosts) {
            int d1 = distance(g, target);
            if (d1 <= d) {
                return false;
            }
        }
        return true;
    }
}