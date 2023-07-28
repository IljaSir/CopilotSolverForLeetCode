class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int[] res = new int[s.length()];
        int[] x = new int[] {0, 0, 1, -1};
        int[] y = new int[] {1, -1, 0, 0};
        int[] count = new int[4];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = 0;
            if (c == 'R') {
                index = 0;
            } else if (c == 'L') {
                index = 1;
            } else if (c == 'D') {
                index = 2;
            } else if (c == 'U') {
                index = 3;
            }
            count[index]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'R') {
                res[i] = count[0] - 1;
                res[i] += Math.min(startPos[1] + count[0], n - 1 - startPos[1]);
            } else if (c == 'L') {
                res[i] = count[1] - 1;
                res[i] += Math.min(startPos[1] + count[1], n - 1 - startPos[1]);
            } else if (c == 'D') {
                res[i] = count[2] - 1;
                res[i] += Math.min(startPos[0] + count[2], n - 1 - startPos[0]);
            } else if (c == 'U') {
                res[i] = count[3] - 1;
                res[i] += Math.min(startPos[0] + count[3], n - 1 - startPos[0]);
            }
        }
        return res;
    }
}