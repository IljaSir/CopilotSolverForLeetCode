class Solution {
    public String pushDominoes(String dominoes) {
        
        char[] chars = dominoes.toCharArray();
        int n = chars.length;
        int[] l = new int[n];
        int[] r = new int[n];
        int last = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'L') {
                last = 0;
            } else if (chars[i] == 'R') {
                last = n;
            } else {
                last = Math.max(last - 1, 0);
            }
            l[i] = last;
        }
        last = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == 'R') {
                last = 0;
            } else if (chars[i] == 'L') {
                last = n;
            } else {
                last = Math.max(last - 1, 0);
            }
            r[i] = last;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (l[i] == r[i]) {
                sb.append('.');
            } else if (l[i] < r[i]) {
                sb.append('L');
            } else {
                sb.append('R');
            }
        }
        return sb.toString();
    }
}