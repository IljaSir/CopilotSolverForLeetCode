class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(nums, mid, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int mid, int maxOperations) {
        for (int num : nums) {
            if (num <= mid) {
                continue;
            }
            int count = num / mid;
            if (num % mid == 0) {
                count--;
            }
            maxOperations -= count;
            if (maxOperations < 0) {
                return false;
            }
        }
        return true;
    }
}