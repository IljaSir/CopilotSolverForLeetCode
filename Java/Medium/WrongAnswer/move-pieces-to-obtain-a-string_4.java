class Solution {
    public boolean canChange(String start, String target) {
        
        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != target.charAt(i)) {
                if (start.charAt(i) == 'L') {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return count == 0;
    }
}