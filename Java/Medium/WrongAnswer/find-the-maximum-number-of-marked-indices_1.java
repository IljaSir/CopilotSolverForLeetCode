class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[32];
        for (int num : nums) {
            count[Integer.numberOfTrailingZeros(num)]++;
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            count[i] = (count[i] + 1) / 2;
            ans += count[i];
        }
        return ans;
    }
}