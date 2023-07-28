class Solution {
    public String oddString(String[] words) {
        
        int n = words.length;
        int m = words[0].length();
        int[][] diffs = new int[n][m - 1];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 0; j < m - 1; j++) {
                diffs[i][j] = word.charAt(j + 1) - word.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            boolean isOdd = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (Arrays.equals(diffs[i], diffs[j])) {
                    isOdd = false;
                    break;
                }
            }
            if (isOdd) {
                return words[i];
            }
        }
        return "";
    }
}