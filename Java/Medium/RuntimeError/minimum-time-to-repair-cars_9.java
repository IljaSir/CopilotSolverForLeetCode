class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ranks.length; i++) {
            pq.add(ranks[i]);
        }
        while (cars > 0) {
            int max = pq.poll();
            cars -= max;
            pq.add(max - 1);
        }
        long min = 0;
        while (!pq.isEmpty()) {
            min += pq.poll() * pq.poll() * pq.poll();
        }
        return min;
    }
}