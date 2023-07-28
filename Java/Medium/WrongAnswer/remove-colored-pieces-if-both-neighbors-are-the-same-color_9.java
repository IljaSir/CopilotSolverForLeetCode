class Solution {
    public boolean winnerOfGame(String colors) {
        
        int n = colors.length();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + (colors.charAt(i - 1) == colors.charAt(i) ? 1 : 0);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (colors.charAt(i + 1) == colors.charAt(i) ? 1 : 0);
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (colors.charAt(i) == 'A') {
                a += left[i] * right[i];
            } else {
                b += left[i] * right[i];
            }
        }
        return a > b;
    }
}