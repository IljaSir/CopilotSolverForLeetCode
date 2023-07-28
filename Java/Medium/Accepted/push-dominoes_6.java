class Solution {
    public String pushDominoes(String dominoes) {
        
        char[] domino = dominoes.toCharArray();
        int n = domino.length;
        int[] force = new int[n];
        int f = 0;
        for (int i = 0; i < n; i++) {
            if (domino[i] == 'R') {
                f = n;
            } else if (domino[i] == 'L') {
                f = 0;
            } else {
                f = Math.max(f - 1, 0);
            }
            force[i] += f;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (domino[i] == 'L') {
                f = n;
            } else if (domino[i] == 'R') {
                f = 0;
            } else {
                f = Math.max(f - 1, 0);
            }
            force[i] -= f;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (force[i] > 0) {
                sb.append('R');
            } else if (force[i] < 0) {
                sb.append('L');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}