class Solution {
    public String removeStars(String s) {
        
        int n = s.length();
        char[] sArr = s.toCharArray();
        int[] left = new int[n];
        int[] right = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (sArr[i] == '*') {
                cnt++;
            }
            left[i] = cnt;
        }
        cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (sArr[i] == '*') {
                cnt++;
            }
            right[i] = cnt;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (sArr[i] == '*') {
                continue;
            }
            if (i - left[i] >= 0 && sArr[i - left[i]] == '*') {
                continue;
            }
            if (i + right[i] < n && sArr[i + right[i]] == '*') {
                continue;
            }
            sb.append(sArr[i]);
        }
        return sb.toString();
    }
}