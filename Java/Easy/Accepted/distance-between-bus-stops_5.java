class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        
        int total = 0;
        for (int i = 0; i < distance.length; i++) {
            total += distance[i];
        }
        int clockwise = 0;
        int i = start;
        while (i != destination) {
            clockwise += distance[i];
            i = (i + 1) % distance.length;
        }
        int counterClockwise = total - clockwise;
        return Math.min(clockwise, counterClockwise);
    }
}