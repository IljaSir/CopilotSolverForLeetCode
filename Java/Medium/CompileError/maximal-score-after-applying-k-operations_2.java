class Solution {
    public long maxKelements(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                sum += pq.poll();
            }
        }
        return sum;
    }
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int min = nums[k];
        int l = k, r = k;
        long res = (long) min * k;
        while (l > 0 || r < n - 1) {
            if (l == 0) {
                r++;
            } else if (r == n - 1) {
                l--;
            } else if (nums[l - 1] < nums[r + 1]) {
                r++;
            } else {
                l--;
            }
            min = Math.min(min, Math.min(nums[l], nums[r]));
            res = Math.max(res, (long) min * (r - l + 1));
        }
        return (int) res;
    }
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int min = nums[k];
        int l = k, r = k;
        long res = (long) min * k;
        while (l > 0 || r < n - 1) {
            if (l == 0) {
                r++;
            } else if (r == n - 1) {
                l--;
            } else if (nums[l - 1] < nums[r + 1]) {
                r++;
            } else {
                l--;
            }
            min = Math.min(min, Math.min(nums[l], nums[r]));
            res = Math.max(res, (long) min * (r - l + 1));
        }
        return (int) res;
    }
}