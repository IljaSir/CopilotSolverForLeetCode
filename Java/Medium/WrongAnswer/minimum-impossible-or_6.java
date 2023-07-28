class Solution {
    public int minImpossibleOR(int[] nums) {
        
        Arrays.sort(nums);
        long res = 1;
        for (int num : nums) {
            if (num > res) {
                break;
            } else {
                res += num;
            }
        }
        return (int) res;
    }
}