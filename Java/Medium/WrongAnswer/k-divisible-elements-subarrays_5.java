class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        
        int[] mod = new int[p];
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int modVal = sum % p;
            if (modVal < 0) {
                modVal += p;
            }
            if (modVal == 0) {
                count++;
            }
            if (i >= k) {
                sum -= nums[i - k];
            }
            count += mod[modVal];
            mod[modVal]++;
        }
        return count;
    }
}