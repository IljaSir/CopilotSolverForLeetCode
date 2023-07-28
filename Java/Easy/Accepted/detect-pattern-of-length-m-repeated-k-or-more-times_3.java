class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        
        int n = arr.length;
        for (int i = 0; i < n - m; i++) {
            int j = i + m;
            int count = 1;
            while (j + m <= n) {
                if (Arrays.equals(Arrays.copyOfRange(arr, i, i + m), Arrays.copyOfRange(arr, j, j + m))) {
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