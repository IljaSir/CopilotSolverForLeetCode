class Solution {
    public String oddString(String[] words) {
        
        int n = words[0].length();
        int[][] diffs = new int[words.length][n - 1];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < n - 1; j++) {
                diffs[i][j] = words[i].charAt(j + 1) - words[i].charAt(j);
            }
        }
        for (int i = 0; i < words.length; i++) {
            boolean isOdd = true;
            for (int j = 0; j < words.length; j++) {
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