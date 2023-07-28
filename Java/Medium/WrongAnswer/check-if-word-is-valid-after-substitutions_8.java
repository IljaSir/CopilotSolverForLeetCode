class Solution {
    public boolean isValid(String s) {
        
        if (s.length() % 3 != 0) {
            return false;
        }
        int[] counts = new int[3];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                counts[0]++;
            } else if (c == 'b') {
                counts[1]++;
            } else {
                counts[2]++;
            }
            if (counts[1] > counts[0] || counts[2] > counts[1]) {
                return false;
            }
        }
        return counts[0] == counts[1] && counts[1] == counts[2];
    }
}