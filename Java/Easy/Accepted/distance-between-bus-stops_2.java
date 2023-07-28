class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        
        int sum = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];
        }
        int min = Math.min(start, destination);
        int max = Math.max(start, destination);
        int sum1 = 0;
        for (int i = min; i < max; i++) {
            sum1 += distance[i];
        }
        return Math.min(sum1, sum - sum1);
    }
}