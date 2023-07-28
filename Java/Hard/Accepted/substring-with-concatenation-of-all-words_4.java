class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> tempMap = new HashMap<>();
            int j = i;
            while (j <= i + totalLength - wordLength) {
                String subString = s.substring(j, j + wordLength);
                if (wordMap.containsKey(subString)) {
                    tempMap.put(subString, tempMap.getOrDefault(subString, 0) + 1);
                    if (tempMap.get(subString) > wordMap.get(subString)) {
                        break;
                    }
                } else {
                    break;
                }
                j += wordLength;
            }
            if (j == i + totalLength) {
                result.add(i);
            }
        }
        return result;
    }
}