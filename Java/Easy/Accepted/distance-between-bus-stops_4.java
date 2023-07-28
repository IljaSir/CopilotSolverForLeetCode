class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        
        int sum = 0, min = 0;
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];
            if (i >= start && i < destination) {
                min += distance[i];
            }
        }
        return Math.min(min, sum - min);
    }
}