class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int m = s.length();
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int x = startPos[0], y = startPos[1];
            int j = i;
            while (j < m && x >= 0 && x < n && y >= 0 && y < n) {
                if (s.charAt(j) == 'L') {
                    y--;
                } else if (s.charAt(j) == 'R') {
                    y++;
                } else if (s.charAt(j) == 'U') {
                    x--;
                } else {
                    x++;
                }
                j++;
            }
            ans[i] = j - i;
        }
        return ans;
    }
}