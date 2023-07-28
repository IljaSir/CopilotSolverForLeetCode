class Solution {
    public int getWinner(int[] arr, int k) {
        
        int i = 0, j = 1, win = 0;
        while (win < k) {
            if (arr[i] < arr[j]) {
                arr[i] = arr[j] - arr[i];
                arr[j] = arr[j] - arr[i];
                arr[i] = arr[j] + arr[i];
                i = j;
                win = 1;
            } else {
                win++;
            }
            j = (j + 1) % arr.length;
            if (i == 0 && j == 1) {
                return arr[i];
            }
        }
        return arr[i];
    }
}