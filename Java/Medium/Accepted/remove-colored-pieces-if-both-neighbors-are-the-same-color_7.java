class Solution {
    public boolean winnerOfGame(String colors) {
        
        int n = colors.length();
        int countA = 0;
        int countB = 0;
        for(int i = 1; i < n - 1; i++) {
            if(colors.charAt(i) == 'A' && colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A') {
                countA++;
            }
            if(colors.charAt(i) == 'B' && colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B') {
                countB++;
            }
        }
        return countA > countB;
    }
}