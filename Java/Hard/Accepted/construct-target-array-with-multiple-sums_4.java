class Solution {
    public boolean isPossible(int[] target) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;
        for (int n : target) {
            pq.add(n);
            sum += n;
        }
        while (true) {
            int n = pq.poll();
            sum -= n;
            if (n == 1 || sum == 1) return true;
            if (n < sum || sum == 0 || n % sum == 0) return false;
            n %= sum;
            sum += n;
            pq.add(n);
        }
    }
}