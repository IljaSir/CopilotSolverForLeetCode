class Solution {
    public int[] constructArray(int n, int k) {
        
        int[] ans = new int[n];
        int i = 0;
        int l = 1;
        int r = n;
        while (l < r) {
            if (k > 1) {
                if (k % 2 == 0) {
                    ans[i++] = l++;
                } else {
                    ans[i++] = r--;
                }
                k--;
            } else {
                ans[i++] = l++;
            }
        }
        ans[i] = l;
        return ans;
    }
}