class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        
        int[] result = new int[2];
        int max = 0;
        for (int i = 0; i < towers.length; i++) {
            int quality = 0;
            for (int j = 0; j < towers.length; j++) {
                int distance = (int) Math.sqrt(Math.pow(towers[i][0] - towers[j][0], 2) + Math.pow(towers[i][1] - towers[j][1], 2));
                if (distance <= radius) {
                    quality += (int) Math.floor(towers[j][2] / (1.0 + distance));
                }
            }
            if (quality > max) {
                max = quality;
                result[0] = towers[i][0];
                result[1] = towers[i][1];
            } else if (quality == max) {
                if (towers[i][0] < result[0]) {
                    result[0] = towers[i][0];
                    result[1] = towers[i][1];
                } else if (towers[i][0] == result[0] && towers[i][1] < result[1]) {
                    result[1] = towers[i][1];
                }
            }
        }
        return result;
    }
}