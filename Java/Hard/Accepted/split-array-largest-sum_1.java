class Solution {
    public int splitArray(int[] nums, int k) {
        
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        if (k == 1) {
            return (int) sum;
        }
        long left = max;
        long right = sum;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (valid(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private boolean valid(int[] nums, int k, long target) {
        int sum = 0;
        int count = 1;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                count++;
                if (count > k) {
                    return false;
                }
            }
        }
        return true;
    }
}