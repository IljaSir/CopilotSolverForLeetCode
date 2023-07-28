class Solution {
    public int minimumDeviation(int[] nums) {
        
        nt n = nums.length;
        int[ arr =new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                arr[i] = nums[i] 
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