class Solution {
    public int minIncrementForUnique(int[] nums) {
        
        int[] count = new int[80000];
        for (int x: nums) count[x]++;
        int ans = 0, taken = 0;
        for (int x = 0; x < 80000; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                ans -= x * (count[x] - 1);
            } else if (taken > 0 && count[x] == 0) {
                taken--;
                ans += x;
            }
        }
        return ans;
    }
}