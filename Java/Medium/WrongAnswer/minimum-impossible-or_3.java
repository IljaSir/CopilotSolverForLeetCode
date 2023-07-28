class Solution {
    public int minImpossibleOR(int[] nums) {
        
        Arrays.sort(nums);
        int ans = 1;
        for (int num : nums) {
            if (num > ans) {
                break;
            }
            ans += num;
        }
        return ans;
    }
}