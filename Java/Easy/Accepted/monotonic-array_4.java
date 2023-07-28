class Solution {
    public boolean isMonotonic(int[] nums) {
        
        int n = nums.length;
        if (n == 1) return true;
        int i = 0;
        while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        if (i == n - 1) return true;
        boolean inc = nums[i] < nums[i + 1];
        for (int j = i + 1; j < n - 1; j++) {
            if (inc && nums[j] > nums[j + 1]) return false;
            if (!inc && nums[j] < nums[j + 1]) return false;
        }
        return true;
    }
}