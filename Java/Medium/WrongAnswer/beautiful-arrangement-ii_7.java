class Solution {
    public int[] constructArray(int n, int k) {
        
        int[] result = new int[n];
        int left = 1;
        int right = n;
        int index = 0;
        for (int i = 0; i < k; i++) {
            if (i % 2 == 0) {
                result[index++] = left++;
            } else {
                result[index++] = right--;
            }
        }
        if (k % 2 == 0) {
            for (int i = left; i <= right; i++) {
                result[index++] = i;
            }
        } else {
            for (int i = right; i >= left; i--) {
                result[index++] = i;
            }
        }
        return result;
    }
}