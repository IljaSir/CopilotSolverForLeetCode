class Solution {
    public boolean winnerOfGame(String colors) {
        
        int a = 0;
        int b = 0;
        for (int i = 0; i < colors.length() - 2; i++) {
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