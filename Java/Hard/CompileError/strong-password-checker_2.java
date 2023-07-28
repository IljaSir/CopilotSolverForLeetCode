class Solution {
    public int strongPasswordChecker(String password) {
        
        int n = password.length();
        int missingType = 3;
        if (password.matches(".*[a-z].*")) missingType--;
        if (password.matches(".*[A-Z].*")) missingType--;
        if (password.matches(".*[0-9].*")) missingType--;
        
        int totalReplace = 0, oneReplace = 0, twoReplace = 0;
        for (int i = 2, length = 2, start = 0; i < n; i++) {
            if (password.charAt(i) == password.charAt(i - 1) && password.charAt(i - 1) == password.charAt(i - 2)) {
                if (length == 2) start = i - 2;
                length++;
            } else {
                if (length >= 3) {
                    totalReplace += length / 3;
                    if (length % 3 == 0) oneReplace++;
                    else if (length % 3 == 1) twoReplace++;
                }
                length = 2;
            }
        }
        
        if (length >= 3) {
            totalReplace += length / 3;
            if (length % 3 == 0) oneReplace++;
            else if (length % 3 == 1) twoReplace++;
        }
        
        if (n < 6) {
            return Math.max(missingType, 6 - n);
        } else if (n <= 20) {
            return Math.max(missingType, totalReplace);
        } else {
            int delete = n - 20;
            totalReplace -= Math.min(delete, oneReplace);
            totalReplace -= Math.min(Math.max(delete - oneReplace, 0), twoReplace * 2) / 2;
            totalReplace -= Math.max(delete - oneReplace - 2 * twoReplace, 0) / 3;
            return delete + Math.max(missingType, totalReplace);
        }
    }
}