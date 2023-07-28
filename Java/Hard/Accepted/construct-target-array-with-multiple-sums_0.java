class Solution {
    public boolean isPossible(int[] target) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;
        for (int i : target) {
            sum += i;
            pq.offer(i);
        }
        while (true) {
            int max = pq.poll();
            sum -= max;
            if (max == 1 || sum == 1) {
                return true;
            }
            if (max < sum || sum == 0 || max % sum == 0) {
                return false;
            }
            max %= sum;
            sum += max;
            pq.offer(max);
        }
    }
}