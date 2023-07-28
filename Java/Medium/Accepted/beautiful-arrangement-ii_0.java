class Solution {
    public int[] constructArray(int n, int k) {
        
        int[] res = new int[n];
        int i = 0, l = 1, r = n;
        while (l <= r) {
            res[i++] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
        }
        return res;
    }
}