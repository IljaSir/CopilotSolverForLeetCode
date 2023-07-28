class Solution {
    public String alphabetBoardPath(String target) {
        
        StringBuilder sb = new StringBuilder();
        int r = 0, c = 0;
        for (char ch : target.toCharArray()) {
            int x = (ch - 'a') / 5, y = (ch - 'a') % 5;
            if (x > r) {
                for (int i = 0; i < x - r; i++) {
                    sb.append('D');
                }
            } else {
                for (int i = 0; i < r - x; i++) {
                    sb.append('U');
                }
            }
            if (y > c) {
                for (int i = 0; i < y - c; i++) {
                    sb.append('R');
                }
            } else {
                for (int i = 0; i < c - y; i++) {
                    sb.append('L');
                }
            }
            sb.append('!');
            r = x;
            c = y;
        }
        return sb.toString();
    }
}