class Solution {
    public List<String> addOperators(String num, int target) {
        
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        helper(result, "", num, target, 0, 0, 0);
        return result;
    }
    
    private void helper(List<String> result, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval) result.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(result, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(result, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                helper(result, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                helper(result, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}