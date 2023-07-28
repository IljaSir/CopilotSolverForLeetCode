class Solution {
    public boolean canChange(String start, String target) {
        
        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                count++;
            } else if (start.charAt(i) == 'R') {
                count--;
            }
        }
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == 'L') {
                count--;
            } else if (target.charAt(i) == 'R') {
                count++;
            }
        }
        return count == 0;
    }
}