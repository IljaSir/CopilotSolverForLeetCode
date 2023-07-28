class Solution {
    public int strongPasswordChecker(String password) {
        
        int n = password.length();
        int[] lower = new int[1];
        int[] upper = new int[1];
        int[] digit = new int[1];
        int missingType = 3;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower[0] = 1;
            }
            if (Character.isUpperCase(c)) {
                upper[0] = 1;
            }
            if (Character.isDigit(c)) {
                digit[0] = 1;
            }
            missingType -= lower[0] + upper[0] + digit[0];
        }
        if (n < 6) {
            return Math.max(6 - n, missingType);
        }
        int overLen = Math.max(n - 20, 0);
        int leftOver = 0;
        int[] one = new int[1];
        int[] two = new int[1];
        for (int i = 0, j = 0; j < n; j++) {
            if (password.charAt(i) == password.charAt(j)) {
                if (j - i == 2) {
                    one[0]++;
                }
                if (j - i == 3) {
                    two[0]++;
                }
            } else {
                i = j;
            }
        }
        int needDelete = overLen;
        needDelete -= Math.min(one[0], overLen);
        needDelete -= Math.min(two[0] * 2, overLen - needDelete) / 2;
        needDelete -= Math.min((overLen - needDelete) / 3, one[0] + two[0]);
        int needReplace = Math.max(overLen - needDelete, 0);
        return overLen + Math.max(missingType, needReplace);
    }
}