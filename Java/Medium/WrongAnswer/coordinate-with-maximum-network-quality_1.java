class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        
        int[] ans = new int[2];
        int max = 0;
        for (int i = 0; i < towers.length; i++) {
            for (int j = 0; j < towers.length; j++) {
                int x = towers[i][0], y = towers[i][1];
                int x1 = towers[j][0], y1 = towers[j][1];
                int distance = (int) Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
                if (distance <= radius) {
                    towers[i][2] += (int) Math.floor(towers[j][2] / (1 + distance));
                }
            }
            if (towers[i][2] > max) {
                max = towers[i][2];
                ans[0] = towers[i][0];
                ans[1] = towers[i][1];
            }
        }
        return ans;
    }
}