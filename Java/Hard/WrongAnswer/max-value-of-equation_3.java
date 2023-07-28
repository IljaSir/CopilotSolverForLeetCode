class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 1;
        while (j < points.length) {
            if (points[j][0] - points[i][0] > k) {
                i++;
            } else {
                max = Math.max(max, points[j][0] + points[j][1] + points[i][0] - points[i][1]);
                j++;
            }
        }
        return max;
    }
}