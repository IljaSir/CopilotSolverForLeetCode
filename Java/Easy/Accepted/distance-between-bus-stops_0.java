class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int clockwise = 0;
        int counterclockwise = 0;
        for (int i = start; i < destination; i++) {
            clockwise += distance[i];
        }
        for (int i = 0; i < start; i++) {
            counterclockwise += distance[i];
        }
        for (int i = destination; i < distance.length; i++) {
            counterclockwise += distance[i];
        }
        return Math.min(clockwise, counterclockwise);
    }
}