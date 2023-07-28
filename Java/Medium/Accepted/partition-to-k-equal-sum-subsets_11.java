class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > target) {
            return false;
        }
        while (n >= 1 && nums[n - 1] == target) {
            n--;
            k--;
        }
        return search(new int[k], nums, n - 1, target);
    }
    private boolean search(int[] groups, int[] nums, int i, int target) {
        if (i < 0) {
            return true;
        }
        int v = nums[i];
        for (int j = 0; j < groups.length; j++) {
            if (groups[j] + v <= target) {
                groups[j] += v;
                if (search(groups, nums, i - 1, target)) {
                    return true;
                }
                groups[j] -= v;
            }
            if (groups[j] == 0) {
                break;
            }
        }
        return false;
    }
}