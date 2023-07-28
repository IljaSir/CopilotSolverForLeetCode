class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        
        int n = arr.length;
        for (int i = 0; i < n - m; i++) {
            int j = i;
            int count = 0;
            while (j + m <= n) {
                boolean match = true;
                for (int p = 0; p < m; p++) {
                    if (arr[i + p] != arr[j + p]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    count++;
                    if (count == k) {
                        return true;
                    }
                    j += m;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}