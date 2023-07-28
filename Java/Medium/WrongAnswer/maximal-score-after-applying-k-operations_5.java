class Solution {
    public long maxKelements(int[] nums, int k) {
        
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) pq.poll();
        }
        for (int n : pq) res += n;
        return res;
    }
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        long[] left = new long[k + 1];
        long[] right = new long[k + 1];
        for (int i = 0; i < k; i++) {
            left[i + 1] = left[i] + nums[i];
            right[i + 1] = right[i] + nums[n - 1 - i];
        }
        long res = 0;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, left[i] + maxKelements(nums, k - i) + right[k - i]);
        }
        return (int) (res % 1000000007);
    }
}