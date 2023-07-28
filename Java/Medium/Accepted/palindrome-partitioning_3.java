class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), s, 0);
        return result;
    }
    
    private void dfs(List<List<String>> result, List<String> list, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                dfs(result, list, s, i + 1);
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