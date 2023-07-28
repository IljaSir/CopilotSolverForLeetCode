class Solution {
    public String alphabetBoardPath(String target) {
        
        int x = 0, y = 0;
        StringBuilder sb = new StringBuilder();
        for (char c: target.toCharArray()) {
            int index = c - 'a';
            int row = index / 5, col = index % 5;
            if (row < y) {
                for (int i = 0; i < y - row; i++) {
                    sb.append('U');
                }
            } else if (row > y) {
                for (int i = 0; i < row - y; i++) {
                    sb.append('D');
                }
            }
            if (col < x) {
                for (int i = 0; i < x - col; i++) {
                    sb.append('L');
                }
            } else if (col > x) {
                for (int i = 0; i < col - x; i++) {
                    sb.append('R');
                }
            }
            sb.append('!');
            x = col;
            y = row;
        }
        return sb.toString();
    }
}