class Solution {
    public boolean isPossible(int[] target) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long total = 0;
        for (int num : target) {
            pq.offer(num);
            total += num;
        }
        while (true) {
            int num = pq.poll();
            total -= num;
            if (num == 1 || total == 1) {
                return true;
            }
            if (num < total || total == 0 || num % total == 0) {
                return false;
            }
            num %= total;
            total += num;
            pq.offer(num);
        }
    }
}