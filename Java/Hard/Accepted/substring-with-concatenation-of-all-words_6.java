class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) return result;
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - totalLen; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (!wordMap.containsKey(word)) break;
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                if (seen.get(word) > wordMap.get(word)) break;
                j++;
            }
            if (j == words.length) result.add(i);
        }
        return result;
    }
}