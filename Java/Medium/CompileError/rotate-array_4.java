class Solution {
    public void rotate(int[] nums, int k) {
        
        if (k == 0) {
            return;
        }
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }
}
    }
}