class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        
        int total = 0;
        for (int i = 0; i < distance.length; i++) {
            total += distance[i];
        }
        int clockwise = 0;
        for (int i = start; i != destination; i = (i + 1) % distance.length) {
            clockwise += distance[i];
        }
        return Math.min(clockwise, total - clockwise);
    }
}