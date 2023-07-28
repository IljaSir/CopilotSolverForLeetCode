class Solution {
    public int triangleNumber(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int k = j + 1;
                while (k < n && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                ans += k - j - 1;
            }
        }
        return ans;
    }
}