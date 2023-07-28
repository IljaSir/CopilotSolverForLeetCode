class Solution {
    public boolean canChange(String start, String target) {
        
        int countL = 0, countR = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                countL++;
            } else if (start.charAt(i) == 'R') {
                countR++;
            }
            if (target.charAt(i) == 'L') {
                countL--;
            } else if (target.charAt(i) == 'R') {
                countR--;
            }
            if (countL < 0 || countR < 0) {
                return false;
            }
        }
        return countL == 0 && countR == 0;
    }
}