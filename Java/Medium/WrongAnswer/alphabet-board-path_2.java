class Solution {
    public String alphabetBoardPath(String target) {
        
        int x = 0, y = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            int c = target.charAt(i) - 'a';
            int r = c / 5, col = c % 5;
            while (x < r) {
                sb.append('D');
                x++;
            }
            while (x > r) {
                sb.append('U');
                x--;
            }
            while (y < col) {
                sb.append('R');
                y++;
            }
            while (y > col) {
                sb.append('L');
                y--;
            }
            sb.append('!');
        }
        return sb.toString();
    }
}