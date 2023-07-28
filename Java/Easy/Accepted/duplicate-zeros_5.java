class Solution {
    public void duplicateZeros(int[] arr) {
        
        int i = 0;
        int j = 0;
        while (i < arr.length) {
            if (arr[i] == 0) {
                j++;
            }
            i++;
            j++;
        }
        for (i = arr.length - 1; i >= 0; i--) {
            j--;
            if (j < arr.length) {
                arr[j] = arr[i];
            }
            if (arr[i] == 0) {
                j--;
                if (j < arr.length) {
                    arr[j] = 0;
                }
            }
        }
    }
}