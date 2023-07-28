class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        int N = heights.length;
        int[] diff = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            diff[i] = heights[i+1] - heights[i];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for (int i = 0; i < N-1; i++) {
            sum += diff[i];
            pq.offer(diff[i]);
            if (sum > bricks) {
                if (ladders > 0) {
                    sum -= pq.poll();
                    ladders--;
                } else {
                    return i;
                }
            }
        }
        return N-1;
    }
}