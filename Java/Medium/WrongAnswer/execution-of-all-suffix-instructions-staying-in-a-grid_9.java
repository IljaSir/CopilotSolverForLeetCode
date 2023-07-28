class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int[] res = new int[s.length()];
        int x = startPos[0];
        int y = startPos[1];
        int[] dir = {0, 1, 0, -1, 0};
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                if (y - 1 >= 0) {
                    y--;
                }
            } else if (c == 'R') {
                if (y + 1 < n) {
                    y++;
                }
            } else if (c == 'U') {
                if (x - 1 >= 0) {
                    x--;
                }
            } else {
                if (x + 1 < n) {
                    x++;
                }
            }
            dp[x][y] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int count = 0;
            int x1 = startPos[0];
            int y1 = startPos[1];
            while (true) {
                char c = s.charAt(j);
                if (c == 'L') {
                    if (y1 - 1 >= 0) {
                        y1--;
                    }
                } else if (c == 'R') {
                    if (y1 + 1 < n) {
                        y1++;
                    }
                } else if (c == 'U') {
                    if (x1 - 1 >= 0) {
                        x1--;
                    }
                } else {
                    if (x1 + 1 < n) {
                        x1++;
                    }
                }
                if (dp[x1][y1] == -1) {
                    break;
                }
                j = (j + 1) % s.length();
                count++;
                if (j == i) {
                    break;
                }
            }
            res[i] = count;
        }
        return res;
    }
}