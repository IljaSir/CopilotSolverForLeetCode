class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int[] ans = new int[2];
        int[] cnt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i] - 1]++;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 2) {
                ans[0] = i + 1;
            }
            if (cnt[i] == 0) {
                ans[1] = i + 1;
            }
        }
        return ans;
    }
}