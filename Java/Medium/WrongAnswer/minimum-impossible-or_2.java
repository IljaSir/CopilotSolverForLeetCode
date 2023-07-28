class Solution {
    public int minImpossibleOR(int[] nums) {
        
        Arrays.sort(nums);
        int res = 1;
        for (int num : nums) {
            if (num > res) {
                break;
            }
            res += num;
        }
        return res;
    }
}