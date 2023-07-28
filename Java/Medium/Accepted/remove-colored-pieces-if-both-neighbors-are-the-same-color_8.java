class Solution {
    public boolean winnerOfGame(String colors) {
        
        int n = colors.length();
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && colors.charAt(j) == colors.charAt(i)) {
                j++;
            }
            if (j - i > 2) {
                if (colors.charAt(i) == 'A') {
                    a += j - i - 2;
                } else {
                    b += j - i - 2;
                }
            }
            i = j - 1;
        }
        return a > b;
    }
}