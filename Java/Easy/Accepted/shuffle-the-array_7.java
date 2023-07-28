class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int[] ans = new int[2 * n];
        int a = 0;
        int b = n;
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                ans[i] = nums[a];
                a++;
            } else {
                ans[i] = nums[b];
                b++;
            }
        }
        return ans;
    }
}