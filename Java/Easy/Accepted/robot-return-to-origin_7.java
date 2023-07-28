class Solution {
    public boolean judgeCircle(String moves) {
        
        int[] pos = {0, 0};
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'U':
                    pos[1]++;
                    break;
                case 'D':
                    pos[1]--;
                    break;
                case 'L':
                    pos[0]--;
                    break;
                case 'R':
                    pos[0]++;
                    break;
                default:
                    break;
            }
        }
        return pos[0] == 0 && pos[1] == 0;
    }
}