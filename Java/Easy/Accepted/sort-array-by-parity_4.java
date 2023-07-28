class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        for (int n : nums) {
            if (n % 2 == 0) {
                result[i++] = n;
            } else {
                result[j--] = n;
            }
        }
        return result;
    }
}