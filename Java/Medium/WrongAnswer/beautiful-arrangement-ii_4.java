class Solution {
    public int[] constructArray(int n, int k) {
        
        int[] result = new int[n];
        int i = 0;
        int left = 1;
        int right = n;
        while (i < n) {
            if (k > 1) {
                if (k % 2 == 0) {
                    result[i++] = left++;
                } else {
                    result[i++] = right--;
                }
                k--;
            } else {
                result[i++] = left++;
            }
        }
        return result;
    }
}