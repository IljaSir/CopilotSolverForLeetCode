class Solution {
    public long maxKelements(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        long sum = 0;
        for (int num : pq) {
            sum += num;
        }
        return sum;
    }
    
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[k] = k;
        for (int i = k - 1; i >= 0; i--) {
            left[i] = nums[i] <= nums[left[i + 1]] ? i : left[i + 1];
        }
        right[k] = k;
        for (int i = k + 1; i < n; i++) {
            right[i] = nums[i] < nums[right[i - 1]] ? i : right[i - 1];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];
            int len = r - l + 1;
            if (len > k + 1) {
                continue;
            }
            ans = Math.max(ans, maxKelements(nums, k + 1 - len) + (long) nums[i] * len);
        }
        return (int) (ans % (long) (1e9 + 7));
    }
}