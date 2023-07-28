class Solution {
    public void duplicateZeros(int[] arr) {
        
        int i = 0;
        int j = 0;
        int[] copy = new int[arr.length];
        while (i < arr.length) {
            if (arr[i] == 0) {
                copy[j++] = 0;
                copy[j++] = 0;
            } else {
                copy[j++] = arr[i];
            }
            i++;
        }
        for (i = 0; i < arr.length; i++) {
            arr[i] = copy[i];
        }
    }
}