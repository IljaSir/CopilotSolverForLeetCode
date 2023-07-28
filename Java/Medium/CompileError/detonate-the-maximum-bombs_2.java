class Solution {
    public int maximumDetonation(int[][] bombs) {
        
        int max = 0;
        for (int i = 0; i < bombs.length; i++) {
            int count = 1;
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) continue;
                if (inRange(bombs[i], bombs[j])) count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}