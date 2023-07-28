class Solution {
    public int[] constructArray(int n, int k) {
        
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = i + 1;
        }
        int l = 1, r = k;
        while(l < r) {
            int temp = ans[l];
            ans[l] = ans[r];
            ans[r] = temp;
            l++;
            r--;
        }
        for(int i = k + 1; i < n; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}