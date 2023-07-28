class Solution {
    public int minimumDeviation(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int max = 0;
        for (int num : nums) {
            if (num % 2 == 1) num *= 2;
            pq.offer(num);
            max = Math.max(max, num);
        }
        int ans = Integer.MAX_VALUE;
        while (pq.size() > 0) {
            int num = pq.poll();
            ans = Math.min(ans, max - num);
            if (num % 2 == 1) break;
            num /= 2;
            max = Math.max(max, num);
            pq.offer(num);
        }
        return ans;
    }
}