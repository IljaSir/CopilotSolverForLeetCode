class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int n = arr.length;
        int lo = 0;
        int hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] - (mid + 1) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo + k;
    }
}