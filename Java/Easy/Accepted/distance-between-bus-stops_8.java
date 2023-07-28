class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        
        int sum = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];
        }
        int min = 0;
        int max = 0;
        if (start < destination) {
            min = start;
            max = destination;
        } else {
            min = destination;
            max = start;
        }
        int sum2 = 0;
        for (int i = min; i < max; i++) {
            sum2 += distance[i];
        }
        return Math.min(sum2, sum - sum2);
    }
}