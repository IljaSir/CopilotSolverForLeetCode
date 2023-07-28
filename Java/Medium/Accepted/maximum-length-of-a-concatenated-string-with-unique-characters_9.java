class Solution {
    public int maxLength(List<String> arr) {
        
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            if (isUnique(s)) {
                list.add(s);
            }
        }
        return dfs(list, 0, "");
    }
    
    private int dfs(List<String> list, int index, String s) {
        if (index == list.size()) {
            return s.length();
        }
        int max = dfs(list, index + 1, s);
        if (isUnique(s + list.get(index))) {
            max = Math.max(max, dfs(list, index + 1, s + list.get(index)));
        }
        return max;
    }
    
    private boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}