class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        
        int n = nums.length;
        int m = numsDivide.length;
        long gcd = numsDivide[0];
        for (int i = 1; i < m; i++) {
            gcd = gcd(gcd, numsDivide[i]);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > gcd) {
                return -1;
            }
        }
        int[] count = new int[1000001];
        for (int i = 0; i < m; i++) {
            count[(int) (numsDivide[i] / gcd)]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int g = (int) (gcd(nums[i], gcd));
            int x = (int) (gcd / g);
            ans += count[x];
            for (int j = x; j <= 1000000; j += x) {
                count[j]--;
            }
        }
        return n - ans;
    }
}