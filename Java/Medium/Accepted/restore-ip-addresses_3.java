class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> ans = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return ans;
        }
        for (int i = 1; i < 4; i++) {
            for (int j = i + 1; j < i + 4 && j < s.length(); j++) {
                for (int k = j + 1; k < j + 4 && k < s.length(); k++) {
                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k);
                    if (isValid(a) && isValid(b) && isValid(c) && isValid(d)) {
                        ans.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }
        return ans;
    }

    private boolean isValid(String s) {
        if (s.length() > 3) {
            return false;
        }
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
}