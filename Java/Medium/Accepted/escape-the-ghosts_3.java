class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ghosts.length; i++) {
            min = Math.min(min, Math.abs(ghosts[i][0] - target[0]) + Math.abs(ghosts[i][1] - target[1]));
        }
        return Math.abs(target[0]) + Math.abs(target[1]) < min;
    }
}