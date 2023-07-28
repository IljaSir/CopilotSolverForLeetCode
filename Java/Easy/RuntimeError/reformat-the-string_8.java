class Solution {
    public String reformat(String s) {
        
        int n = s.length();
        char[] chars = s.toCharArray();
        int nDigit = 0;
        int nAlpha = 0;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                nDigit++;
            } else {
                nAlpha++;
            }
        }
        if (Math.abs(nDigit - nAlpha) > 1) {
            return "";
        }
        char[] res = new char[n];
        int i = 0;
        int j = 0;
        if (nDigit > nAlpha) {
            while (i < n) {
                res[i] = chars[j];
                j += 2;
                i++;
            }
            j = 1;
            while (i < n) {
                res[i] = chars[j];
                j += 2;
                i++;
            }
        } else {
            while (i < n) {
                res[i] = chars[j];
                j += 2;
                i++;
            }
            j = 1;
            while (i < n) {
                res[i] = chars[j];
                j += 2;
                i++;
            }
        }
        return new String(res);
    }
}