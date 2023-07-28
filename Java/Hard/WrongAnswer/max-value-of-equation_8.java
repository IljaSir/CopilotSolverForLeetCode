class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        int n = points.length;
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 1;
        while (j < n) {
            while (i < j && points[j][0] - points[i][0] > k) {
                i++;
            }
            max = Math.max(max, points[i][1] + points[j][1] + points[j][0] - points[i][0]);
            j++;
        }
        return max;
    }
}