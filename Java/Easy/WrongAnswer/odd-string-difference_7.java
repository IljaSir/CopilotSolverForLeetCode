class Solution {
    public String oddString(String[] words) {
        
        int n = words.length;
        int diffLen = words[0].length() - 1;
        int[][] diffs = new int[n][diffLen];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < diffLen; j++) {
                diffs[i][j] = words[i].charAt(j + 1) - words[i].charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < n; j++) {
                if (i == j) {
                    continue;
                }
                boolean flag = true;
                for (int k = 0; k < diffLen; k++) {
                    if (diffs[i][k] != diffs[j][k]) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
            }
            if (j == n) {
                return words[i];
            }
        }
        return "";
    }
}