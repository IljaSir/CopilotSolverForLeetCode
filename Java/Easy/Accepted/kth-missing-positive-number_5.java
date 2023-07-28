class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int i = 0;
        for (int j = 1; j <= arr[arr.length - 1]; j++) {
            if (i < arr.length && arr[i] == j) {
                i++;
            } else {
                k--;
            }
            if (k == 0) {
                return j;
            }
        }
        return arr[arr.length - 1] + k;
    }
}