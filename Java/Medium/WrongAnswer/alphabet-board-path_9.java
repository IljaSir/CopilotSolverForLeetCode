class Solution {
    public String alphabetBoardPath(String target) {
        
        int[] pos = {0, 0};
        StringBuilder sb = new StringBuilder();
        for (char c: target.toCharArray()) {
            int[] next = getPos(c);
            int dx = next[0] - pos[0];
            int dy = next[1] - pos[1];
            if (dx < 0) {
                for (int i = 0; i < -dx; i++) sb.append('U');
            } else if (dx > 0) {
                for (int i = 0; i < dx; i++) sb.append('D');
            }
            if (dy < 0) {
                for (int i = 0; i < -dy; i++) sb.append('L');
            } else if (dy > 0) {
                for (int i = 0; i < dy; i++) sb.append('R');
            }
            sb.append('!');
            pos = next;
        }
        return sb.toString();
    }
    
    int[] getPos(char c) {
        int[] pos = new int[2];
        if (c == 'z') {
            pos[0] = 5;
            pos[1] = 0;
        } else {
            pos[0] = (c - 'a') / 5;
            pos[1] = (c - 'a') % 5;
        }
        return pos;
    }
}