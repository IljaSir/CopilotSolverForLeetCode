class Solution {
    public String pushDominoes(String dominoes) {
        
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                force = n;
            } else if (dominoes.charAt(i) == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            right[i] = force;
        }
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                force = n;
            } else if (dominoes.charAt(i) == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            left[i] = force;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (left[i] > right[i]) {
                sb.append('L');
            } else if (left[i] < right[i]) {
                sb.append('R');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}