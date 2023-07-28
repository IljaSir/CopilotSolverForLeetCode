class Solution {
    public String findTheString(int[][] lcp) {
        
        int n = lcp.length;
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = 'a';
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] == 0) {
                    continue;
                }
                int len = lcp[i][j];
                if (chars[i] == chars[j]) {
                    if (chars[i] == 'z') {
                        return "";
                    }
                    chars[i] = (char)(chars[i] + 1);
                    chars[j] = chars[i];
                    for (int k = i + 1; k < j; k++) {
                        chars[k] = chars[j];
                    }
                } else {
                    for (int k = i + len; k < j; k++) {
                        chars[k] = chars[j];
                    }
                }
            }
        }
        return new String(chars);
    }
}