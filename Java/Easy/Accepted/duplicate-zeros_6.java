class Solution {
    public void duplicateZeros(int[] arr) {
        
        int n = arr.length;
        int[] arr2 = new int[n];
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (arr[i] == 0) {
                arr2[j] = 0;
                j++;
                if (j < n) {
                    arr2[j] = 0;
                    j++;
                }
            } else {
                arr2[j] = arr[i];
                j++;
            }
            i++;
        }
        for (i = 0; i < n; i++) {
            arr[i] = arr2[i];
        }
    }
}