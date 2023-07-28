class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        
        int clockwise = 0;
        int counterclockwise = 0;
        int n = distance.length;
        int i = start;
        while (i != destination) {
            clockwise += distance[i];
            i = (i + 1) % n;
        }
        i = destination;
        while (i != start) {
            counterclockwise += distance[i];
            i = (i + 1) % n;
        }
        return Math.min(clockwise, counterclockwise);
    }
}