class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> result = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        helper(result, s, 0, 0, "");
        return result;
    }
    private void helper(List<String> result, String s, int start, int part, String ip) {
        if (part == 4) {
            if (start == s.length()) {
                result.add(ip);
            }
            return;
        }
        if (start == s.length()) {
            return;
        }
        int num = 0;
        for (int i = start; i < start + 3; i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num <= 255) {
                helper(result, s, i + 1, part + 1, ip + num + (part == 3 ? "" : "."));
            }
            if (num == 0) {
                break;
            }
        }
    }
}