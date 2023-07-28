class Solution {
    public int countArrangement(int n) {
        
        int[] arr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }
        return countArrangement(arr, 1);
    }
    
    private int countArrangement(int[] arr, int index) {
        if (index == arr.length) {
            return 1;
        }
        int count = 0;
        for (int i = index; i < arr.length; i++) {
            if (arr[i] % index == 0 || index % arr[i] == 0) {
                swap(arr, index, i);
                count += countArrangement(arr, index+1);
                swap(arr, index, i);
            }
        }
        return count;
    }
}