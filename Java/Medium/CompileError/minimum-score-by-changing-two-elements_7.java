class Solution {
    public int minimizeSum(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int[] leftMin = new int[n];
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        int[] rightMax = new int[n];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            leftMin[i] = min;
            leftMax[i] = max;
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            rightMin[i] = min;
            rightMax[i] = max;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans, Math.max(rightMax[i + 1] - leftMin[i], rightMin[i + 1] - leftMax[i]));
        }
        return ans;
    }
}
    }
}