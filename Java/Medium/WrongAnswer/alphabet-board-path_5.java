class Solution {
    public String alphabetBoardPath(String target) {
        
        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0;
        for (char c : target.toCharArray()) {
            int idx = c - 'a';
            int nx = idx / 5, ny = idx % 5;
            while (x > nx) {
                sb.append('U');
                x--;
            }
            while (x < nx) {
                sb.append('D');
                x++;
            }
            while (y > ny) {
                sb.append('L');
                y--;
            }
            while (y < ny) {
                sb.append('R');
                y++;
            }
            sb.append('!');
        }
        return sb.toString();
    }
}