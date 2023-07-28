class Solution {
    public boolean canBeValid(String s, String locked) {
        
        int n = s.length();
        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                count[s.charAt(i) - '0']++;
            }
        }
        int balance = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                if (s.charAt(i) == '(') {
                    balance++;
                } else {
                    balance--;
                }
            }
        }
        if (balance < 0) {
            balance = -balance;
            if (count[0] < balance) {
                return false;
            }
            count[0] -= balance;
            balance = 0;
        } else {
            if (count[1] < balance) {
                return false;
            }
            count[1] -= balance;
            balance = 0;
        }
        return count[0] % 2 == 0 && count[1] % 2 == 0;
    }
}