class Solution {
    public int triangleNumber(int[] nums) {
        
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                int sum = nums[i] + nums[j];
                int k = j + 1;
                while (k < nums.length && nums[k] < sum) {
                    k++;
                }
                count += k - j - 1;
            }
        }
        return count;
    }
}