class Solution {
    public int numIdenticalPairs(int[] nums) {
        
        int[] count = new int[101];
        int ans = 0;
        for (int num : nums) {
            ans += count[num];
            count[num]++;
        }
        return ans;
    }
}