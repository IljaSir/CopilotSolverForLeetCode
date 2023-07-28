class Solution {
    public int[] separateDigits(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n * 5];
        int index = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (num > 0) {
                ans[index++] = num % 10;
                num /= 10;
            }
        }
        return ans;
    }
}