class Solution {
    public int[] sumZero(int n) {
        
        int[] ans = new int[n];
        int i = 0;
        if (n % 2 != 0) {
            ans[i++] = 0;
        }
        for (int j = 1; j <= n / 2; j++) {
            ans[i++] = j;
            ans[i++] = -j;
        }
        return ans;
    }
}