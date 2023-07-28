class Solution {
    public boolean winnerOfGame(String colors) {
        
        int len = colors.length();
        int a = 0, b = 0;
        for (int i = 0; i < len - 2; i++) {
            if (colors.charAt(i) == 'A' && colors.charAt(i + 1) == 'A' && colors.charAt(i + 2) == 'A') {
                a++;
            }
            if (colors.charAt(i) == 'B' && colors.charAt(i + 1) == 'B' && colors.charAt(i + 2) == 'B') {
                b++;
            }
        }
        return a > b;
    }
}