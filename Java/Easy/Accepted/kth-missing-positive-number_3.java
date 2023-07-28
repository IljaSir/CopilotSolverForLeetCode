class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int n = arr.length;
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - (mid + 1) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left + k;
    }
}