class Solution {
    public String reformat(String s) {
        
        char[] chars = s.toCharArray();
        int digits = 0;
        int letters = 0;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                digits++;
            } else {
                letters++;
            }
        }
        if (Math.abs(digits - letters) > 1) {
            return "";
        }
        char[] result = new char[chars.length];
        int j = 0;
        int k = 1;
        if (digits > letters) {
            for (int i = 0; i < chars.length; i++) {
                if (Character.isDigit(chars[i])) {
                    result[j] = chars[i];
                    j += 2;
                } else {
                    result[k] = chars[i];
                    k += 2;
                }
            }
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (Character.isDigit(chars[i])) {
                    result[k] = chars[i];
                    k += 2;
                } else {
                    result[j] = chars[i];
                    j += 2;
                }
            }
        }
        return new String(result);
    }
}