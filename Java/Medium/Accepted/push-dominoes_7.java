class Solution {
    public String pushDominoes(String dominoes) {
        
        char[] arr = dominoes.toCharArray();
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'L') {
                max = 0;
            } else if (arr[i] == 'R') {
                max = n;
            } else {
                max = Math.max(max - 1, 0);
            }
            left[i] = max;
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'R') {
                max = 0;
            } else if (arr[i] == 'L') {
                max = n;
            } else {
                max = Math.max(max - 1, 0);
            }
            right[i] = max;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (left[i] == right[i]) {
                sb.append('.');
            } else if (left[i] > right[i]) {
                sb.append('R');
            } else {
                sb.append('L');
            }
        }
        return sb.toString();
    }
}