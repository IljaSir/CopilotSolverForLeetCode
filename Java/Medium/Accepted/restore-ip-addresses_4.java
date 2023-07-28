class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        dfs(res, new ArrayList<>(), s, 0);
        return res;
    }
    
    private void dfs(List<String> res, List<String> list, String s, int start) {
        if (list.size() == 4) {
            if (start == s.length()) {
                res.add(String.join(".", list));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) {
                break;
            }
            String sub = s.substring(start, start + i);
            if (sub.length() > 1 && sub.charAt(0) == '0') {
                break;
            }
            if (Integer.parseInt(sub) > 255) {
                break;
            }
            list.add(sub);
            dfs(res, list, s, start + i);
            list.remove(list.size() - 1);
        }
    }
}