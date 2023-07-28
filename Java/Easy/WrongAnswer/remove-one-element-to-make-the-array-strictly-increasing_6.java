class Solution {
    public boolean canBeIncreasing(int[] nums) {
        
        if (nums.length == 2) return true;
        int i = 0;
        while (i < nums.length - 1 && nums[i] < nums[i + 1]) i++;
        if (i == nums.length - 1) return true;
        if (i == 0 || nums[i - 1] < nums[i + 1]) {
            int j = i + 1;
            while (j < nums.length - 1 && nums[j] < nums[j + 1]) j++;
            if (j == nums.length - 1) return true;
            else return false;
        } else if (i == nums.length - 2 || nums[i] < nums[i + 2]) {
            int j = i + 2;
            while (j < nums.length - 1 && nums[j] < nums[j + 1]) j++;
            if (j == nums.length - 1) return true;
            else return false;
        } else return false;
    }
}