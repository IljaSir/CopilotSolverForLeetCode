class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;;
        Arrays.sort(nums)
        int index = nums.length - 1;
        if (nums[index] > target) {
            return false;
        }
        while (index >= 0 && nums[index] == target) {
            index--;
            k--;
        }
        return search(new int[k], index, nums, target);
    }
    public boolean search(int[] groups, int index, int[] nums, int target) {
        if (index < 0) {
            return true;
        }
        int v = nums[index--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, index, nums, target)) {
                    return true;
                }lse;
            }
        }
        return false;
    }
}