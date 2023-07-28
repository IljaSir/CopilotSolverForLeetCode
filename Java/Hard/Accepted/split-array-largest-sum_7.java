class Solution {
    public int splitArray(int[] nums, int k) {
        
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean check(int[] nums, int k, int max) {
        int sum = 0, count = 1;
        for (int num : nums) {
            sum += num;
            if (sum > max) {
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