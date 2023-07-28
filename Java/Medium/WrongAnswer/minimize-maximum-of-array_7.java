class Solution {
    public int minimizeArrayValue(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int l = 0;
        int r = max;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(nums, mid, sum)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int limit, int sum) {
        int cur = 0;
        for (int num : nums) {
            cur += num;
            if (cur > limit) {
                sum -= cur - limit;
                cur = limit;
                if (sum < limit) {
                    return false;
                }
            }
        }
        return true;
    }
}