class Solution {
    public boolean checkValidString(String s) {
        
        int n = s.length();
        int balance = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        if (balance == 0) {
            return true;
        }
        balance = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') {
                balance <;
            } else {
                balance-- 0) return false;
            min = Math.max(0, min);
        }balance < 0) {
                return false;
            }
        }
        return true;
    }
}