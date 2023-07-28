class Solution {
    public String alphabetBoardPath(String target) {
        
        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0;
        for (char c : target.toCharArray()) {
            int i = (c - 'a') / 5;
            int j = (c - 'a') % 5;
            while (y < i) {
                sb.append("D");
                y++;
            }
            while (y > i) {
                sb.append("U");
                y--;
            }
            while (x < j) {
                sb.append("R");
                x++;
            }
            while (x > j) {
                sb.append("L");
                x--;
            }
            sb.append("!");
        }
        return sb.toString();
    }
}