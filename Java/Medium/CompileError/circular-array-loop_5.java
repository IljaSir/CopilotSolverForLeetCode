class Solution {
    public boolean circularArrayLoop(int[] nums) {
        
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] == 0) continue;
            int slow = i, fast = next(nums, i);
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow != next(nums, slow)) return true;
                    else break;
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