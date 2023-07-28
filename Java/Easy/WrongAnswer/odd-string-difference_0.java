class Solution {
    public String oddString(String[] words) {
        
        int n = words[0].length();
        int[][] diff = new int[words.length][n - 1];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < n - 1; j++) {
                diff[i][j] = words[i].charAt(j + 1) - words[i].charAt(j);
            }
        }
        for (int i = 1; i < words.length; i++) {
            if (Arrays.equals(diff[0], diff[i])) {
                continue;
            } else {
                return words[i];
            }
        }
        return words[0];
    }
}