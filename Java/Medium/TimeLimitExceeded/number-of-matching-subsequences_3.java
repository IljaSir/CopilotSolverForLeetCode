class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : map.keySet()) {
            if (isSubsequence(s, word)) {
                count += map.get(word);
            }
        }
        return count;
    }
    
    private boolean isSubsequence(String s, String word) {
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i < word.length() && c == word.charAt(i)) {
                i++;
            }
        }
        return i == word.length();
    }
}