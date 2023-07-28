class Solution {
    public void duplicateZeros(int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int[] temp = new int[arr.length];
                for (int j = 0; j < i; j++) {
                    temp[j] = arr[j];
                }
                temp[i] = 0;
                temp[i + 1] = 0;
                for (int j = i + 2; j < arr.length; j++) {
                    temp[j] = arr[j - 1];
                }
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = temp[j];
                }
            }
        }
    }
}