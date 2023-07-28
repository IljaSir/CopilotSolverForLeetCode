class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        
        int n = arr.length;
        for (int i = 0; i < n - m; i++) {
            int j = i + m;
            int count = 1;
            while (j + m <= n) {
                boolean isMatch = true;
                for (int p = 0; p < m; p++) {
                    if (arr[i + p] != arr[j + p]) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
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