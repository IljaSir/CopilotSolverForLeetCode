class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        for (int rank : ranks) {
            pq.add(rank);
        }
        long time = 0;
        int count = 0;
        while (count < cars) {
            int rank = pq.poll();
            count += rank;
            time += (long) rank * rank * rank;
            pq.add(rank - 1);
        }
        return time;
    }
}