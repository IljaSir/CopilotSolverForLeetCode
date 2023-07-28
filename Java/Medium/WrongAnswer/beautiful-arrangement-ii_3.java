class Solution {
    public int[] constructArray(int n, int k) {
        
        int[] result = new int[n];
        int i = 0;
        int l = 1;
        int r = n;
        while (i < k) {
            if (i % 2 == 0) {
                result[i++] = l++;
            } else {
                result[i++] = r--;
            }
        }
        if (k % 2 == 0) {
            while (i < n) {
                result[i++] = l++;
            }
        } else {
            while (i < n) {
                result[i++] = r--;
            }
        }
        return result;
    }
}