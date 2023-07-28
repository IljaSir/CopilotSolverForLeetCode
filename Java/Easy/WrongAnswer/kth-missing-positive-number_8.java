class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int i = 0;
        int j = 0;
        while (i < arr.length && j < k) {
            if (arr[i] == i + 1) {
                i++;
            } else {
                j++;
                i++;
            }
        }
        if (j == k) {
            return i;
        } else {
            return i + k - j;
        }
    }
}