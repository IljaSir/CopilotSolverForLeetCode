class Solution {
    public int maximumProduct(int[] nums, int k) {
        
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i=0; i<n; i++) {
            pq.offer(nums[i]);
        }
        for (int i=0; i<k; i++) {
            int x = pq.poll();
            pq.offer(x+1);
        }
        long res = 1;
        while (!pq.isEmpty()) {
            res = res * pq.poll() % 1000000007;
        }
        return (int)res;
    }
}