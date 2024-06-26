class Solution {
    public int[] constructArray(int n, int k) {
        
        int[] result = new int[n];
        int left = 1, right = n;
        for (int i = 0; i < n; i++) {
            if (k > 1) {
                result[i] = k % 2 != 0 ? left++ : right--;
                k--;
            } else {
                result[i] = left++;
            }
        }
        return result;
    }
}