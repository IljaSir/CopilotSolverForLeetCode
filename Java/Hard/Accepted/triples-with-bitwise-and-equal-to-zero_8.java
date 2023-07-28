class Solution {
    public int countTriplets(int[] nums) {
        
        int result = 0;
        int[] count = new int[1 << 16];
        for (int num : nums) {
            for (int num2 : nums) {
                count[num & num2]++;
            }
        }
        for (int num : nums) {
            for (int i = 0; i < count.length; i++) {
                if ((num & i) == 0) {
                    result += count[i];
                }
            }
        }
        return result;
    }
}