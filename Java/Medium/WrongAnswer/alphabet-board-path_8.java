class Solution {
    public String alphabetBoardPath(String target) {
        
        int[] pos = new int[2];
        StringBuilder sb = new StringBuilder();
        for (char c : target.toCharArray()) {
            int[] dest = getPos(c);
            while (pos[0] != dest[0] || pos[1] != dest[1]) {
                if (pos[0] < dest[0]) {
                    pos[0]++;
                    sb.append('D');
                } else if (pos[0] > dest[0]) {
                    pos[0]--;
                    sb.append('U');
                } else if (pos[1] < dest[1]) {
                    pos[1]++;
                    sb.append('R');
                } else if (pos[1] > dest[1]) {
                    pos[1]--;
                    sb.append('L');
                }
            }
            sb.append('!');
        }
        return sb.toString();
    }
    private int[] getPos(char c) {
        int[] pos = new int[2];
        if (c == 'z') {
            pos[0] = 5;
            pos[1] = 0;
            return pos;
        }
        pos[0] = (c - 'a') / 5;
        pos[1] = (c - 'a') % 5;
        return pos;
    }
}