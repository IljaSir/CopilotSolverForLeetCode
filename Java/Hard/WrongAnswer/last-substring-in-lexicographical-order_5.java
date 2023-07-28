class Solution {
    public String lastSubstring(String s) {
        
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - 'a';
        }
        int i = 0, j = 1, k = 0;
        while (i < n && j < n && k < n) {
            int t = arr[(i + k) % n] - arr[(j + k) % n];
            if (t == 0) {
                k++;
            } else {
                if (t > 0) {
                    j += k + 1;
                } else {
                    i += k + 1;
                }
                if (i == j) {
                    j++;
                }
                k = 0;
            }
        }
        return s.substring(Math.min(i, j));
    }
}