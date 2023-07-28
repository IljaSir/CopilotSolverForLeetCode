class Solution {
    public String alphabetBoardPath(String target) {
        
        int r = 0;
        int c = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : target.toCharArray()) {
            int pos = ch - 'a';
            int nr = pos / 5;
            int nc = pos % 5;
            if (nr < r) {
                while (nr < r) {
                    sb.append('U');
                    r--;
                }
            } else if (nr > r) {
                while (nr > r) {
                    sb.append('D');
                    r++;
                }
            }
            if (nc < c) {
                while (nc < c) {
                    sb.append('L');
                    c--;
                }
            } else if (nc > c) {
                while (nc > c) {
                    sb.append('R');
                    c++;
                }
            }
            sb.append('!');
        }
        return sb.toString();
    }
}