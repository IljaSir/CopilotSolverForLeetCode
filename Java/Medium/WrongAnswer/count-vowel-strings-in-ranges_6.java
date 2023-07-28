class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int[] ans = new int[queries.length];
        int[][] start = new int[words.length][5];
        int[][] end = new int[words.length][5];
        for (int i = 0; i < words.length; i++) {
            char c = words[i].charAt(0);
            if (c == 'a') {
                start[i][0] = 1;
            } else if (c == 'e') {
                start[i][1] = 1;
            } else if (c == 'i') {
                start[i][2] = 1;
            } else if (c == 'o') {
                start[i][3] = 1;
            } else if (c == 'u') {
                start[i][4] = 1;
            }
            c = words[i].charAt(words[i].length() - 1);
            if (c == 'a') {
                end[i][0] = 1;
            } else if (c == 'e') {
                end[i][1] = 1;
            } else if (c == 'i') {
                end[i][2] = 1;
            } else if (c == 'o') {
                end[i][3] = 1;
            } else if (c == 'u') {
                end[i][4] = 1;
            }
        }
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < 5; j++) {
                start[i][j] += start[i - 1][j];
                end[i][j] += end[i - 1][j];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int l = q[0], r = q[1];
            if (l == 0) {
                for (int j = 0; j < 5; j++) {
                    ans[i] += end[r][j];
                }
            } else {
                for (int j = 0; j < 5; j++) {
                    ans[i] += end[r][j] - end[l - 1][j] + start[l - 1][j];
                }
            }
        }
        return ans;
    }
}