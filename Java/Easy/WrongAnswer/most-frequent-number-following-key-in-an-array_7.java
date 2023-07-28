class Solution {
    public int mostFrequent(int[] nums, int key) {
        
        int maxCount = -1;
        int maxTarget = -1;
        int count = 0;
        int target = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                count = 0;
                target = -1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != key) {
                        if (target == -1) {
                            target = nums[j];
                        }
                        if (nums[j] == target) {
                            count++;
                        }
                    } else {
                        break;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    maxTarget = target;
                }
            }
        }
        return maxTarget;
    }
}