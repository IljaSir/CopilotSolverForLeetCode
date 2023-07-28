class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        int wordLength = words[0].length();
        Map<String, Integer> wordToCount = new HashMap<>();
        for (String word : words) {
            wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                if (!wordToCount.containsKey(word)) {
                    left = right;
                    seen.clear();
                    count = 0;
                } else {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;
                    while (seen.get(word) > wordToCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }
                    if (count == words.length) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLength);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }
                }
            }
        }
        return result;
    }
}