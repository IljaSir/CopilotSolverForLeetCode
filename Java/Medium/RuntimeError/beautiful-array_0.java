class Solution {
    public int[] beautifulArray(int n) {
        
        int[] ans = new int[n];
        ans[0] = 1;
        int i = 1;
        while (i < n) {
            for (int j = 0; j < i; j++) {
                ans[i + j] = ans[j] * 2;
            }
            for (int j = 0; j < i; j++) {
                ans[i + j + i] = ans[j] * 2 - 1;
            }
            i *= 2;
        }
        return ans;
    }
}