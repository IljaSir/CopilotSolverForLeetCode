class Solution {
    public int getWinner(int[] arr, int k) {
        
        int i = 0, j = 1;
        int count = 0;
        while (i < arr.length && j < arr.length) {
            if (arr[i] > arr[j]) {
                j++;
                count++;
            } else {
                i = j;
                j++;
                count = 1;
            }
            if (count == k) {
                return arr[i];
            }
        }
        return arr[i];
    }
}