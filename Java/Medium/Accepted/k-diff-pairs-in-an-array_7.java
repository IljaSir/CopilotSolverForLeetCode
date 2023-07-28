class Solution {
    public int findPairs(int[] nums, int k) {
        
        if (k < 0) return 0;
        int count = 0;
        Arrays.sort(nums);
        int i = 0, j = 1;
        while (i < nums.length && j < nums.length) {
            if (i == j) j++;
            else if (nums[j] - nums[i] == k) {
                count++;
                while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
                i++;
                j++;
            } else if (nums[j] - nums[i] > k) i++;
            else j++;
        }
        return count;
    }
}