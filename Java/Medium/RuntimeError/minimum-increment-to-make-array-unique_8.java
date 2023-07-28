class Solution {
    public int minIncrementForUnique(int[] nums) {
        
        int[] counter = new int[100000];
        for (int n : nums) {
            counter[n] += 1;
        }
        int ans = 0;
        int taken = 0;
        for (int i = 0; i < 100000; i++) {
            if (counter[i] >= 2) {
                taken += counter[i] - 1;
                ans -= i * (counter[i] - 1);
            } else if (taken > 0 && counter[i] == 0) {
                taken--;
                ans += i;
            }
        }
        return ans;
    }
}