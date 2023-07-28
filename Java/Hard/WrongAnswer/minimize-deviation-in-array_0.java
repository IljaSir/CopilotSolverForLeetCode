class Solution {
    public int minimumDeviation(int[] nums) {
        
        int n = nums.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i] % 2 == 0 ? nums[i] : nums[i] * 2;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x, y) -> y - x);
        for (int x : a) {
            pq.offer(x);
        }
        int ans = pq.peek() - pq.peek() % 2;
        while (pq.peek() % 2 == 0) {
            int x = pq.poll();
            pq.offer(x / 2);
            ans = Math.min(ans, pq.peek() - pq.peek() % 2);
        }
        return ans;
    }
}