class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}