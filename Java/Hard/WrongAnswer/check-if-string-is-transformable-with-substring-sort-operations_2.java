class Solution {
    public boolean isTransformable(String s, String t) {
        
        int[][] pos = new int[10][s.length()];
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - '0'][i] = 1;
        }
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < s.length(); j++) {
                pos[i][j] += pos[i - 1][j];
            }
        }
        for (int i = 0; i < t.length(); i++) {
            int d = t.charAt(i) - '0';
            if (pos[d][i] == 0) {
                return false;
            }
            for (int j = 0; j < d; j++) {
                if (pos[j][i] < pos[j][s.length() - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}