class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < tires.length; i++) {
            pq.offer(new int[]{tires[i][0], tires[i][1], 1});
        }
        int time = 0;
        while (numLaps > 0) {
            int[] cur = pq.poll();
            time += cur[0];
            cur[2]++;
            cur[0] = cur[1] * cur[2] * cur[0];
            pq.offer(cur);
            numLaps--;
        }
        return time;
    }
}