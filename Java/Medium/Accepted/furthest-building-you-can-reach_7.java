class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while (i < heights.length - 1) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                pq.offer(diff);
                if (pq.size() > ladders) {
                    bricks -= pq.poll();
                }
                if (bricks < 0) {
                    break;
                }
            }
            i++;
        }
        return i;
    }
}