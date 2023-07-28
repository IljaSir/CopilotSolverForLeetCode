class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(res, list, s, 0, s.length());
        return res;
    }
    
    private void dfs(List<List<String>> res, List<String> list, String s, int start, int end) {
        if (start == end) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < end; i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                dfs(res, list, s, i + 1, end);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}