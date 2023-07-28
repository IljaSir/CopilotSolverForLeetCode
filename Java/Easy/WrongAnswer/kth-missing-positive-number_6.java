class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - i - 1 < k) {
                count = arr[i] - i - 1;
            } else {
                return i + k;
            }
        }
        return arr.length + k - count;
    }
}