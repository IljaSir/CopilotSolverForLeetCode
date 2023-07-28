class Solution {
    public int getWinner(int[] arr, int k) {
        
        int max = arr[0];
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                cnt = 0;
            }
            if (++cnt == k) {
                break;
            }
        }
        return max;
    }
}