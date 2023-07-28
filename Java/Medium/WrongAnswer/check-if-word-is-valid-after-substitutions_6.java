class Solution {
    public boolean isValid(String s) {
        
        if (s.length() % 3 != 0) {
            return false;
        }
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                count++;
            } else if (c == 'b') {
                count--;
            } else {
                if (count != 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}