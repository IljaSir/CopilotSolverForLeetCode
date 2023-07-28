class Solution {
    public boolean isPossible(int[] target) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int i : target) {
            pq.offer(i);
            sum += i;
        }
        while (true) {
            int max = pq.poll();
            sum -= max;
            if (max == 1 || sum == 1) return true;
            if (max < sum || sum == 0 || max % sum == 0) return false;
            max %= sum;
            sum += max;
            pq.offer(max);
        }
    }
}