class Solution {
    public String alphabetBoardPath(String target) {
        
        int x = 0, y = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : target.toCharArray()) {
            int i = (c - 'a') / 5, j = (c - 'a') % 5;
            if (x < i) {
                for (int k = 0; k < i - x; k++) sb.append('D');
            } else if (x > i) {
                for (int k = 0; k < x - i; k++) sb.append('U');
            }
            if (y < j) {
                for (int k = 0; k < j - y; k++) sb.append('R');
            } else if (y > j) {
                for (int k = 0; k < y - j; k++) sb.append('L');
            }
            sb.append('!');
            x = i;
            y = j;
        }
        return sb.toString();
    }
}