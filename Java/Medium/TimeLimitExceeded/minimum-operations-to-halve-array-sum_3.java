class Solution {
    public int halveArray(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;
        for (int num : nums) {
            sum += num;
            pq.offer(num);
        }
        int count = 0;
        while (sum >= 0) {
            int num = pq.poll();
            sum -= num;
            sum += num / 2;
            pq.offer(num / 2);
            count++;
        }
        return count;
    }
}