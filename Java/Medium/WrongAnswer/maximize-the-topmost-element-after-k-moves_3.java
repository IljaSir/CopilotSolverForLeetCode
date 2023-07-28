class Solution {
    public int maximumTop(int[] nums, int k) {
        
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n);
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        int ans = pq.peek();
        for (int i = 0; i < k; i++) {
            ans = pq.poll();
            ans--;
            pq.add(ans);
        }
        return ans;
    }
}