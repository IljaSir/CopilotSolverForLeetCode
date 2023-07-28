class Solution {
    public int minImpossibleOR(int[] nums) {
        
        Arrays.sort(nums);
        long ans = 1;
        for (int num : nums) {
            if (num <= ans) {
                ans += num;
            } else {
                break;
            }
        }
        return (int) ans;
    }
}