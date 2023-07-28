class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        
        int[] pacman = new int[]{0, 0};
        int dist = getDistance(pacman, target);
        for (int[] ghost : ghosts) {
            if (getDistance(ghost, target) <= dist) {
                return false;
            }
        }
        return true;
    }
}