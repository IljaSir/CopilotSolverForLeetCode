class Solution {
    public boolean isAdditiveNumber(String num) {
        
        for (int i = 0; i < num.length(); i++) {
            String s1 = num.substring(0, i + 1);
            if (s1.length() > 1 && s1.charAt(0) == '0') {
                break;
            }
            for (int j = i + 1; j < num.length(); j++) {
                String s2 = num.substring(i + 1, j + 1);
                if (s2.length() > 1 && s2.charAt(0) == '0') {
                    break;
                }
                if (isAdditiveNumber(num, s1, s2, j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isAdditiveNumber(String num, String s1, String s2, int start) {
        if (start == num.length()) {
            return true;
        }
        String s3 = String.valueOf(Long.parseLong(s1) + Long.parseLong(s2));
        if (!num.startsWith(s3, start)) {
            return false;
        }
        return isAdditiveNumber(num, s2, s3, start + s3.length());
    }
}