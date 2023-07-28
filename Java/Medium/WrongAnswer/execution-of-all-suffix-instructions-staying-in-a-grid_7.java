class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int[] ans = new int[s.length()];
        int[] nextPos = new int[2];
        for (int i = 0; i < s.length(); i++) {
            nextPos[0] = startPos[0];
            nextPos[1] = startPos[1];
            switch (s.charAt(i)) {
                case 'L':
                    nextPos[1]--;
                    break;
                case 'R':
                    nextPos[1]++;
                    break;
                case 'U':
                    nextPos[0]--;
                    break;
                case 'D':
                    nextPos[0]++;
                    break;
            }
            if (nextPos[0] < 0 || nextPos[0] >= n || nextPos[1] < 0 || nextPos[1] >= n) {
                ans[i] = 0;
            } else {
                ans[i] = s.length() - i;
            }
        }
        return ans;
    }
}