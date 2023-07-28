class Solution {
    public int minSwaps(int[][] grid) {
        
        int n = grid.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            arr[i] = count;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && arr[j] < n - i - 1) {
                j++;
            }
            if (j == n) {
                return -1;
            }
            ans += j - i;
            while (j > i) {
                arr[j] = arr[j - 1];
                j--;
            }
        }
        return ans;
    }
}