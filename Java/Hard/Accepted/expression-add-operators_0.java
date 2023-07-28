class Solution {
    public List<String> addOperators(String num, int target) {
        
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        dfs(num, target, 0, 0, 0, "", result);
        return result;
    }
    
    private void dfs(String num, int target, int index, long prev, long multi, String path, List<String> result) {
        if (index == num.length()) {
            if (target == prev) {
                result.add(path);
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            long cur = Long.parseLong(num.substring(index, i + 1));
            if (index != i && num.charAt(index) == '0') {
                break;
            }
            if (index == 0) {
                dfs(num, target, i + 1, cur, cur, path + cur, result);
            } else {
                dfs(num, target, i + 1, prev + cur, cur, path + "+" + cur, result);
                dfs(num, target, i + 1, prev - cur, -cur, path + "-" + cur, result);
                dfs(num, target, i + 1, prev - multi + multi * cur, multi * cur, path + "*" + cur, result);
            }
        }
    }
}