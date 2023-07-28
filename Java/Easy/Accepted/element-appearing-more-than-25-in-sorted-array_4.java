class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int n = arr.length;
        int limit = n / 4;
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[i + limit]) {
                return arr[i];
            }
        }
        return -1;
    }
}