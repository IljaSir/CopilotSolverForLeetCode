class Solution {
    public int minMaxGame(int[] nums) {
        
        int n = nums.length;
        while (n > 1) {
            int[] newNums = new int[n / 2];
            for (int i = 0; i < n / 2; i++) {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
            nums = newNums;
            n /= 2;
        }
        return nums[0];
    }
}
    }
}