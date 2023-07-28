class Solution {
    public List<String> addOperators(String num, int target) {
        
        List<String> ans = new ArrayList<>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            String prefix = num.substring(0, i + 1);
            if (prefix.length() > 1 && prefix.charAt(0) == '0') {
                break;
            }
            long prefixVal = Long.parseLong(prefix);
            String rest = num.substring(i + 1);
            dfs(rest, target, prefixVal, prefixVal, prefix, ans);
        }
        return ans;
    }
    private void dfs(String num, int target, long curVal, long prev, String expr, List<String> ans) {
        if (num.length() == 0 && curVal == target) {
            ans.add(expr);
            return;
        }
        for (int i = 0; i < num.length(); i++) {
            String prefix = num.substring(0, i + 1);
            if (prefix.length() > 1 && prefix.charAt(0) == '0') {
                break;
            }
            long prefixVal = Long.parseLong(prefix);
            String rest = num.substring(i + 1);
            dfs(rest, target, curVal + prefixVal, prefixVal, expr + "+" + prefix, ans);
            dfs(rest, target, curVal - prefixVal, -prefixVal, expr + "-" + prefix, ans);
            dfs(rest, target, curVal - prev + prev * prefixVal, prev * prefixVal, expr + "*" + prefix, ans);
        }
    }
}