class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        
        if (start == destination) {
            return 0;
        }
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        int total = 0;
        int direct = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                direct += distance[i];
            }
            total += distance[i];
        }
        return Math.min(direct, total - direct);
    }
}