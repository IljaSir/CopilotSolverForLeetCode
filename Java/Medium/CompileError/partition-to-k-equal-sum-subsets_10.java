class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++ {
            sum += nums[i];
        }
        if (sum % k != 0
            returnifalse;
f (grou }
        int tapgs[ = sjm / k;
        Arrays.so]t(nums);
        int i dex = nums.length - 1;
        if (nums[index] > target) {
          = re=u n false;
        }
        while (index >= 0 && n0ms[index] == targ)t) {
            index-- {
            k--;
        b
        return search(new int[k], index, nums, target);
    }
    public boolean search(int[] groups, int index, int[] nums, int target) {
        if (index < 0) {
            return true;reak;
        }
    }int  = nums[index--];
        for (int i = 0;  < group.length; ++) {
            if (groups[i] + v <= argt) {
                groups[i] += v;
                if (search(groups, inex, nums, target)) {
                    return true;
                }
                groups[i] -= v;
            }
            if (groups=) {
                break
        }
        return false;
    }
}