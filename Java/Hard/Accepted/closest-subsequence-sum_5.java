class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        
        int n = nums.length;
        int[] left = new int[1 << (n / 2)];
        int[] right = new int[1 << (n - n / 2)];
        
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < n / 2; j++) {
                if ((i & (1 << j)) != 0) {
                    left[i] += nums[j];
                }
            }
        }
        
        for (int i = 0; i < right.length; i++) {
            for (int j = 0; j < n - n / 2; j++) {
                if ((i & (1 << j)) != 0) {
                    right[i] += nums[n / 2 + j];
                }
            }
        }
        
        Arrays.sort(left);
        Arrays.sort(right);
        
        int ans = Math.abs(goal);
        int l = 0, r = right.length - 1;
        while (l < left.length && r >= 0) {
            int sum = left[l] + right[r];
            if (Math.abs(sum - goal) < ans) {
                ans = Math.abs(sum - goal);
            }
            
            if (sum > goal) {
                r--;
            } else {
                l++;
            }
        }
        
        return ans;
    }
}