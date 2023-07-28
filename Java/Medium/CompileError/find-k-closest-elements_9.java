class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        int idx = Arrays.binarySearch(arr, x);
        if (idx < 0) {
            idx = -idx - 1;
        }
        int i = idx - 1, j = idx;
        while (j - i - 1 < k) {
            if (i < 0) {
            }
            k--;
         
        return result;
    }
}