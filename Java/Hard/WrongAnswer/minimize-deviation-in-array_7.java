class Solution {
    public int minimumDeviation(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num % 2 == 1) {
                num *= 2;
            }
            pq.offer(-num);
            max = Math.max(max, num);
        }
        int res = Integer.MAX_VALUE;
        while (true) {
            int cur = -pq.poll();
            res = Math.min(res, max - cur);
            if (cur % 2 == 1) {
                break;
            }
            pq.offer(-cur / 2);
            max = Math.max(max, cur / 2);
        }
        return res;
    }
}