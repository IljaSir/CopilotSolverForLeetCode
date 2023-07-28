class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> result = new ArrayList<>();
        if (s.length() > 12 || s.length() < 4) {
            return result;
        }
        backtracking(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtracking(String s, int start, List<String> path, List<String> result) {
        if (path.size() == 4 && start == s.length()) {
            result.add(String.join(".", path));
            return;
        }
        if (path.size() == 4) {
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (sub.length() > 1 && sub.startsWith("0")) {
                return;
            }
            if (Integer.parseInt(sub) > 255) {
                return;
            }
            path.add(sub);
            backtracking(s, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}