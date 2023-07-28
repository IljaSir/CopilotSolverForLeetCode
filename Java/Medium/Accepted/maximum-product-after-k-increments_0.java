class Solution {
    public int maximumProduct(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            int min = pq.poll();
            pq.add(min + 1);
        }
        long result = 1;
        while (!pq.isEmpty()) {
            result *= pq.poll();
            result %= 1000000007;
        }
        return (int)result;
    }
}