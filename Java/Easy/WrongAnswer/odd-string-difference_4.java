class Solution {
    public String oddString(String[] words) {
        
        int n = words[0].length();
        int[][] difference = new int[words.length][n - 1];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < n - 1; j++) {
                difference[i][j] = words[i].charAt(j + 1) - words[i].charAt(j);
            }
        }
        int[] diff = difference[0];
        boolean isSame = true;
        for (int i = 1; i < difference.length; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (difference[i][j] != diff[j]) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                return words[i];
            }
            isSame = true;
        }
        return words[0];
    }
}