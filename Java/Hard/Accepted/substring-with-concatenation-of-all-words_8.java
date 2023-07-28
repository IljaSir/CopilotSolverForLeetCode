class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> result = new ArrayList<>();
        if(words.length == 0) return result;
        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        // count each word
        Map<String, Integer> count = new HashMap<>();
        for(String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for(int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            for(j = 0; j < words.length; j++) {
                String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                if(!count.containsKey(word)) break;
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                if(seen.get(word) > count.get(word)) break;
            }
            if(j == words.length) result.add(i);
        }
        return result;
    }
}