class Solution {
    public void duplicateZeros(int[] arr) {
        
        int[] copy = Arrays.copyOf(arr, arr.length);
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (copy[i] == 0) {
                arr[j++] = 0;
                if (j < arr.length) {
                    arr[j] = 0;
                }
            } else {
                arr[j] = copy[i];
            }
            i++;
        }
    }
}