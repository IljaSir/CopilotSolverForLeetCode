class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < i + 4; j++) {
                for (int k = j + 1; k < j + 4; k++) {
                    if (k >= s.length()) {
                        break;
                    }
                    String s1 = s.substring(0, i + 1);
                    String s2 = s.substring(i + 1, j + 1);
                    String s3 = s.substring(j + 1, k + 1);
                    String s4 = s.substring(k + 1);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}