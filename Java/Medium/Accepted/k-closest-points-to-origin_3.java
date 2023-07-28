class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int[][] result = new int[k][2];
        int[] distance = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            distance[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }
        Arrays.sort(distance);
        int distanceK = distance[k - 1];
        int index = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] * points[i][0] + points[i][1] * points[i][1] <= distanceK) {
                result[index] = points[i];
                index++;
            }
        }
        return result;
    }
}