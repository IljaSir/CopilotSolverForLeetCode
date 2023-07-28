class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        int total = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int[] box : boxTypes) {
            pq.add(box);
        }
        while (truckSize > 0 && !pq.isEmpty()) {
            int[] box = pq.poll();
            int n = Math.min(box[0], truckSize);
            total += n * box[1];
            truckSize -= n;
        }
        return total;
    }
}