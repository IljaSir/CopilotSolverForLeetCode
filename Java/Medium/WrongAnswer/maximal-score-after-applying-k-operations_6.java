class Solution {
    public long maxKelements(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        long res = 0;
        for (int num : pq) {
            res += num;
        }
        return res;
    }
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[k + 1];
        int[] right = new int[k + 1];
        for (int i = 0; i < k; i++) {
            left[i + 1] = left[i] + nums[i];
        }
        for (int i = n - 1; i >= n - k; i--) {
            right[k - (n - i - 1)] = right[k - (n - i)] + nums[i];
        }
        long res = 0;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, maxKelements(nums, k - i) + left[i] + right[k - i]);
        }
        return (int) (res % 1000000007);
    }
}