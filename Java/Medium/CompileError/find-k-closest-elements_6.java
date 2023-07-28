class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                right = mid - 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int i = left;
        int j = left - 1;
        while (k > 0) {
            if (i < arr.length && j >= 0) {
                if (Math.abs(arr[i - x < Math.abs(arr[j] - x)) {
                    i++
    }
}