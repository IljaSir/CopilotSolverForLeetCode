class Solution {
    public int getWinner(int[] arr, int k) {
        
        int n = arr.length;
        int max = arr[0];
        int counter = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                counter = 1;
            } else {
                counter++;
            }
            if (counter == k) {
                return max;
            }
        }
        return max;
    }
}