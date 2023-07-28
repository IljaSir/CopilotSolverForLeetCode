class Solution {
    public int[] constructArray(int n, int k) {
        
        int[] res = new int[n];
        int l = 1, r = n;
        for (int i = 0; i < n; i++) {
            res[i] = k % 2 == 0 ? l++ : r--;
            if (k > 1) {
                k--;
            }
        }
        return res;
    }
}