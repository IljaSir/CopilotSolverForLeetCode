class Solution {
    public int[] sumZero(int n) {
        
        int[] ans = new int[n];
        int k = 0;
        if(n % 2 == 1) {
            ans[k++] = 0;
        }
        for(int i = 1; i <= n / 2; i++) {
            ans[k++] = i;
            ans[k++] = -i;
        }
        return ans;
    }
}