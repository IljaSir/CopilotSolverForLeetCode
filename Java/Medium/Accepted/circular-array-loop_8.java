class Solution {
    public boolean circularArrayLoop(int[] nums) {
        
        if (nums.length == 1) {
            return false;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = getNextIndex(nums, i);
            while (nums[fast] * nums[i] > 0 && nums[getNextIndex(nums, fast)] * nums[i] > 0) {
                if (slow == fast) {
                    if (slow != getNextIndex(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = getNextIndex(nums, slow);
                fast = getNextIndex(nums, getNextIndex(nums, fast));
            }
            int add = i;
            while (nums[add] * nums[i] > 0) {
                int tmp = add;
                add = getNextIndex(nums, add);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    private int getNextIndex(int[] nums, int i) {
        int n = nums.length;
        int next = i + nums[i];
        if (next >= 0) {
            return next % n;
        } else {
            return n - (-next % n);
        }
    }
}