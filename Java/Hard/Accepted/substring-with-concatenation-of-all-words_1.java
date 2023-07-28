class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;
        if (s.length() < totalLength) {
            return result;
        }
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - totalLength; i++) {
            HashMap<String, Integer> temp = new HashMap<>(wordMap);
            for (int j = 0; j < totalLength; j += wordLength) {
                String sub = s.substring(i + j, i + j + wordLength);
                if (!temp.containsKey(sub)) {
                    break;
                }
                if (temp.get(sub) == 1) {
                    temp.remove(sub);
                } else {
                    temp.put(sub, temp.get(sub) - 1);
                }
            }
            if (temp.size() == 0) {
                result.add(i);
            }
        }
        return result;
    }
}