class Solution {
    public String oddString(String[] words) {
        
        int n = words.length;
        int[][] diff = new int[n][];
        for (int i = 0; i < n; i++) {
            diff[i] = new int[words[i].length() - 1];
            for (int j = 0; j < words[i].length() - 1; j++) {
                diff[i][j] = words[i].charAt(j + 1) - words[i].charAt(j);
            }
        }
        for (int i = 1; i < n; i++) {
            if (!Arrays.equals(diff[0], diff[i])) {
                return words[i];
            }
        }
        return words[0];
    }
}