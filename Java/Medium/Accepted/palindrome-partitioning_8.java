class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partition(s, 0, list, result);
        return result;
    }
    public void partition(String s, int start, List<String> list, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                partition(s, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}