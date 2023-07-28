class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> result = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        restoreIpAddresses(s, 0, 0, "", result);
        return result;
    }
    private void restoreIpAddresses(String s, int start, int part, String ip, List<String> result) {
        if (part == 4 && start == s.length()) {
            result.add(ip.substring(0, ip.length() - 1));
            return;
        }
        if (part == 4 || start == s.length()) {
            return;
        }
        if (s.charAt(start) == '0') {
            restoreIpAddresses(s, start + 1, part + 1, ip + "0.", result);
        } else {
            int num = 0;
            for (int i = start; i < start + 3 && i < s.length(); i++) {
                num = num * 10 + (s.charAt(i) - '0');
                if (num <= 255) {
                    restoreIpAddresses(s, i + 1, part + 1, ip + num + ".", result);
                }
            }
        }
    }
}