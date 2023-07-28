class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            set.remove(word);
            if (dfs(word, set)) {
                res.add(word);
            }
            set.add(word);
        }
        return res;
    }
    private boolean dfs(String word, Set<String> set) {
        if (set.contains(word)) {
            return true;
        }
        for (int i = 1; i < word.length(); i++) {
            if (set.contains(word.substring(0, i)) && dfs(word.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
}