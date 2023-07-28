class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), s, 0);
        return res;
    }
    
    public void backTrack(List<String> res, List<String> temp, String s, int start) {
        if (temp.size() == 4) {
            if (start == s.length()) {
                res.add(String.join(".", temp));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) {
                break;
            }
            String sub = s.substring(start, start + i);
            if (sub.charAt(0) == '0' && sub.length() > 1) {
                break;
            }
            if (Integer.valueOf(sub) > 255) {
                break;
            }
            temp.add(sub);
            backTrack(res, temp, s, start + i);
            temp.remove(temp.size() - 1);
        }
    }
}