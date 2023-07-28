class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        int m = arr2.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= arr1[i];
        }
        int res2 = 0;
        for (int i = 0; i < m; i++) {
            res2 ^= arr2[i];
        }
        return res & res2;
    }
}