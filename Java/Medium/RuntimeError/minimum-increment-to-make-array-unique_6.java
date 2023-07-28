class Solution {
    public int minIncrementForUnique(int[] nums) {
        
        int[] count = new int[100000];
        int ans = 0;
        for (int x: nums) {
            count[x]++;
        }
        for (int i = 0; i < 100000; i++) {
            if (count[i] > 1) {
                int delta = count[i] - 1;
                ans += delta;
                count[i + 1] += delta;
            }
        }
        return ans;
    }
}