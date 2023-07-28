class Solution {
    public int findTheWinner(int n, int k) {
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int i = 0;
        while (n > 1) {
            i = (i + k - 1) % n;
            for (int j = i; j < n - 1; j++) {
                arr[j] = arr[j + 1];
            }
            n--;
        }
        return arr[0];
    }
}