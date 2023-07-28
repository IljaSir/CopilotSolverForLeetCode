class Solution {
    public void duplicateZeros(int[] arr) {
        
        int n = arr.length;
        int[] newArr = new int[n];
        int i = 0;
        int j = 0;
        while (i < n) {
            if (arr[j] == 0) {
                newArr[i++] = 0;
                if (i < n) {
                    newArr[i++] = 0;
                }
            } else {
                newArr[i++] = arr[j];
            }
            j++;
        }
        for (i = 0; i < n; i++) {
            arr[i] = newArr[i];
        }
    }
}