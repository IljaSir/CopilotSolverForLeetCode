class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int[] result = new int[s.length()];
        int[] dir = new int[]{0, 1, 0, -1, 0};
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = 0;
            if (c == 'L') {
                index = 3;
            } else if (c == 'R') {
                index = 1;
            } else if (c == 'U') {
                index = 0;
            } else {
                index = 2;
            }
            int x = startPos[0] + dir[index];
            int y = startPos[1] + dir[index + 1];
            if (x >= 0 && x < n && y >= 0 && y < n) {
                result[i] = 1;
                startPos[0] = x;
                startPos[1] = y;
            }
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            result[i] += result[i + 1];
        }
        return result;
    }
}