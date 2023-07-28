class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        
        int[] result = new int[2];
        int max = 0;
        for (int i = 0; i < towers.length; i++) {
            int x1 = towers[i][0];
            int y1 = towers[i][1];
            int q1 = towers[i][2];
            int sum = 0;
            for (int j = 0; j < towers.length; j++) {
                int x2 = towers[j][0];
                int y2 = towers[j][1];
                int q2 = towers[j][2];
                double distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
                if (distance <= radius) {
                    sum += Math.floor(q2 / (1 + distance));
                }
            }
            if (sum > max) {
                max = sum;
                result[0] = x1;
                result[1] = y1;
            } else if (sum == max) {
                if (x1 < result[0]) {
                    result[0] = x1;
                    result[1] = y1;
                } else if (x1 == result[0] && y1 < result[1]) {
                    result[1] = y1;
                }
            }
        }
        return result;
    }
}