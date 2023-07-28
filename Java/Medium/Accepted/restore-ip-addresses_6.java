class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        dfs(s, 0, new ArrayList<String>(), res);
        return res;
    }
    private void dfs(String s, int start, List<String> list, List<String> res) {
        // base case
        if (list.size() == 4) {
            if (start == s.length()) {
                res.add(String.join(".", list));
            }
            return;
        }
        // recursive rule
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) break;
            String str = s.substring(start, start + i);
            if (i == 2 && str.charAt(0) == '0' || i == 3 && (str.charAt(0) == '0' || Integer.valueOf(str) > 255)) continue;
            list.add(str);
            dfs(s, start + i, list, res);
            list.remove(list.size() - 1);
        }
    }
}