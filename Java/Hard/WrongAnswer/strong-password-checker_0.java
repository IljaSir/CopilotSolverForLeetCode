class Solution {
    public int strongPasswordChecker(String password) {
        
        int missingType = 3;
        if (password.matches(".*[a-z].*")) missingType--;
        if (password.matches(".*[A-Z].*")) missingType--;
        if (password.matches(".*[0-9].*")) missingType--;
        
        int res = 0;
        if (password.length() < 6) {
            res = missingType + Math.max(0, 6 - password.length() - missingType);
        } else {
            int overLen = Math.max(password.length() - 20, 0), leftOver = 0;
            res += overLen;
            
            // one pass to delete all repeating characters
            for (int i = 0, j = 0; i < password.length(); i = j) {
                while (j < password.length() && password.charAt(i) == password.charAt(j)) j++;
                int len = j - i;
                if (len >= 3) {
                    res += len / 3;
                    if (len % 3 == 0) leftOver++; // can be used to replace one missing type
                }
            }
            
            // if we still have overLen, then we must replace some characters
            if (overLen > 0) {
                int needReplace = overLen;
                // try to use leftOver first
                if (leftOver > 0) {
                    int replaceByLeftOver = Math.min(needReplace, leftOver);
                    needReplace -= replaceByLeftOver;
                    res -= replaceByLeftOver;
                }
                // then replace the rest
                res += needReplace;
            }
            
            // if we still don't have enough types
            if (missingType > 0) {
                res += Math.max(missingType, overLen);
            }
        }
        
        return res;
    }
}