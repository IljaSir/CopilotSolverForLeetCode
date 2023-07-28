class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        
        int n = distance.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += distance[i];
        }
        int d = 0;
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        for (int i = start; i < destination; i++) {
            d += distance[i];
        }
        return Math.min(d, sum - d);
    }
}