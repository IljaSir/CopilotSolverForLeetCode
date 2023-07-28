class Solution {
    public int minOperations(int[] nums, int x) {
        
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int target = sum - x;
        if (target == 0) return n;
        int max = -1;
        int i = 0;
        int j = 0;
        int curr = 0;
        while (j < n) {
            curr += nums[j];
            while (curr > target && i <= j) {
                curr -= nums[i];
                i++;
            }
            if (curr == target) {
                max = Math.max(max, j - i + 1);
            }
            j++;
        }
        if (max == -1) return -1;
        return n - max;
    }
}