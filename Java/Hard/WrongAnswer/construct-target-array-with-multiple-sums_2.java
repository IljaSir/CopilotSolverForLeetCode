class Solution {
    public boolean isPossible(int[] target) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;
        for (int i : target) {
            sum += i;
            pq.offer(i);
        }
        while (pq.peek() != 1) {
            int x = pq.poll();
            sum -= x;
            if (x <= sum || sum < 1) {
                return false;
            }
            x %= sum;
            sum += x;
            pq.offer(x);
        }
        return true;
    }
}