class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        
        int[] count = new int[32];
        for (int num : nums) {
            int i = 0;
            while (num > 0) {
                count[i] += num & 1;
                num >>= 1;
                i++;
            }
        }
        int res = 0;
        for (int c : count) {
            res += c * (c - 1) / 2;
        }
        return res;
    }
}