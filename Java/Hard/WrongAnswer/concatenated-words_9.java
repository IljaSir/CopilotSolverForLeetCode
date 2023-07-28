class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (word.length() == 0) continue;
            if (isConcatenated(word, wordSet)) {
                result.add(word);
            }
        }
        return result;
    }
    
    private boolean isConcatenated(String word, Set<String> wordSet) {
        if (wordSet.contains(word)) return true;
        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (wordSet.contains(left) && isConcatenated(right, wordSet)) {
                return true;
            }
        }
        return false;
    }
}