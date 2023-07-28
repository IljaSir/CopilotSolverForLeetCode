class Solution {
    public long maxKelements(int[] nums, int k) {
        
        long max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            max += pq.poll();
        }
        return max;
    }

    public long maxScore(int[] nums, int k) {
        long max = 0;
        for (int i = 0; i <= k; i++) {
            max = Math.max(max, maxKelements(nums, k - i) + maxKelements(nums, i));
        }
        return max;
    }
}