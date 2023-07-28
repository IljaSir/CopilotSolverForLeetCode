class Solution {
    public boolean circularArrayLoop(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = next(nums, i);
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow == next(nums, slow)) {
                        break;
                    }
                    return true;
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            slow = i;
            int val = nums[slow];
            while (nums[slow] * val > 0) {
                int next = next(nums, slow);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }
}