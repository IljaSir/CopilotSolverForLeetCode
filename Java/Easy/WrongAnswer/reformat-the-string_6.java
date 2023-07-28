class Solution {
    public String reformat(String s) {
        
        char[] ch = s.toCharArray();
        int len = ch.length;
        int letter = 0;
        int digit = 0;
        for (int i = 0; i < len; i++) {
            if (Character.isLetter(ch[i])) {
                letter++;
            } else {
                digit++;
            }
        }
        if (Math.abs(letter - digit) > 1) {
            return "";
        }
        char[] res = new char[len];
        int i = 0;
        int j = 0;
        if (letter > digit) {
            while (i < len) {
                res[i] = ch[j];
                i += 2;
                j++;
            }
            i = 1;
            while (j < len) {
                res[i] = ch[j];
                i += 2;
                j++;
            }
        } else {
            while (i < len) {
                res[i] = ch[j];
                i += 2;
                j++;
            }
            i = 1;
            while (j < len) {
                res[i] = ch[j];
                i += 2;
                j++;
            }
        }
        return new String(res);
    }
}