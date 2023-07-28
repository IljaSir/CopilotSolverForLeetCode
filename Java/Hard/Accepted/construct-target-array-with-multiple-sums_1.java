class Solution {
    public boolean isPossible(int[] target) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;
        for (int i : target) {
            sum += i;
            pq.offer(i);
        }
        while (true) {
            int curr = pq.poll();
            sum -= curr;
            if (curr == 1 || sum == 1) return true;
            if (curr < sum || sum == 0 || curr % sum == 0) return false;
            curr %= sum;
            sum += curr;
            pq.offer(curr);
        }
    }
}