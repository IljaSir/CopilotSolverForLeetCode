class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        
        int n = arr.length;
        for (int i = 0; i < n - m; i++) {
            int j = i;
            int count = 0;
            while (j <= n - m) {
                int x = 0;
                for (; x < m; x++) {
                    if (arr[i + x] != arr[j + x]) {
                        break;
                    }
                }
                if (x == m) {
                    count++;
                    j += m;
                } else {
                    break;
                }
            }
            if (count >= k) {
                return true;
            }
        }
        return false;
    }
}